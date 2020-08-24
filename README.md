# Hyperledger Fabric Spring Boot Starter

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.bxforce/hyperledger-fabric-spring-boot/badge.svg?style=flat-square)](https://maven-badges.herokuapp.com/maven-central/com.github.bxforce/hyperledger-fabric-spring-boot)
[![javadoc](https://javadoc.io/badge2/com.github.bxforce/hyperledger-fabric-spring-boot/javadoc.svg)](https://javadoc.io/doc/com.github.bxforce/hyperledger-fabric-spring-boot)

Hyperledger Fabric Spring Boot Starter provides an easy way to get your Spring boot application using Hyperledger Fabric Gateway SDK v2.2 up and running quickly.

To use the Hyperledger Fabric Spring Boot Starter in your projects you can include the maven dependency in your project pom file:

```xml
<dependency>
  <groupId>com.github.bxforce</groupId>
  <artifactId>hyperledger-fabric-spring-boot</artifactId>
  <version>1.0.0-RELEASE</version>
  <type>pom</type>
</dependency>
```

## Spring configuration

#### Hyperledger Fabric CA Configuration

+ **hyperledger-fabric.ca-client.name**
The Certificate Authority name.
+ **hyperledger-fabric.ca-client.url**
Http URL for the Fabric's certificate authority services endpoint.
+ **hyperledger-fabric.ca-client.pem-file**
File location for x509 pem certificate for SSL.
+ **hyperledger-fabric.ca-client.allow-all-host-names**
boolen(true/false) override certificates CN Host matching -- for development only.

#### Hyperledger Fabric Gateway Configuration

+ **hyperledger-fabric.gateway.discovery**
Enable or disable service discovery for all transaction submissions for this gateway.
+ **hyperledger-fabric.gateway.network-config**
The path to the common connection profile.