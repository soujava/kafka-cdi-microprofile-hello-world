# kafka-cdi-microprofile-hello-world - A hello world using Apache Kafka and Eclipse Microprofile

![Apache Kafka](https://dzone.com/storage/temp/12418896-apache-kafka.png)

Apache Kafka is a community distributed streaming platform that has three key capabilities: publish and subscribe to streams of records, store streams of records in a fault-tolerant durable way and then process as streams as they occur. Apache Kafka has several success cases that include at the Java World.,

## Install Apache Kafka

The official documentation has a nice getting start with Apache Kafka that teaches to install it and also Zookeeper, briefly, Kafka uses Zookeeper to Cluster membership, topic configuration and so on.

Download the 2.1.0 release and un-tar it.

```shell
tar -xzf kafka_2.11-2.1.0.tgz
cd kafka_2.11-2.1.0
```

* Start first a Zookeeper instance

```shell
bin/zookeeper-server-start.sh config/zookeeper.properties
```

* To finally, start with Apache Kafka:

```shell
 bin/kafka-server-start.sh config/server.properties
```

## Using Docker

![Docker](https://www.docker.com/sites/default/files/social/docker_facebook_share.png)

* [Install Docker](https://docs.docker.com/install/)

* [Install Docker-compose](https://docs.docker.com/compose/install/)

Run the command:

```shell
docker-compose -f docker-compose.yml up -d
```

To connect as localhost, also defines the Kafka as localhost, within Linux append value below at the /etc/hosts

```shell
127.0.0.1       localhost kafka
```

To stop the services:

```shell
docker-compose -f docker-compose.yml down
```

## Install maven dependencies

Run:

```
mvn clean install
```

Execute the `App` at your IDE and check the results.
