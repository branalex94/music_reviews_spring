#FROM openjdk:17-jdk-alpine
#FROM maven:3.9.6-eclipse-temurin-17
#WORKDIR /app
#COPY . .
#RUN mvn clean package
#RUN mv /app/target/*.jar app.jar
#EXPOSE 8080
#ENTRYPOINT ["java", "-jar", "app.jar"]

# Usa una imagen base con JDK para compilar el proyecto
FROM maven:3.9.6-eclipse-temurin-17 AS build

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el contenido del proyecto al contenedor
COPY . .

# Ejecuta el proceso de compilación
RUN mvn clean package -DskipTests

# Usa una imagen más ligera para ejecutar el .jar
FROM eclipse-temurin:17-jdk

# Establece el directorio de trabajo
WORKDIR /app

# Copia el .jar compilado desde la etapa anterior
COPY --from=build /app/target/*.jar app.jar

# Expone el puerto en el que corre Spring Boot
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
