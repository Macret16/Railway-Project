FROM eclipse-temurin:21-jdk-alpine
VOLUME /railway
COPY target/*.jar railway.jar
ENTRYPOINT ["java","-jar","/railway.jar"]
EXPOSE 8080
