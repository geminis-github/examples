# Command
docker rm $(docker stop $(docker ps -a -q))
docker volume rm $(docker volume list -q)

# MySql
1、docker pull mysql:5.7
2、docker run -d -p 3306:3306 -v /D/dev/docker/mysql/conf.d:/etc/mysql/conf.d -v /D/dev/docker/mysql/data:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=123456 --name  mysql mysql:5.7

# Redis
1、docker pull redis
2、docker run -p 6379:6379 --name redis -v /D/dev/docker/redis/data:/data -v /D/dev/docker/redis/conf/redis.conf:/etc/redis/redis.conf --restart=always -d redis redis-server

# Mongodb
docker pull mongo:latest
docker run -itd --name mongo -p 27017:27017 mongo --auth
docker exec -it mongo mongosh admin
db.createUser({ user:'admin',pwd:'123456',roles:[ { role:'userAdminAnyDatabase', db: 'admin'},"readWriteAnyDatabase"]})
db.auth('admin', '123456')

# RocketMQ

# Kafka
1、docker pull wurstmeister/zookeeper
2、docker pull wurstmeister/kafka
3、docker run -d --name zookeeper --privileged=true -p 2181:2181 --restart=always -v /D/dev/docker/zookeeper/data:/data -v /D/dev/docker/zookeeper/conf:/conf wurstmeister/zookeeper
4、docker run -d --name kafka --publish 9092:9092 --link zookeeper --env KAFKA_ZOOKEEPER_CONNECT=zookeeper:2181 --env KAFKA_ADVERTISED_HOST_NAME=GEMINIS --env KAFKA_ADVERTISED_PORT=9092 --env KAFKA_MESSAGE_MAX_BYTES=3145728 wurstmeister/kafka

# Nacos
1、docker pull nacos/nacos-server:v2.2.1
2、docker run --name nacos -d -p 8848:8848 -p 9848:9848 -p 9849:9849 --privileged=true --restart=always -e MODE=standalone -e PREFER_HOST_MODE=hostname nacos/nacos-server:v2.2.0
2021.0.4.0 对应 v2.0.4

# ElasticSearch
1、docker pull elasticsearch:8.5.2
2、docker network create es
3、docker run -d --name es --net es -v /D/dev/docker/es/plugins:/usr/share/elasticsearch/plugins -v /D/dev/docker/es/data:/usr/share/elasticsearch/data -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" elasticsearch:8.5.2
4、docker pull kibana:8.5.2
5、docker run -d --net es --name kb8 -p 5601:5601  -e "I18N_LOCALE=zh-CN" kibana:8.5.2

elastic 账号密码：1hsBnhiw-H3vH-Dw9o1i            重置密码命令：bin/elasticsearch-reset-password -u elastic          （es里面执行命令）
kibana_system 账号密码：hjQ3cmXrg+WHXKtcZF7o      重置密码命令：bin/elasticsearch-reset-password -u kibana_system    （es里面执行命令）
Kibana验证码：444 143                             生成命令=kibana-verification-code                                  （kibana执行）
令牌：eyJ2ZXIiOiI4LjUuMiIsImFkciI6WyIxNzIuMTguMC4zOjkyMDAiXSwiZmdyIjoiNDNmNzZhMmMwOWQ4YWVkMzg5YzJkMzc4MGJmNWM1NDM0MTdhZTBkMTBhNzQwNmU1MzA0NmIyMjIyNWYzNjIwMyIsImtleSI6InIxSWxQWWNCTlFaM1pZSThERFl5OkVXbW1HV2RQU3NxRGQtdVdFdnNwRXcifQ==
令牌重置命令：bin/elasticsearch-create-enrollment-token --scope kibana (es里面执行命令生成)
配置文件需要修改（不需要验证密码）：xpack.security.enabled: false


