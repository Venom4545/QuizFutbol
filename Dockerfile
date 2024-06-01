FROM openjdk:17
COPY "./target/QuizFutbol-1.jar" "app.jar"
EXPOSE 8055
ENTRYPOINT [ "java", "-jar", "app.jar" ]