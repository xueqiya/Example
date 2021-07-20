import java.io.ByteArrayOutputStream
import java.text.SimpleDateFormat
import java.util.*

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdkVersion(30)
    buildToolsVersion("30.0.3")

    defaultConfig {
        applicationId = "com.xueqiya.example"
        minSdkVersion(16)
        targetSdkVersion(30)
        versionCode = gitVersion()
        versionName = "1.0.0"
        multiDexEnabled = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        ndk {
            abiFilters += listOf("armeabi-v7a")
        }
    }

    buildFeatures {
        dataBinding = true
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
        useIR = true
    }

    signingConfigs {
        create("release") {
            storeFile = file("../debug_key.keystore")
            keyPassword = "123456"
            keyAlias = "key0"
            storePassword = "123456"
            isV1SigningEnabled = true
            isV2SigningEnabled = true
        }
    }

    buildTypes {
        getByName("debug") {
            minifyEnabled(false)
            zipAlignEnabled(false)
            isShrinkResources = false
            signingConfig = signingConfigs.getByName("release")
        }

        getByName("release") {
            minifyEnabled(true)
            zipAlignEnabled(true)
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
            signingConfig = signingConfigs.getByName("release")
        }
    }

    applicationVariants.all {
        val variant = this
        variant.outputs
            .map { it as com.android.build.gradle.internal.api.BaseVariantOutputImpl }
            .forEachIndexed { index, output ->
                output.outputFileName = "example" +
                        "_${variant.versionName}" +
                        "_${versionCode}" +
                        "_${getDateTimeFormat()}" +
                        ".apk"
            }
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar", "*.aar"))))
    //kotlin
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.5.20")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.0")
    //androidx
    implementation("androidx.appcompat:appcompat:1.3.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    implementation("androidx.viewpager2:viewpager2:1.0.0")
    implementation("androidx.annotation:annotation:1.2.0")
    implementation("androidx.multidex:multidex:2.0.1")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")
    implementation("androidx.vectordrawable:vectordrawable:1.1.0")
    //ktx
    implementation("androidx.core:core-ktx:1.6.0")
    implementation("androidx.activity:activity-ktx:1.2.3")
    implementation("androidx.fragment:fragment-ktx:1.3.5")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.3.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1")
    implementation("androidx.preference:preference-ktx:1.1.1")
    implementation("androidx.navigation:navigation-runtime-ktx:2.4.0-alpha04")
    implementation("androidx.navigation:navigation-fragment-ktx:2.4.0-alpha04")
    implementation("androidx.navigation:navigation-ui-ktx:2.4.0-alpha04")
    //material
    implementation("com.google.android.material:material:1.4.0")
    //test
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    //recyclerView
    implementation("com.github.CymChad:BaseRecyclerViewAdapterHelper:3.0.6")
    //圆角图片控件
    implementation("com.makeramen:roundedimageview:2.3.0")
    //状态栏
    implementation("com.jaeger.statusbarutil:library:1.5.1")
    //loading
    implementation("com.wang.avi:library:2.1.3")
    //loadingLayout
    implementation("io.github.xueqiya:LoadingLayout:1.0.3")
    //dialog
    implementation("com.afollestad.material-dialogs:core:3.3.0")
    implementation("com.afollestad.material-dialogs:input:3.3.0")
    //tabLayout
    implementation("com.github.hackware1993:MagicIndicator:1.7.0")
    //webView
    implementation("com.just.agentweb:agentweb:4.1.4")
    //图片加载
    implementation("com.github.bumptech.glide:glide:4.12.0")
    kapt("com.github.bumptech.glide:compiler:4.11.0")
    //查看大图
    implementation("com.github.SherlockGougou:BigImageViewPager:androidx-6.1.3")
    //markdown
    implementation("io.noties.markwon:core:4.3.1")
    //动态权限
    implementation("pub.devrel:easypermissions:3.0.0")
    //json
    implementation("com.google.code.gson:gson:2.8.7")
    //net
    implementation("com.squareup.okhttp3:okhttp:4.9.1")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.retrofit2:converter-scalars:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.1")
    //hilt
    implementation("com.google.dagger:hilt-android:2.36")
    kapt("com.google.dagger:hilt-android-compiler:2.36")
    //databinding viewbinding帮助类
    implementation("com.hi-dhl:binding:1.1.3")
    //工具类
    implementation("com.blankj:utilcodex:1.30.6")
}

fun getDateTimeFormat(): String {
    val simpleDateFormat = SimpleDateFormat("yyyyMMdd", Locale.US)
    return simpleDateFormat.format(Date())
}

fun gitVersion(): Int {
    val gitLastCommitHash = runCommand(project, "git rev-list HEAD --count")
    return gitLastCommitHash.toInt() + 1
}

fun runCommand(project: Project, command: String): String {
    val stdout = ByteArrayOutputStream()
    project.exec {
        commandLine = command.split(" ")
        standardOutput = stdout
    }
    return stdout.toString().trim()
}
