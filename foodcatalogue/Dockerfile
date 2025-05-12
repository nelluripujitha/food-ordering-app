FROM eclipse-temurin:17-jdk-alpine
WORKDIR /opt
COPY target/*.jar /opt/app.jar
ENV JAVA_OPTS=""
ENTRYPOINT exec java $JAVA_OPTS -jar app.jar
