# Arithmetic Calculator

A Java 8+ Maven web application that provides a browser-based calculator for
addition, subtraction, multiplication, and division.

## Build and test

Run the unit tests and create the deployable WAR:

```sh
mvn clean package
```

The artifact is `target/arithmetic-calculator.war`. Deploy it to a Servlet 4.0
compatible container, such as Apache Tomcat 9, then open the deployed
application's context root.

The Jenkins pipeline in `Jenkinsfile` compiles the application, runs unit tests,
packages the WAR, and archives the artifact.