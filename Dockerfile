FROM eclipse-temurin:17

LABEL author = tavio.com

COPY build/libs/bookmark-api-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]