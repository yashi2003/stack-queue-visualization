# ---------- Build stage ----------
    FROM gradle:8.10.2-jdk17 AS build
    WORKDIR /app
    
    # Copy everything and build
    COPY . .
    RUN gradle clean bootJar --no-daemon
    
    # ---------- Runtime stage ----------
    FROM eclipse-temurin:17-jre-jammy
    WORKDIR /app
    
    # Copy the fat jar from the build stage
    COPY --from=build /app/build/libs/*.jar app.jar
    
    EXPOSE 8080
    ENV PORT=8080
    
    # Use sh -c so $PORT gets expanded
    CMD ["sh", "-c", "java -Dserver.port=$PORT -jar app.jar"]
    