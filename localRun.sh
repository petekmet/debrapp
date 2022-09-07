export HTTP_PORT="8080"
docker run \
-e HOST_PORT=$HTTP_PORT \
--rm \
--name debr \
-p $HTTP_PORT:$HTTP_PORT/tcp \
petekmet/debr:latest