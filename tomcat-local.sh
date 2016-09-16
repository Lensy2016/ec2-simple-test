#!/usr/bin/env bash

# Debug port is 8081..
export MAVEN_OPTS=-agentlib:jdwp=transport=dt_socket,address=8081,server=y,suspend=n

mvn clean package tomcat7:run
