#!/usr/bin/env sh
mvn clean package -DskipTests
docker-compose up