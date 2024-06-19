plugins {
    kotlin("jvm") version "1.9.23"
}

group = "dev.virunarala"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.9.0-RC")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0-RC")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm:1.9.0-RC")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}