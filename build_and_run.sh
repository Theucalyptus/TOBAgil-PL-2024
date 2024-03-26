#!/usr/bin/bash

<<<<<<< HEAD
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
=======

function clean() {
    cd src/
    echo "NETTOYAGE"
    find . | grep .class | xargs -r rm
    echo "DONE"

    cd ..
}

function build() {
    cd src/
    echo "COMPILATION"
    javac Smallworld.java
    echo "DONE"
    cd ..
}

function run() {
    cd src/
    echo "EXECUTION"
    java Smallworld
    echo "EXITED"
    cd ..
}

clean
build && 
run
>>>>>>> 12e12bec36e8acd8033a3612fddb48cada3d5c59
