# A basic Spring Boot Application for Address Book Scenario

This is a [Spring Boot](http://projects.spring.io/spring-boot/) application.
It exposes one API called stats.
It gives the user three types of information within specifying the input variable from 1 to 3.

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Gradle 5](https://gradle.org/)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `uk.co.incircity.Application` class from your IDE.

Alternatively you can use the [Spring Boot Gradle plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/using-boot-running-your-application.html#using-boot-running-with-the-gradle-plugin) like so:

```shell
gradle bootRun
```

## API Details

URI: localhost:8080/stats

Url Parameters needed to be added to the URI:
1. type: It is required.
2. sex: It is optional but when type would be 1, it should be identified. Values 1 for males, 2 for females.
3. name1 and name2: They are optional but when type would be 3 they should be identified.

## The questions:
1. How many males are in the address book?
2. Who is the oldest person in the address book?
3. How many days older is Bill than Paul?

## Example links:
1. localhost:8080/stats?type=1&sex=1
2. localhost:8080/stats?type=2
3. localhost:8080/stats?type=3&name1=Bill&name2=Paul

