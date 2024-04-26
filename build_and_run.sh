#!/usr/bin/bash

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
clean
