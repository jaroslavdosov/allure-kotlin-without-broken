package io.qameta.allure.android

import android.os.Environment
import io.qameta.allure.kotlin.AllureLifecycle
import io.qameta.allure.kotlin.FileSystemResultsWriter
import io.qameta.allure.kotlin.util.PropertiesUtils
import java.io.File

object AllureAndroidLifecycle : AllureLifecycle(writer = FileSystemResultsWriter(obtainResultsDirectory()))

/**
 * Obtains results directory as a [File] reference.
 * It takes into consideration the results directory specified via **allure.results.directory** property.
 */
private fun obtainResultsDirectory(): File {
    val defaultAllurePath = PropertiesUtils.resultsDirectoryPath
    return File(Environment.getExternalStorageDirectory(), defaultAllurePath)
}