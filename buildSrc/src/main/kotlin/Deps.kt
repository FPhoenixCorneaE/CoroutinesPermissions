import java.text.SimpleDateFormat
import java.util.*

/**
 * @desc：所有依赖库按照规范写在这里，用到的地方，通过 Deps 引用即可。在添加依赖之前，请检查该文件中是否已存在相
 *        同的依赖，如若已经添加相同依赖，则无需再重复添加，请注意。
 * @date：2022/06/12 13:21
 */
object Deps {

    const val applicationId = "com.fphoenixcorneae.permissions.demo"

    object FPhoenixCorneaE {

    }

    object PluginIds {
        const val application = "com.android.application"
        const val library = "com.android.library"
        const val kotlin = "org.jetbrains.kotlin.android"
        const val kotlinAndroid = "android"
        const val kotlinParcelize = "kotlin-parcelize"
        const val kotlinKapt = "kapt"
    }

    object Versions {
        const val compileSdkVersion = 32
        const val buildToolsVersion = "32.0.0"
        const val minSdkVersion = 21
        const val targetSdkVersion = 32
        const val versionCode = 100
        const val versionName = "1.0.0"
        const val agpVersion = "7.1.3"
        const val kotlinVersion = "1.6.20"
    }

    object BuildType {
        const val Debug = "debug"
        const val Release = "release"
    }

    object AndroidX {
        const val appcompat = "androidx.appcompat:appcompat:1.4.1"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.1.3"
        const val material = "com.google.android.material:material:1.4.0"
        const val coreKtx = "androidx.core:core-ktx:1.7.0"
        const val fragmentKtx = "androidx.fragment:fragment-ktx:1.4.0"
    }

    /**
     * Lifecycle
     */
    object Lifecycle {
        private const val version = "2.4.0"
        const val runtimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:$version"
    }

    /**
     * 协程：https://github.com/Kotlin/kotlinx.coroutines
     */
    object Coroutines {
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.0"
    }

    object Test {
        const val junit = "junit:junit:4.13.2"
        const val junitExt = "androidx.test.ext:junit:1.1.3"
        const val espresso = "androidx.test.espresso:espresso-core:3.4.0"
    }

    /**
     * 当前时间
     */
    fun getSystemTime(): String {
        val simpleDateFormat = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.CHINA)
        return simpleDateFormat.format(System.currentTimeMillis())
    }
}
