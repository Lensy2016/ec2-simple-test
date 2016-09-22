#!/usr/bin/env bash

PROFILES=$1

# Debug port is 8081..
export MAVEN_OPTS=-agentlib:jdwp=transport=dt_socket,address=8081,server=y,suspend=n

if [[ ! -z "${PROFILES}" ]]; then
    echo "Using Spring profiles: ${PROFILES}"
    mvn clean package tomcat7:run -P${PROFILES}
else
    mvn clean package tomcat7:run
fi
