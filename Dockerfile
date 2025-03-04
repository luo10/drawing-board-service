# 阶段 1: 构建阶段
FROM maven:3.9.4-eclipse-temurin-21 AS builder

# 设置工作目录
WORKDIR /app

# 将 Maven 项目文件复制到容器中
COPY pom.xml .
COPY src ./src

# 使用 Maven 打包项目
RUN mvn clean package -DskipTests

# 阶段 2: 运行阶段
FROM openjdk:21-jdk

# 作者信息（可选）
LABEL maintainer="yassinyrj@gmail.com"

# 设置工作目录
WORKDIR /app

# 从构建阶段复制生成的 JAR 文件到运行阶段
COPY --from=builder /app/target/drawing-board-server-0.0.1-SNAPSHOT.jar app.jar

# 暴露应用端口
EXPOSE 9008

# 设置容器启动命令
ENTRYPOINT ["java", "-jar", "app.jar", "--logging.file.path=/app/logs"]