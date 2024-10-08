#! /bin/bash
docker stop $(docker ps -q) && docker rm $(docker ps -a -q)
docker rmi $(docker images -a -q)
cd ../users
mvn compile jib:dockerBuild
cd ../books
mvn compile jib:dockerBuild
cd ../rentals
mvn compile jib:dockerBuild
cd ../reviews
mvn compile jib:dockerBuild
cd ../configserver
mvn compile jib:dockerBuild