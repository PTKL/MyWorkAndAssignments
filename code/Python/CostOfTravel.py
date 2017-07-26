def hotel_cost(nights):
    cost = 100 * nights
    
    if nights > 7:
        cost *= 0.7
    elif nights > 3:
        cost *= 0.8
        
    return cost

def transport_cost (contry):
    if contry == "Belgium":
        return 80
    elif contry == "Netherlands":
        return 100
    elif contry == "Germany":
        return 120

print "The total cost of the hotel is (5 nights) " + str (hotel_cost(10))
print "The total cost of transport to Germany is " + str (transport_cost("Germany"))