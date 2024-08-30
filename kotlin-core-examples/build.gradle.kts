plugins {
    application
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "org.example"
version = "1.0-SNAPSHOT"

dependencies {
    implementation("org.apache.commons:commons-lang3")
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

application {
    mainClass.set("CoreMain")
}

tasks.shadowJar {
    archiveClassifier.set("fat")
}