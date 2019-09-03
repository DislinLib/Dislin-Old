import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.41"
}

group = "com.kodingking"
version = "0.1-PRE"

repositories {
    mavenCentral()
    maven(url = "https://repo.spring.io/milestone")
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:1.3.0")

    implementation("io.ktor:ktor-client-core:1.2.3")
    implementation("io.ktor:ktor-client-cio:1.2.3")
    implementation("io.ktor:ktor-client-okhttp:1.2.3")
    implementation("io.ktor:ktor-client-gson:1.2.3")

    implementation("com.squareup.okhttp3:okhttp:3.14.1")

//    implementation("io.projectreactor:reactor-core:3.3.0.M3")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
    kotlinOptions.freeCompilerArgs += "-Xuse-experimental=kotlin.Experimental"
}