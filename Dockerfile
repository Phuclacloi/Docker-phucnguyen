FROM openjdk:23
COPY target/Nguyenhuuphucdocker-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
