plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
    id("com.google.devtools.ksp")
    id("org.jetbrains.kotlin.plugin.serialization")
}

android {
    namespace = "com.biometric.fch"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.biometric.fch"
        minSdk = 27
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures{
        viewBinding= true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    //Biometric Implementation
    implementation("androidx.biometric:biometric:1.2.0-alpha05")
    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    // LiveData
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
    implementation("androidx.fragment:fragment-ktx:1.6.2")
    implementation("androidx.activity:activity:1.8.2")

    //Swipe recyclerview
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")


    //Room
    implementation("androidx.room:room-runtime:2.5.0")
    annotationProcessor("androidx.room:room-compiler:2.5.0")
    ksp("androidx.room:room-compiler:2.5.0")

    //Image load implementation
    implementation("io.coil-kt:coil:2.5.0")
    implementation("com.airbnb.android:lottie:6.0.0")


    //Corutinas
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")


    //farebase
    //Import the Firebase BoM
    implementation(platform("com.google.firebase:firebase-bom:32.7.1"))
    // When using the BoM, don't specify versions in Firebase dependencies
    implementation("com.google.firebase:firebase-analytics")
    // Add the dependency for the Firebase Authentication library
    // When using the BoM, you don't specify versions in Firebase library dependencies
    implementation("com.google.firebase:firebase-auth-ktx")


    // Declare the dependency for the Cloud Firestore library
    // When using the BoM, you don't specify versions in Firebase library dependencies
    implementation("com.google.firebase:firebase-firestore")


    //KTOR client API service
    val ktor_version = "2.2.4"
    implementation ("io.ktor:ktor-client-core:$ktor_version")
    //Android Client
    implementation("io.ktor:ktor-client-android:$ktor_version")
    // HTTP engine: The HTTP client used to perform network requests.
    implementation("io.ktor:ktor-client-okhttp:$ktor_version")
    // Logging
    implementation ("io.ktor:ktor-client-logging:$ktor_version")
    //Serializacion
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")
    // The serialization engine used to convert objects to and from JSON.
    implementation ("io.ktor:ktor-client-json:$ktor_version")
    implementation ("io.ktor:ktor-client-serialization:$ktor_version")
    // content Negotiation
    implementation("io.ktor:ktor-client-content-negotiation:$ktor_version")
    // Json
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktor_version")
    //XML
    implementation("io.ktor:ktor-serialization-kotlinx-xml:$ktor_version")
    implementation ("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1")


    //Retrofit (API)
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")


    implementation ("com.squareup.picasso:picasso:2.71828")
}