FROM openjdk:8-jdk-alpine

COPY ./lib/bots /bots
COPY ./target/chatbot-0.0.1-SNAPSHOT.jar /bin/app.jar
COPY ./entrypoint.sh /bin/entrypoint.sh

ENV BOT_NAME=chatbot
ENV BOT_CONFIGURATION_PATH=/

CMD ["/bin/entrypoint.sh"]

EXPOSE 5000