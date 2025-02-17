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

