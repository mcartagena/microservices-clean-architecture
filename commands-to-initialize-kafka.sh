Commands to initialize kafka:

(Desde un terminal) colima start

(open in new terminal fron intellij-module-infrastructure) docker-compose -f common.yml -f zookeeper.yml up

(open in new terminal fron intellij-module-infrastructure) docker-compose -f common.yml -f kafka_cluster.yml up

(open in new terminal fron intellij-module-infrastructure) docker-compose -f common.yml -f init_kafka.yml up

Una vez utilizado los docker terminarlos con ctrl + c y para el caso de colima (Desde un terminal) colima stop
