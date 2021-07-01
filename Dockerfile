FROM openjdk:11

ADD target/Medical-Consultation-0.0.1-SNAPSHOT.jar medical-consultation.jar

ENTRYPOINT ["java","-jar","medical-consultation.jar"]

EXPOSE 8081