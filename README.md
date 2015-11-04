# Spring Docker mySql Demo
This is a demo of a web service using Spring-boot and a mySql connection using JPA and Spring-data. The all project is contanerize by Docker, using three different container as the only-data-pattern of Docker suggest.

## Structure
Three Docker image:
- **web**: based from `java:8` image, used only to run the spring application.
- **mysql**: based on a `mysql:5.7` image, use to run the mysql demon.
- **data**: used to store the mysql database.

The demo use gradle as building tools with the docker plugin to automatic build all the necessary image.

The database is access by the hibernate/JPA technology.

## How to run
### prerequisite
- **Docker**, with the permission to run containers in user mode (simply add your user to the *docker* group)
- **Java 8**

### run the demo
Go inside the folder of the demo and run:
```
./gradlew buildDocker
```

Now start all the container with:
```
./start.sh
```

Eventually the demo is accessible at  `http://localhost:8080`.

You can use all the docker command to view and administrate the docker container as:
- `docker ps` view the running container
- `docker stop <name>` stop a container
- `docker start <name` start a container
- `docker rm <name>` remove a container

If you do `docker ps` you can't see the only data container because it is not a real running container, but something similar to a external shared folder.
