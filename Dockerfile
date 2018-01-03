FROM openjdk:8-jdk AS build-env

ADD  . /src
WORKDIR /src
RUN ./gradlew

FROM openjdk:8-jre-alpine
COPY --from=build-env /src/build/libs/microservice-java.jar /srv/app.jar
CMD ["/usr/bin/java", "-jar", "/srv/app.jar"]
