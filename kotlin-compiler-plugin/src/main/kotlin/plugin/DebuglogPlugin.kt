package org.example.plugin

import org.jetbrains.kotlin.backend.common.extensions.IrGenerationExtension
import org.jetbrains.kotlin.backend.common.extensions.IrPluginContext
import org.jetbrains.kotlin.compiler.plugin.CompilerPluginRegistrar
import org.jetbrains.kotlin.compiler.plugin.ExperimentalCompilerApi
import org.jetbrains.kotlin.config.CompilerConfiguration
import org.jetbrains.kotlin.ir.declarations.IrModuleFragment

/**
 * @author wenfan.hu
 */
@OptIn(ExperimentalCompilerApi::class)
class DebuglogPlugin : CompilerPluginRegistrar() {
    override val supportsK2: Boolean
        get() = true

    override fun ExtensionStorage.registerExtensions(configuration: CompilerConfiguration) {
        println("haaa")
        throw RuntimeException("here")
        println("✅ CompilerPluginRegistrar 注册插件中") // ⬅️ 这里加打印
        IrGenerationExtension.registerExtension(MyIrGenerationExtension())
    }
}

class MyIrGenerationExtension : IrGenerationExtension {
    override fun generate(moduleFragment: IrModuleFragment, pluginContext: IrPluginContext) {
        println("✅ MyIrGenerationExtension running!")
    }
}