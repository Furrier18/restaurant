FROM openjdk:17-jdk-alpine3.14

COPY "./web/target/restaurant.jar" "/application/restaurant.jar"

CMD ["java", "-jar", "/application/restaurant.jar"]
