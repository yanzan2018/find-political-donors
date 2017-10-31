#!/bin/bash
#
# Use this shell script to compile (if necessary) your code and then execute it. Below is an example of what might be found in this file if your program was written in Python
#
#python ./src/find_political_donors.py ./input/itcont.txt ./output/medianvals_by_zip.txt ./output/medianvals_by_date.txt

if [ ! -d "bin" ]
then
 mkdir bin
fi

javac -d bin/ src/donors/political/*.java src/entities/donors/political/*.java src/interfaces/donors/political/*.java src/imp/donors/political/*.java

java -cp bin donors.political.App /input/itcont.txt /output/medianvals_by_zip.txt /output/medianvals_by_date.txt

rm -rf bin
