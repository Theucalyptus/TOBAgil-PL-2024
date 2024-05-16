#!/usr/bin/bash

FILEPATH=checkstyle-10.16.0-all.jar
URL=https://github.com/checkstyle/checkstyle/releases/download/checkstyle-10.16.0/checkstyle-10.16.0-all.jar


if [ ! -f $FILEPATH ]; then
    echo checkstyle non-trouvé, on le télécharge
    wget $URL
fi

# java -jar $FILEPATH -c checkstyle.xml src/**.java
# supprimer les espaces en fin de ligne
find -name "*.java" -exec sed -i "s/[[ ]]*$//" {} \;
# appliquer le checkstyle
find -name "*.java" -print -exec java -jar $FILEPATH -c checkstyle.xml {} \; | grep "\[ERROR\]" >erreursCheckStyle.log