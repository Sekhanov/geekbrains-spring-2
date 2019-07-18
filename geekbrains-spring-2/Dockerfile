FROM openjdk:8-alpine
ARG JAR_FILE
RUN mkdir /opt/app
COPY ./target/geekbrains-spring-2-0.0.1-SNAPSHOT.jar /opt/app/japp.jar
CMD ["java", "-jar", "/opt/app/japp.jar"]'