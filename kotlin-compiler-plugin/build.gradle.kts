plugins {
    kotlin("jvm")
    `maven-publish`
}

group = "com.example"
version = "1.0.0"

// ✅ 发布配置（注意 `from(components["java"])` 只适用于 JVM 项目）
publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"]) // 自动包含 jar 和 pom
            groupId = project.group.toString()
            artifactId = "my-compiler-plugin"
            version = project.version.toString()
        }
    }

    // 可选：默认就是 mavenLocal
    repositories {
        mavenLocal()
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("compiler-embeddable"))
    testImplementation(kotlin("test"))
}

// publish to mavenLocal

// for META-INF/services
tasks.withType<Jar> {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}