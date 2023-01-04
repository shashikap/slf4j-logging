plugins {
    id("java")
}

group = "com.parrotanalytics"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("net.logstash.logback:logstash-logback-encoder:7.2")
    implementation("org.slf4j:slf4j-api:2.0.6")

}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}