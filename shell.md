/D/dev/docker=挂载到D:\dev\docker目录下

# mysql：
1、docker pull mysql:5.7
2、docker run -d -p 3306:3306 -v /D/dev/docker/mysql/conf.d:/etc/mysql/conf.d -v /D/dev/docker/mysql/data:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=123456 --name  mysql mysql:5.7

# redis：
1、docker pull redis
2、docker run -p 6379:6379 --name redis -v /D/dev/docker/redis/data:/data -v /D/dev/docker/redis/conf/redis.conf:/etc/redis/redis.conf --restart=always -d redis redis-server

# kafka:
1、docker pull wurstmeister/zookeeper
2、docker pull wurstmeister/kafka
3、docker run -d --name zookeeper --privileged=true -p 2181:2181 --restart=always -v /D/dev/docker/zookeeper/data:/data -v /D/dev/docker/zookeeper/conf:/conf wurstmeister/zookeeper
4、docker run -d --name kafka --publish 9092:9092 --link zookeeper --env KAFKA_ZOOKEEPER_CONNECT=zookeeper:2181 --env KAFKA_ADVERTISED_HOST_NAME=GEMINIS --env KAFKA_ADVERTISED_PORT=9092 --env KAFKA_MESSAGE_MAX_BYTES=3145728 wurstmeister/kafka

# nacos:
1、docker pull nacos/nacos-server
2、docker run --name nacos -d -p 8848:8848 -p 9848:9848 -p 9849:9849 --privileged=true --restart=always -e MODE=standalone -e PREFER_HOST_MODE=hostname nacos/nacos-server

# es
1、docker pull elasticsearch:8.5.2
2、docker network create es
3、docker run -d --name es --net es -v /D/dev/docker/es/plugins:/usr/share/elasticsearch/plugins -v /D/dev/docker/es/data:/usr/share/elasticsearch/data -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" elasticsearch:8.5.2
4、docker pull kibana:8.5.2
5、docker run -d --net es --name kb8 -p 5601:5601  -e "I18N_LOCALE=zh-CN" kibana:8.5.2

PS: 账户：elastic，密码：1V9jmMPCpqsLkh3UQWYI，重置密码：bin/elasticsearch-reset-password -u elastic
PS：重置命令：bin/elasticsearch-create-enrollment-token --scope kibana，kinaba令牌：eyJ2ZXIiOiI4LjUuMiIsImFkciI6WyIxNzIuMTguMC4yOjkyMDAiXSwiZmdyIjoiZmNmZGUzZjUyYzM1Y2ZhN2Q1Y2JhMTQxYmViYTgwZTgwMDlkYmM5NDA1NzlkN2I5NzNlMmZkZTI0ZWUxOGU2ZCIsImtleSI6Ik5ibUt6b1FCVkw1cl92NUp2S3dSOnAyQmsxenBjVFZ5VmQ3Q0JjT2kteFEifQ==


# command
docker rm $(docker stop $(docker ps -a -q))
docker volume rm $(docker volume list -q)

docker run -d --name es -e "ES_JAVA_OPTS=-Xms512m -Xmx512m" -e "discovery.type=single-node" -v /D/dev/docker/es-data:/usr/share/elasticsearch/data -v /D/dev/docker/es-plugins:/usr/share/elasticsearch/plugins --privileged --network es-net -p 9200:9200 -p 9300:9300 elasticsearch:7.12.1