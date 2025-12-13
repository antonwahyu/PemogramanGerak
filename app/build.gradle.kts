plugins {
    // 1. Plugins Wajib (Termasuk Plugin Compose yang Hilang)
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose) // BARIS PERBAIKAN: Diperlukan karena Compose diaktifkan
}

android {
    namespace = "com.example.utspemogramanbergerak"
    compileSdk = 36 // Menggunakan versi SDK terbaru (berdasarkan konfigurasi Anda)

    defaultConfig {
        applicationId = "com.example.utspemogramanbergerak"
        minSdk = 22
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

    // 2. Konfigurasi Build Features (Views dan Compose)
    buildFeatures {
        viewBinding = true // Untuk Views (jika Anda menggunakannya)
        compose = true     // Untuk mengaktifkan Compose (membuat Color.kt berfungsi)
    }

    // 3. Konfigurasi Khusus Compose
    composeOptions {
        // Ganti dengan versi Kotlin Compiler Extension yang sesuai dengan versi Compose Anda (Contoh: "1.5.1")
        kotlinCompilerExtensionVersion = "1.5.1"
    }
}

dependencies {
    // 4. Dependensi Views/XML (AppCompat, Material, ConstraintLayout)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    // 5. Dependensi JETPACK COMPOSE (Untuk mengkompilasi file tema Compose)
    // Dependency ini menyelesaikan error "Unresolved reference 'Color'"
    val composeBom = platform("androidx.compose:compose-bom:2024.04.00") // Gunakan BOM untuk manajemen versi yang lebih baik
    implementation(composeBom)
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.ui:ui-tooling-preview")
    debugImplementation("androidx.compose.ui:ui-tooling")

    // 6. Dependensi Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}