FROM openjdk:17
WORKDIR /app
COPY target/openai_proxy-0.0.1-SNAPSHOT.jar /app/myapp.jar
# 执行 mvn spring-boot:run
#CMD ["mvn", "spring-boot:run"]
CMD ["java", "-jar", "myapp.jar"]


## Stage 1: Build the application
#FROM maven:3.6.3-openjdk-11 AS build
#COPY src /home/app/src
#COPY pom.xml /home/app
#RUN mvn -f /home/app/pom.xml clean package
#
## Stage 2: Setup the runtime container
#FROM openjdk:11
#COPY --from=build /home/app/target/*.jar app.jar
#ENTRYPOINT ["java","-jar","app.jar"]
