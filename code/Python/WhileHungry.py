hungry = True

while hungry:
	reply = raw_input ("Are you hungry? Y/N: ")

	if reply == "Y":
		print "Eat!"
	elif reply == "N":
		print "Don't eat..."
		hungry = False		
	else:
		print "Invalid Input"
