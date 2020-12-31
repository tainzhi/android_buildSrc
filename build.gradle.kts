repositories {
    jcenter()
    google()
    maven {
        setUrl("https://jitpack.io")
    }
}

plugins {
    `kotlin-dsl`
    kotlin("kapt") version "1.4.21"
}

dependencies {
    val kotlinVersion by extra { "1.4.21"}
    val moshiVersion by extra { "1.11.0"}
    implementation(kotlin("stdlib", kotlinVersion))
    implementation(kotlin("gradle-plugin", kotlinVersion))
    implementation(gradleKotlinDsl())
    implementation("com.android.tools.build:gradle:4.0.1")
    implementation(gradleApi())
    implementation("com.squareup.okhttp3:okhttp:4.9.0")
    implementation("com.squareup.moshi:moshi-kotlin:$moshiVersion")
    kapt("com.squareup.moshi:moshi-kotlin-codegen:$moshiVersion")
    testImplementation("junit:junit:4.13")
}
