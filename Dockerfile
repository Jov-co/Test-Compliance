FROM openjdk:20-ea-19-slim-buster
COPY "./target/Dev_FinComp-0.0.1-SNAPSHOT.jar" "fincomp"
EXPOSE 8080
ENTRYPOINT ["java","-jar","app-jar"]