FROM 489478819445.dkr.ecr.us-west-2.amazonaws.com/amazoncorretto:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT [ "java","-jar","/app.jar" ]