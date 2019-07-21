#!/usr/bin/env sh
docker login
heroku login
heroku container:login
heroku apps:create sekhanov-my-shop-ui
heroku addons:create heroku-postgresql:hobby-dev --app sekhanov-my-shop-ui
heroku config:set DB_DRIVER=org.postgresql.Driver HIBERNATE_DIALECT=org.hibernate.dialect.PostgreSQLDialect --app sekhanov-my-shop-ui
heroku container:push web --app=sekhanov-my-shop-ui
heroku container:release web --app=sekhanov-my-shop-ui