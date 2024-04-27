#!/usr/bin/bash

cd src
files=$(find . -name "*.class")
jar cvfm ../SmallWorld.jar ../manifest.txt $files
