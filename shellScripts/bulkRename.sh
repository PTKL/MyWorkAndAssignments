#!/bin/bash

#This uses bash command substitution to remove the first 6 characters from the input filename via cut, prepends CL to the result, and stores that in $newname. Then it renames the old name to the new name. This is performed on every file.

#cut -c7- specifies that only characters after index 7 should be returned from the input. 7- is a range starting at index 7 with no end; that is, until the end of the line.

#Previously, I had used cut -b7-, but -c should be used instead to handle character encodings that could have multiple bytes per character, like UTF-8.

for name in fileName*
do
    newname=CL"$(echo "$name" | cut -c7-)"
    mv "$name" "$newname"
done
