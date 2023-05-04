FROM eclipse-temurin:17-jre-alpine

WORKDIR /opt/app
COPY ./build/libs/recipes-0.0.1-SNAPSHOT.jar /opt/app/app.jar

CMD ["java", "-jar", "/opt/app/app.jar"]