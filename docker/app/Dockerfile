FROM eclipse-temurin:17-jdk AS builder

WORKDIR /opt/app
COPY .. /opt/app

RUN ./gradlew bootJar

FROM eclipse-temurin:17-jre-alpine AS runner

WORKDIR /opt/app
COPY --from=builder /opt/app/build/libs/*.jar /opt/app/app.jar

CMD ["java", "-jar", "/opt/app/app.jar"]