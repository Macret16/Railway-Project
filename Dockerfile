FROM eclipse-temurin:22-jdk-alpine
VOLUME /tmp
COPY target/*.jar railway.jar
ENTRYPOINT ["java","-jar","/railway.jar"]
EXPOSE 8080
