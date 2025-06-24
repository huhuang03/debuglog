plugins {
    kotlin("jvm")
    `java-gradle-plugin`
    `maven-publish`
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

publishing {
    publications {
        // gradlePlugin 已经自动声明了 publication，这里可以不用手动定义
    }
    repositories {
        mavenLocal() // ✅ 关键：允许发布到本地仓库
    }
}

dependencies {
    implementation(kotlin("gradle-plugin-api"))
    testImplementation(kotlin("test"))
}

gradlePlugin {
    plugins {
        create("myKcpGradlePlugin") {
            id = "com.example.myplugin"
            implementationClass = "com.example.MyPlugin"
        }
    }
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}