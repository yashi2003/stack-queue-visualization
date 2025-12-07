FROM gradle:7.6-jdk11 AS build
WORKDIR /app
COPY . .
RUN gradle build --no-daemon

FROM openjdk:11-jre-slim
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8080
ENV PORT=8080
CMD java -Dserver.port=$PORT -jar app.jar
