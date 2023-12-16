plugins {
	java
	id("org.springframework.boot") version "3.0.5"
	id("io.spring.dependency-management") version "1.1.0"
}

group = "practice.spring"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

dependencies {
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.apache.tomcat.embed:tomcat-embed-jasper")
	implementation("jakarta.servlet:jakarta.servlet-api")
	implementation("jakarta.servlet.jsp.jstl:jakarta.servlet.jsp.jstl-api")
	implementation("org.glassfish.web:jakarta.servlet.jsp.jstl")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
