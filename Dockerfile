FROM maven:3.6.3-jdk-11 AS build
COPY ./target/UrlShortener-0.0.1-SNAPSHOT.jar /Users/dylanbyrne/eInterviewQuestions/UrlShortener-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/Users/dylanbyrne/eInterviewQuestions/UrlShortener-0.0.1-SNAPSHOT.jar"]