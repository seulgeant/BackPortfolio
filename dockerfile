FROM amazoncorretto:18
MAINTAINER leonardogerez
COPY target/leg-0.0.1-SNAPSHOT.jar leg-0.0.1-SNAPSHOT
ENTRYPOINT ["java","-jar","/leg-0.0.1-SNAPSHOT.jar"]