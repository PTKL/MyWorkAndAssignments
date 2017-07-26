fruits = ["apple", "banana", "cherry"]
nums = [1, 2, 3, 5, 7]
nothing = []

print fruits
print nums
print nothing

#print fruits[0]
#print nums[2]

print "There are " + str(len(fruits)) + " fruits"

print nums[1]
nums[1] = 8
print nums[1]

for index in range (0, len(nums)):
    nums[index] *= 2
print nums

for num in nums:
    print num,