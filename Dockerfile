FROM openjdk:17
ARG JAR_FILE=target/survey-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} survey-backend.jar
ENTRYPOINT ["java", "-jar", "/survey-backend.jar"]
