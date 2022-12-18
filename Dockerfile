FROM openjdk:11
MAINTAINER Kurtis Kwame Edem Boama

RUN mkdir -p /javaProject/src
WORKDIR /javaProject/src
COPY . .
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar"]
EXPOSE 5000
RUN echo "secondService2 application Dockerfile"