FROM openjdk:17
LABEL authors="maxLVSHV"
ADD /target/urfuTask-0.0.1-SNAPSHOT.jar back.jar
ENTRYPOINT ["java", "-jar", "back.jar"]