FROM openjdk:8-jdk-alpine

COPY ./target/shop-ui-0.0.1-SNAPSHOT /shop-ui/
COPY ./entrypoint.sh /bin/entrypoint.sh
CMD ["/bin/entrypoint.sh"]
EXPOSE 8080
# ENV JDBC_DATABASE_URL=jdbc:mysql://mysql:3306/${DATABASE_NAME}?useSSL=false&allowPublicKeyRetrieval=true
# ENV JDBC_DATABASE_USERNAME=user
# ENV JDBC_DATABASE_PASSWORD=user
# ENV HIBERNATE_DIALECT=org.hibernate.dialect.MySQL5InnoDBDialect




