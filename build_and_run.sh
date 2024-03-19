#!/usr/bin/bash

cd src/

echo "BUILD"
cd ui
javac *.java
cd ..
javac Smallworld.java
echo "BUILD DONE"

echo "RUN"
java Smallworld
cd ..
echo "DONE"