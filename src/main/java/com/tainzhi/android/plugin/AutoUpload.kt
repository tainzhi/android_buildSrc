package com.tainzhi.android.plugin

import com.android.build.gradle.AppExtension
import org.gradle.api.Action
import org.gradle.api.Plugin
import org.gradle.api.Project
import java.io.File

/**
 * File:     Upload
 * Author:   tainzhi
 * Created:  2020/12/30 16:48
 * Mail:     QFQ61@qq.com
 * Description:
 */
class UploadPgy : Plugin<Project> {

    private var flavor = "pgy"
    private var buildType = "release"
    private var configName = "uploadConfig"
    override fun apply(project: Project) {
        project.extensions.create(configName, UpLoadPgyConfig::class.java)
        val config = project.extensions.getByName(configName) as UpLoadPgyConfig
        project.afterEvaluate {
            this.task("UploadPgy") {
                this.description = "upload release apk to 蒲公英"
                this.group = "upload pyg"
                var outputStr = ""
                var outputFile: File? = null
                project.extensions.getByType(AppExtension::class.java)
                    .applicationVariants.forEach {
                        it.outputs.forEach { output ->
                            if (output.name.equals("$flavor-$buildType")) {
                                outputStr = output.name
                                outputFile = output.outputFile
                            }
                        }
                    }
                outputFile?.let { file ->
                    println("--------------------------outputfile-------------------------------------")
                    // this.dependsOn("assemble${flavor}${buildType}").also {
                    this.dependsOn("assemblePgyDebug").also {
                        it.actions.add(Action {
                            println("begin upload")
                            dispatchUpload(file, config)
                        })
                    }
                }
            }
        }
    }

    private fun dispatchUpload(outFile: File, config: UpLoadPgyConfig) {
        UpLoader().upload(outFile, config).also {
            println(
                """
---------------------------------------------------------------------------------------------------
                                         upload success
---------------------------------------------------------------------------------------------------
${this}
            """.trimIndent()
            )
        }
    }
}

