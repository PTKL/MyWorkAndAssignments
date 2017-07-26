fox = "A quick brown fox"

foxList = fox.split()

print foxList

foxList.remove("quick")

print foxList

newFox = ""

for word in foxList:
    newFox += word + " "
    
print newFox

buildings = "McCrea, Moore, Bourne"
bList = buildings.split(",")

print bList