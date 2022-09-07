# Getting Started

Master branch is tracked with github action which triggers build and push to public dockerhub. Images are multiplatform for linux/amd64 (standard Intel-based workstation) and linux/arm/v7 (ARM-based, 32-bit image, e.g. RPi3/4)

To compile/test/build java app locally
~~~
./gradlew clean build
~~~

To build docker image locally
~~~
docker build -t petekmet/debrapp:latest .
~~~

To run locally - above steps are optional since there is already docker image on public dockerhub, see https://hub.docker.com/repository/docker/petekmet/debrapp/general
~~~
./localRun.sh
~~~

Swagger-UI:

http://localhost:8080/swagger-ui.html
