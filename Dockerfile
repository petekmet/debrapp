# start BUILD stage
FROM openjdk:17-jdk as BUILD

COPY . /src
WORKDIR /src
RUN microdnf install findutils
RUN chmod +x gradlew
RUN ./gradlew --no-daemon bootJar

# start RUN stage
FROM openjdk:17-alpine
RUN mkdir /opt/app
COPY --from=BUILD /src/build/libs/dbapp.jar /opt/app/japp.jar
ENTRYPOINT ["java","-jar", "/opt/app/japp.jar"]
