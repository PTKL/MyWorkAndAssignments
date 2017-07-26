#from docutils.nodes import row
player = 1
board = [[0, 0, 0], [0, 0, 0], [0, 0, 0]]


def printBoard():
    for row in board:
        print row
        
        
def switchPlayer():
    global player
    
    if player == 1:
        player = 2
    elif player == 2:
        player = 1


def checkWinning(row, column):
    if board[row][0] == board[row][1] == board[row][2]:
        return True
    if board[0][column] == board[1][column] == board[2][column]:
        return True
    if board[0][0] == board[1][1] == board[2][2] and board[1][1] != 0:
        return True
    if board[0][2] == board[1][1] == board[2][0] and board[1][1] != 0:
        return True
    return False
    

def checkDrawn():
    for row in range(0, len(board)):
        for column in range(0, len(board[row])):
            if board[row][column] == 0:
                return False
    return True
        

while True:
    print "Player %d's turn" % player
    printBoard()
    
    validMove = False
    
    while  not validMove:
        row = int(raw_input("row: "))
        column = int(raw_input("column: "))
        print""
        
    if row > 0 and row <= 3 and board[row - 1][column - 1] == 0:
        board[row - 1][column - 1] = player
        validMove = True
    else:
        print"Invalid move try again"
        validMove = False
        
    if checkWinning(row - 1, column - 1):
        print "Player %d won" % player
        printBoard()
        break
    elif checkDrawn():
        print "Draw" 
        printBoard()
        break
    else:
        switchPlayer()
        printBoard()