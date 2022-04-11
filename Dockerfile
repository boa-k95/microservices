FROM openjdk:8
ADD target/secondService-0.0.1-SNAPSHOT.jar secondService-0.0.1.jar
ENTRYPOINT ["java","-jar", "secondService-0.0.1.jar"]
EXPOSE 9090