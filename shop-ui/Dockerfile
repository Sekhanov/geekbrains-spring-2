FROM openjdk:8-jdk-alpine

WORKDIR /my-apps/

COPY ./target/shop-ui-0.0.1-SNAPSHOT.jar /my-apps/app.jar
COPY ./entrypoint.sh /bin/entrypoint.sh
CMD ["/bin/entrypoint.sh"]
EXPOSE 8080