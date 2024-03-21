#!/usr/bin/bash


function clean() {
    cd src/
    echo "NETTOYAGE"
    find . | grep .class | xargs -r rm
    cd ..
}

function build() {
    cd src/
    javac Smallworld.java
    cd ..
}

function run() {
    cd src/
    java Smallworld
    cd ..
}

clean
build && 
run
