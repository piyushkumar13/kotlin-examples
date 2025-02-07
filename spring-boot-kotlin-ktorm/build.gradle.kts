group = "com.example"
version = "0.0.1-SNAPSHOT"


dependencies {

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.ktorm:ktorm-core")
    implementation("org.ktorm:ktorm-support-postgresql")
    implementation("org.ktorm:ktorm-ksp-annotations")
    implementation("net.datafaker:datafaker")

    ksp("org.ktorm:ktorm-ksp-compiler")

    runtimeOnly("org.postgresql:postgresql")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}