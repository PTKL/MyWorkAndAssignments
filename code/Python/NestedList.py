odd = [1, 2, 3]
even = [2, 4, 6, 8]

nums = [odd, even]

print nums

print nums[0]
print nums[1]

print nums[0][1]
print nums[1][2]

# multiply by 2
for index in range(0, len(nums[0])):
    nums[0][index] *= 2
print nums[0]

# multiply by 2
for index in range(0, len(nums[1])):
    nums[1][index] *= 2
print nums[1]

print nums

# multiply every element by 10 with nested loop
for numList in range(0, len(nums)):
    for index in range (0, len(nums[numList])):
        nums[numList][index] *= 10
        
print nums


