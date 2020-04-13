FROM adoptopenjdk/openjdk11:jre-11.0.2.9-alpine

RUN apk --no-cache add curl
RUN apk --no-cache add jq

COPY ./target/*.jar app.jar
ADD ./scripts/docker-entrypoint.sh docker-entrypoint.sh

EXPOSE 8080

ENTRYPOINT ["sh", "/docker-entrypoint.sh"]