#Imagem base com java 17
FROM eclipse-temurin:17-jdk-alpine
#Diretório dentro do container
WORKDIR /app
#Copia o jar gerado
COPY target/biblioteca-0.0.1-SNAPSHOT.jar app.jar
#Expõe a porta 8080
EXPOSE 8080
#Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]