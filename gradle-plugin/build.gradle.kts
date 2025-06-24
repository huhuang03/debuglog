plugins {
    kotlin("jvm")
    `java-gradle-plugin`
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
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