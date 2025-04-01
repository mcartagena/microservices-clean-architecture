Commands to initialize kafka:

(Desde un terminal) colima start

(open in new terminal fron intellij-module-infrastructure) docker-compose -f common.yml -f zookeeper.yml up

(open in new terminal fron intellij-module-infrastructure) docker-compose -f common.yml -f kafka_cluster.yml up

(open in new terminal fron intellij-module-infrastructure) docker-compose -f common.yml -f init_kafka.yml up

Una vez utilizado los docker terminarlos con ctrl + c y para el caso de colima (Desde un terminal) colima stop

Commands to initialize bdd:

- Verifique si ha sido iniciado antes

brew services list

Name          Status  User             File
colima        none
postgresql@14 started marcelocartagena ~/Library/LaunchAgents/homebrew.mxcl.postgresql@14.plist
postgresql@16 none
unbound       none

marcelocartagena@MacBook-Pro-de-mcartagena ~ $ psql postgres

psql (14.15 (Homebrew))
Type "help" for help.

postgres=# CREATE ROLE postgres WITH LOGIN SUPERUSER PASSWORD 'postgres';
CREATE ROLE
postgres=# \du
                                       List of roles
    Role name     |                         Attributes                         | Member of
------------------+------------------------------------------------------------+-----------
 marcelocartagena | Superuser, Create role, Create DB, Replication, Bypass RLS | {}
 postgres         | Superuser                                                  | {}

postgres=# exit

- Si el servicio no ha levantado

brew services start postgresql

En caso de no funcionar probar:

- to start postgressql in local terminal: pg_ctl -D /usr/local/var/postgres -l logfile start

----------------------------------------------------------

Commands to install and use minikube:

brew install minikube

brew install kubectl

brew install helm

colima start --cpu 4 --memory 10 --kubernetes

minikube start --cpus 4 --memory 8192 --driver=docker

minikube status

helm install local-confluent-kafka ./helm/cp-helm-charts --version 0.6.0

kubectl get pods -A
(The -A flag shows all namespaces.)

kubectl apply -f kafka-client.yml

kubectl exec -it kafka-client -- /bin/bash

kafka-topics --zookeeper local-confluent-kafka-cp-zookeeper-headless:2181 --topic customer --create --partitions 3 --replication-factor 3 --if-not-exists
kafka-topics --zookeeper local-confluent-kafka-cp-zookeeper-headless:2181 --topic payment-request --create --partitions 3 --replication-factor 3 --if-not-exists
kafka-topics --zookeeper local-confluent-kafka-cp-zookeeper-headless:2181 --topic payment-response --create --partitions 3 --replication-factor 3 --if-not-exists
kafka-topics --zookeeper local-confluent-kafka-cp-zookeeper-headless:2181 --topic restaurant-approval-request --create --partitions 3 --replication-factor 3 --if-not-exists
kafka-topics --zookeeper local-confluent-kafka-cp-zookeeper-headless:2181 --topic restaurant-approval-response --create --partitions 3 --replication-factor 3 --if-not-exists

kafka-topics --zookeeper local-confluent-kafka-cp-zookeeper-headless:2181 --list

helm uninstall local-confluent-kafka

kubectl delete -f kafka-client.yml

--------------------------------------------------------

helm install local-confluent-kafka ./helm/cp-helm-charts --version 0.6.0

kubectl apply -f application-deployment-local.yml

kubectl delete -f application-deployment-local.yml



