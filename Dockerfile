FROM openjdk:8-jdk
LABEL maintainer="K8sCat <k8scat@gmail.com>"
ENV TZ=Asia/Shanghai
WORKDIR /opt/client
COPY . .
RUN ./mvnw install
EXPOSE 8080
CMD [ "./mvnw", "spring-boot:run" ]
ENV SERVICE_NAME=BenchmarkClient SERVICE_TYPE=client
