# TestJava20

## Description

This application is a REST service dveloped in Spring boot that allows to query an applicable rate given a brand and a product in a certain date based on the priority rules.

<ul>
    <li>H2 database with example data</li>
    <li>Hexagonal architecture, domain, application and infra layers</li>
    <li>Centralized exception handling with ControllerAdvice</li>
    <li>Api documentation with Swagger</li>
    <li>Unit testing and cover with JUnit, Mockito and Jacoco</li>
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
