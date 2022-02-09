FROM openjdk:17
MAINTAINER borous.com
COPY build/libs/*.jar movieAPI_v1.jar
ENTRYPOINT ["java","-jar","/movieAPI_v1.jar"]