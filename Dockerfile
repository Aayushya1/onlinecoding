FROM openjdk
COPY target/onlinecoding-1.0-SNAPSHOT.jar /home
WORKDIR /home
CMD ["java" , "-jar" , "onlinecoding-1.0-SNAPSHOT.jar"]