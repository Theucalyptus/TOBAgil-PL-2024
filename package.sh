#!/usr/bin/bash

rm SmallWorld.jar
cd src
classes=$(find . -name "*.class")
sources=$(find . -name "*.java")
jar cvfm ../SmallWorld.jar ../manifest.txt $classes $sources
