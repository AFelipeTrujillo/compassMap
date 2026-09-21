# compassMap masterDoc v1

## Summary

### References

- Reference project: [Spring Boot: H2 DB and Thymeleaf – albertprofe wiki](https://albertprofe.dev/springboot/boot-what-create-th-h2.html)
- Microservices: https://spring.io/]
- Spring Boot is open-source: [GitHub - spring-projects/spring-boot: Spring Boot helps you to create Spring-powered, production-grade applications and services with absolute minimum fuss.](https://github.com/spring-projects/spring-boot)
- Spring Boot Guides / Academy: https://spring.io/guides / https://spring.academy/courses
- Quickstart: https://spring.io/quickstart

Historical notes:

- [Spring Framework – albertprofe wiki](https://albertprofe.dev/spring/spring-basics.html)

- [JPA Before Annotatons one-to-many xml](https://github.com/AlbertProfe/ApartmentPredictor/blob/master/docs/appends/JPA_Before_Annotatons:_one-to-many-xml.md)

### Product Goal

Generar roadmaps de aprendizaje personalizados a partir de una matriz 2×2 (saber programar × querer aprender).  
Whitepaper del producto: [docs/whitepaper.md](./whitepaper.md)


### Version goal



## Project commits



## Create project: Spring Init

- https://start.spring.io/

### Project structure


### Java classes

Here we will post all java classes.





## Code


### Command Line Runner

> The [ApartmentPredictorApplication](cci:2://file:///home/albert/MyProjects/Sandbox/ApartmentPredictorProject/ApartmentPredictor/src/main/java/com/example/apartment_predictor/ApartmentPredictorApplication.java:9:0-126:1) implements `CommandLineRunner`, which <mark>executes code after the Spring Boot application starts</mark>. 

The **CommandLineRunner** serves as a data initialization mechanism, populating the database with test data upon application startup.

```java
package com.example.apartment_predictor;

import com.example.apartment_predictor.model.Apartment;
import com.example.apartment_predictor.repository.ApartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApartmentPredictorApplication implements CommandLineRunner {

    @Autowired
    private ApartmentRepository apartmentRepository;


    public static void main(String[] args) {
        SpringApplication.run(ApartmentPredictorApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Creating apartment objects...");

        // Create apartment objects based on your sample data
        Apartment apartment1 = new Apartment(
                13300000L,    // price
                7420,         // area
                4,            // bedrooms
                2,            // bathrooms
                3,            // stories
                "yes",        // mainroad
                "no",         // guestroom
                "no",         // basement
                "no",         // hotwater
                "yes",        // heating
                "yes",        // airconditioning
                2,            // parking
                "yes",        // prefarea
                "furnished"   // furnishingstatus
        );



        // Create additional sample apartments
        Apartment apartment2 = new Apartment(
                8500000L,     // price
                5200,         // area
                3,            // bedrooms
                2,            // bathrooms
                2,            // stories
                "yes",        // mainroad
                "yes",        // guestroom
                "no",         // basement
                "yes",        // hotwater
                "no",         // heating
                "yes",        // airconditioning
                1,            // parking
                "no",         // prefarea
                "semi-furnished" // furnishingstatus
        );

        Apartment apartment3 = new Apartment(
                6200000L,     // price
                3800,         // area
                2,            // bedrooms
                1,            // bathrooms
                1,            // stories
                "no",         // mainroad
                "no",         // guestroom
                "yes",        // basement
                "yes",        // hotwater
                "no",         // heating
                "no",         // airconditioning
                0,            // parking
                "yes",        // prefarea
                "unfurnished" // furnishingstatus
        );

        apartmentRepository.save(apartment1);
        apartmentRepository.save(apartment2);
        apartmentRepository.save(apartment3);

        int index = 0;
        System.out.println("\n=== Apartments in the Database ===");
        for (Apartment apartment : apartmentRepository.findAll()){
            index++;
            System.out.println("#" + index);
             System.out.println(apartment);
        }

        //apartmentRepository.findAll().forEach(System.out::println);
    }


}
```


## Annotations

- [SpringBoot Annotations](https://github.com/AlbertProfe/ApartmentPredictor/blob/master/docs/appends/SpringBoot-Annotations.md)

## JPA



## Maven

> **Apache Maven** is a <mark>build tool for Java projects</mark>. Using a <mark>project object model </mark>(`POM`), Maven manages a project's compilation, testing, and documentation.

- [Maven](https://maven.apache.org/)
- [Maven Repository](https://mvnrepository.com/)

### pom.xml

```xml

```

## Tech Stack

- IDE: IntelliJ IDEA 2025.1.3 (Community Edition)
  
  - [Descargar IntelliJ IDEA](https://www.jetbrains.com/es-es/idea/download/?section=linux)
  
  - With [Installing snap on Ubuntu | Snapcraft documentation](https://snapcraft.io/docs/installing-snap-on-ubuntu): `sudo snap install intellij-idea-community --classic`

- Java 21 (or 25, 17, 11, 8) <mark>open-jdk</mark>

- <mark>JUnit 3.8.1</mark>

- Create project by <mark>Sprint Init</mark>
  
  - Alternative: Maven Project: **`maven-archetype-quickstart` archetype**
    
    - https://maven.apache.org/
    
    - mvn --version
      Apache Maven 3.8.7
      Maven home: /usr/share/maven
      Java version: 21.0.8, vendor: Ubuntu, runtime: /usr/lib/jvm/java-21-openjdk-amd64
      Default locale: en_US, platform encoding: UTF-8
      OS name: "linux", version: "6.8.0-83-generic", arch: "amd64", family: "unix"


