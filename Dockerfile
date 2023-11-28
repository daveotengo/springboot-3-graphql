FROM openjdk:17
VOLUME /tmp
ADD target/springboot-3-graphql-0.0.1-SNAPSHOT.jar springboot-3-graphql-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/springboot-3-graphql-0.0.1-SNAPSHOT.jar"]