FROM maven:3.6.1-ibmjava-8-alpine

WORKDIR /geekbrains-spring-2/

COPY . /geekbrains-spring-2/

# ENV JDBC_DATABASE_URL=jdbc:mysql://mysql:3306/${DATABASE_NAME}?useSSL=false&allowPublicKeyRetrieval=true
# ENV JDBC_DATABASE_USERNAME=user
# ENV JDBC_DATABASE_PASSWORD=user
# ENV HIBERNATE_DIALECT=org.hibernate.dialect.MySQL5InnoDBDialect
EXPOSE 8080

CMD [ "mvn", "clean", "spring-boot:run" ]

