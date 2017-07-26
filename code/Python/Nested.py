num = raw_input("number: ")

num = float(num)

if num > 0:
	print str(num) + " is a positive"
	
	if num % 2 == 0:
		print str(num) + " is a even"
	else:
		print str(num) + " is a odd"
elif num == 0:
	print str(num) + " is zero"
	
else:
	print str(num) + " is a negative"
	
	if num % 2 == 0:
		print str(num) + " is a even"
	else:
		print str(num) + " is a odd"
