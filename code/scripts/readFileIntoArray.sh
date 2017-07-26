#!/bin/bash
# Read the file in parameter and fill the array named "array"
getArray() {
    local i=0
    array=() # Clear array
    while IFS= read -r line # Read a line
    do
        array+=( "$line" ) # Append line to the array
    done < "$1"
}

getArray "bash.txt"

# Print the file (print each element of the array)
getArray "bash.txt"
for e in "${array[@]}"
do
    echo "$e"
done