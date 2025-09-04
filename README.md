# TestJava20

## Description

This application is a REST service dveloped in Spring boot that allows to query an applicable rate given a brand and a product in a certain date based on the priority rules.

<ul>
    <li>H2 database with example data</li>
    <li>Hexagonal architecture, domain, application and infra layers</li>
    <li>Centralized exception handling with ControllerAdvice</li>
    <li>Api documentation with Swagger</li>
    <li>Unit testing and cover with JUnit, Mockito and Jacoco</li>
    <li>GithubAction workflow + push to Docker</li>
</ul>

## Tech stack

<ul>
    <li>Java 21</li>
    <li>Spring boot 3.5</li>
    <li>Spring JPA</li>
    <li>H2 database</li>
    <li>JUnit 5</li>
    <li>Mockito</li>
    <li>Jacoco</li>
    <li>Swagger/OpenAPI</li>
    <li>Maven</li>
    <li>Docker</li>
    <li>Github Actions</li>
</ul>

## How to run it?

Clone repo:
<code>git clone https://github.com/Alex-crw/testjava2025
cd testjava2025</code>

Execute application:
<code>mvn spring-boot:run</code>

Api REST availabile here:
<code>http://localhost:8080/applicable-rate</code>

Swagger/OpenAPI:
<code>http://localhost:8080/swagger-ui.html</code>

## How to run it with docker?
Push on master branch triggers Github workflow that builds and pushes the latest version to docker hub. To run it from docker:

<code>docker pull alexcrw94/testjava2025:latest</code>
<code>docker run -p 8080:8080 alexcrw94/testjava2025:latest</code>




