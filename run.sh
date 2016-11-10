#!/usr/bin/env bash

# example of the run script for running the fraud detection algorithm with a python file,
# but could be replaced with similar files from any major language

# I'll execute my programs, with the input directory paymo_input and output the files in the directory paymo_output
javac -d bin -sourcepath src src/Main.java 
java -cp ./bin Main ./paymo_input/batch_payment_t3.csv ./paymo_input/stream_payment_t3.csv ./paymo_output/output_t1.txt ./paymo_output/output_t2.txt ./paymo_output/output_t3.txt
