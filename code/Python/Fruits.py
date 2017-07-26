fruits = ["apple", "banana", "cherry"]

#fruits += ["orange"]
#fruits.append("orange")

fruit = raw_input("give fruit: ")

if fruit in fruits:
    print fruit + " already in list"
else:
    print "Adding " + fruit
    fruits.append(fruit)

print fruits