#! /bin/bash
docker stop $(docker ps -q) && docker rm $(docker ps -a -q)
docker rmi $(docker images -a -q)
cd ../users
mvn compile jib:dockerBuild
cd ../books
mvn compile jib:dockerBuild
