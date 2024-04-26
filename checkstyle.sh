#!/usr/bin/bash

FILEPATH=checkstyle-10.14.0-all.jar
URL=https://github.com/checkstyle/checkstyle/releases/download/checkstyle-10.14.0/checkstyle-10.14.0-all.jar


if [ ! -f $FILEPATH ]; then
    echo checkstyle non-trouvé, on le télécharge
    wget $URL
fi

# java -jar $FILEPATH -c checkstyle.xml src/**.java
find -name "*.java" -print -exec java -jar $FILEPATH -c checkstyle.xml {} \; | grep "[ERROR]" >erreursCheckStyle.log