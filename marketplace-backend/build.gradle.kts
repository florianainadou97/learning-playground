plugins {
    id("java")
    id("org.springframework.boot") version("3.3.0") // Automatically manages Spring Boot setup")
    id("io.spring.dependency-management") version("1.1.5") // Handles dependency versions without explicit versions")
}

group = "fr.egym"
version = "1.0-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    // The Swiss Army knife for web backends (includes Tomcat, REST, Jackson JSON)
    implementation("org.springframework.boot:spring-boot-starter-web")
    // DevTools: automatically restarts the server when you change code
    "developmentOnly"("org.springframework.boot:spring-boot-devtools")
    // Testing framework
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    // Lombok configuration
    compileOnly("org.projectlombok:lombok:1.18.32")
    annotationProcessor("org.projectlombok:lombok:1.18.32")

    // Optional: If you use Lombok inside your test classes too
    testCompileOnly("org.projectlombok:lombok")
    testAnnotationProcessor("org.projectlombok:lombok")
}

tasks.test {
    useJUnitPlatform()
}