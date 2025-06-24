package org.example

import org.gradle.api.provider.Provider
import org.jetbrains.kotlin.gradle.plugin.*

class MyPlugin : KotlinCompilerPluginSupportPlugin {
    override fun applyToCompilation(
        kotlinCompilation: KotlinCompilation<*>
    ): Provider<List<SubpluginOption>> {
        return kotlinCompilation.target.project.provider {
            listOf(SubpluginOption("enabled", "true"))
        }
    }

    override fun getCompilerPluginId(): String {
        return "my.plugin.id"
    }

    override fun getPluginArtifact(): SubpluginArtifact {
        return SubpluginArtifact("com.example", "my-compiler-plugin", "1.0.0")
    }

    override fun isApplicable(kotlinCompilation: KotlinCompilation<*>): Boolean {
        return true
    }

}