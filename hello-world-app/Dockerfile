FROM gcr.io/distroless/java17-debian12

ARG artifact=target/hello-world-app-v1.jar

WORKDIR /opt/app

COPY ${artifact} app.jar

ENTRYPOINT ["java","-jar","app.jar"]