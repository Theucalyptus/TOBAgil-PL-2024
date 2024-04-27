#!/usr/bin/bash

cd src
classes=$(find . -name "*.class")
sources=$(find . -name "*.java")
jar cvfm ../SmallWorld.jar ../manifest.txt $files $sources
