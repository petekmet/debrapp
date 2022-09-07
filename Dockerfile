# start BUILD stage
FROM adoptopenjdk:11-jdk-hotspot as BUILD

COPY . /src
WORKDIR /src
RUN chmod +x gradlew
RUN ./gradlew --no-daemon bootJar

# start RUN stage
FROM adoptopenjdk:11-jre-hotspot
RUN mkdir /opt/app
COPY --from=BUILD /src/build/libs/dbapp*.jar /opt/app/japp.jar
ENTRYPOINT ["java","-jar", "/opt/app/japp.jar"]
