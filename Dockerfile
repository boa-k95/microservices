FROM openjdk:8
MAINTAINER Kurtis Kwame Edem Boama
ADD target/secondService-0.0.1-SNAPSHOT.jar secondService-0.0.1.jar
ENTRYPOINT ["java","-jar", "secondService-0.0.1.jar"]
EXPOSE 9090
RUN echo "secondService Dockerfile"
