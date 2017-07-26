num = 6
lower_bound = 0
upper_bound = 100
guess = 0
lost = False
currentPlayer = 1

def switchPlayer(currentPlayer):
    if currentPlayer == 1:
        return 2
    elif currentPlayer == 2:
        return 1

while not lost:
        print "Between " + str(lower_bound) + " and " + str(upper_bound)
        print "Player " + str(currentPlayer) + "'s turn"
        guess = int(raw_input("> "))
        
        if guess <= lower_bound or guess >= upper_bound:
            print"Invalid input"
        else:
            if guess == num:
                print "You Lost"
                lost = True
            else:
                if guess < num:
                    lower_bound = guess
                else:
                    upper_bound = guess
                    currentPlayer = switchPlayer(currentPlayer)