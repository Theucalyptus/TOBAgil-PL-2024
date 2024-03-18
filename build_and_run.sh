#!/usr/bin/bash

cd src/

echo "BUILD"
javac MainGui.java
javac Smallworld.java
echo "BUILD DONE"

echo "RUN"
java Smallworld
cd ..
echo "DONE"