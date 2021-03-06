## Slides

[Kafka-workshop](https://docs.google.com/presentation/d/1FbC6ZPwx6UdRPySILNm9qZaKH8NNTH_Px8cgjWQDpAw/view?usp=sharing)

## Pre-requisites
Install Docker
- [Mac](https://docs.docker.com/docker-for-mac/install/)
- [Windows](https://docs.docker.com/docker-for-windows/install/)
- [Linux](https://docs.docker.com/install/#docker-ce)

## Start Kafka single node cluster

- Navigate to the the `docker/kafka-single-node` directory

- Run `docker-compose up -d` 

- Run `docker-compose ps` to confirm the containers are up *(optional)*




## Create topic


- Create a topic "test" with single partition and replica

  ```bash
  docker-compose exec kafka  \
  kafka-topics --create --topic test --partitions 1 --replication-factor 1 --if-not-exists --zookeeper zookeeper:2181
  ```

- Verify topic was created

  ```bash
  docker-compose exec kafka  \
    kafka-topics --describe --topic test --zookeeper zookeeper:2181
  ```

  *OR* 

  ```bash
  docker-compose exec kafka  \
    kafka-topics --list --zookeeper zookeeper:2181
  ```

  
  

## Use CLI producer and consumer 


- ​Start a producer shell and send messages
 
    ```bash
    docker-compose exec kafka  \
    bash -c "seq 42 | kafka-console-producer --request-required-acks 1 --broker-list localhost:9092 --topic test"
    ```
 
 
 
- Consume messages
 
    ```bash
    docker-compose exec kafka  \
      kafka-console-consumer --bootstrap-server localhost:9092 --topic test --from-beginning
    ```
 
 

## Running your code

You can run the exercise code by 

- Runnning `sbt console` in the project folder
- Producer 
    ```scala
    import com.lunatech.kafka.workshop.exercise.ProduceMessages._
    produce()
    ```
- Consumer
    ```scala
    import com.lunatech.kafka.workshop.exercise.ConsumeMessages._
    consume()
    ```