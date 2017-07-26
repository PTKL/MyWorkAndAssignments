def posOrNeg (num):
    if num == 0:
        print "Zero"
        return False
    elif num < 0:
        print "Negative"
        return True
    elif num > 0:
        print "Positive"
        return True
num = 1
while posOrNeg(num):
    num = raw_input("Give number: ")
    num = int(num)
