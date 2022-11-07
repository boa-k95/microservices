FROM openjdk:11
MAINTAINER Kurtis Kwame Edem Boama

RUN mkdir -p /javaProject/src
WORKDIR /javaProject/src
COPY . .
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar"]
EXPOSE 9090
RUN echo "secondService application Dockerfile"