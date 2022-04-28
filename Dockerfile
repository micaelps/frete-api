FROM adoptopenjdk/openjdk11:latest
ARG JAR_FILE=/home/app/target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT [ "java","-jar","/app.jar" ]