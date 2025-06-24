pluginManagement {
    repositories {
        mavenLocal() // ✅ 关键：让 Gradle 能从本地仓库加载插件
        gradlePluginPortal() // 可选，保留官方插件支持
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
rootProject.name = "debuglog"
include("gradle-plugin")
include("kotlin-compiler-plugin")
include("example")
