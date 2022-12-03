FROM openjdk:17
# 挂载app目录
VOLUME /app
# 复制文件到容器里面，这里要把jar包放到当前目录下
COPY spring-boot-web-1.0-SNAPSHOT.jar app.jar
RUN bash -c "touch /app.jar"
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]