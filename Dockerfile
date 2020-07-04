FROM openjdk:11.0.7-jdk-buster
ADD target/api-docker-0.0.1-SNAPSHOT.jar .
EXPOSE 8081
CMD java -jar api-docker-0.0.1-SNAPSHOT.jar