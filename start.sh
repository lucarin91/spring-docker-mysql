#!/bin/bash
baseName="springapp"

# docker stop ${baseName}-data
# docker rm ${baseName}-data
docker run --name ${baseName}-data spring/${baseName}-data

docker stop ${baseName}-mysql
docker rm ${baseName}-mysql
docker run --name ${baseName}-mysql \
              --volumes-from ${baseName}-data \
              -p 3306:3306 \
              -d \
              spring/${baseName}-mysql

docker stop ${baseName}-web
docker rm ${baseName}-web
docker run --name ${baseName}-web \
              -p 8080:8080 \
              --link ${baseName}-mysql:mysql \
              -t \
              spring/${baseName}-web
