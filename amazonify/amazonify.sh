#!/bin/bash

# Absolute path to this script, e.g. /home/user/bin/foo.sh
SCRIPT=$(readlink -f "$0")
# Absolute path this script is in, thus /home/user/bin
SCRIPTPATH=$(dirname "$SCRIPT")

DEFAULT_VER=1.16.0-SNAPSHOT

if [ -n "$1" ] && [ -e $1 ]; then
  FILE=$(readlink -f $1)

  echo "Updating: $FILE"
  cd $SCRIPTPATH

  if [ -n "$2" ] && [ -e aws-${2}.properties ]; then
    echo "Using profile: $2"
    
    cp aws-${2}.properties WEB-INF/classes/ngpp.properties
    echo "aws-${2}.properties" > custom.nfo
    if [ $2 = "wpstatic" ]; then
      VER="1.15.0"
    else
       VER=$DEFAULT_VER
    fi

    perl -p -i -e "s/Specification-Version.*/Specification-Version: $VER/g" META-INF/MANIFEST.MF
    perl -p -i -e "s/Implementation-Version.*/Implementation-Version: $VER/g" META-INF/MANIFEST.MF

    zip $FILE .ebextensions
    zip $FILE META-INF/context.xml
    zip $FILE WEB-INF/classes/ngpp.properties
    zip $FILE custom.nfo
    zip $FILE META-INF/MANIFEST.MF

    rm custom.nfo
    rm WEB-INF/classes/ngpp.properties

    echo " .. done .. "
  else
    echo "No profile found '$2'..."
    ls aws*.properties
  fi 
else
  echo "Could not find file '$1'.."
fi
