FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY build/libs/agendador-tarefas-0.0.1-SNAPSHOT.jar /app/agendador-tarefas.jar

EXPOSE 8081

CMD ["java", "-jar", "/app/agendador-tarefas.jar"]