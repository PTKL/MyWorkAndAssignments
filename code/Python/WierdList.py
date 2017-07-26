fruits = ["apple", "banana", "cherry"]
nums = [1, 2, 3, 5, 7]

wierdList = fruits + nums

print wierdList

wierdList.sort()

print wierdList

#del wierdList[0]

wierdList.remove("banana")

print wierdList

aFruit = wierdList.pop(5)

print wierdList
print aFruit