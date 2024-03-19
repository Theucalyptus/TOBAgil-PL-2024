#!/usr/bin/bash

cd src/

echo "BUILD"
cd ui
javac *.java
cd ..
cd jeu
javac *.java
cd ..
javac *.java
echo "BUILD DONE"

echo "RUN"
java Smallworld
cd ..
echo "DONE"