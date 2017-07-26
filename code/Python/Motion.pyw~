# Mini-project #6 - Blackjack

import simplegui
import random

# load card sprite - 949x392 - source: jfitz.com
CARD_SIZE = (73, 98)
CARD_CENTER = (36.5, 49)
card_images = simplegui.load_image("http://commondatastorage.googleapis.com/codeskulptor-assets/cards.jfitz.png?dl=1")

CARD_BACK_SIZE = (71, 96)
CARD_BACK_CENTER = (35.5, 48)
card_back = simplegui.load_image("http://commondatastorage.googleapis.com/codeskulptor-assets/card_back.png?dl=1")    

# initialize some useful global variables
in_play = False
outcome = ""
outcome2 = ""
score = 0

# define globals for cards
SUITS = ('C', 'S', 'H', 'D')
RANKS = ('A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K')
VALUES = {'A':1, '2':2, '3':3, '4':4, '5':5, '6':6, '7':7, '8':8, '9':9, 'T':10, 'J':10, 'Q':10, 'K':10}


# define card class
class Card:
    def __init__(self, suit, rank):
        if (suit in SUITS) and (rank in RANKS):
            self.suit = suit
            self.rank = rank
        else:
            self.suit = None
            self.rank = None
            print "Invalid card: ", suit, rank

    def __str__(self):
        return self.suit + self.rank

    def get_suit(self):
        return self.suit

    def get_rank(self):
        return self.rank

    def draw(self, canvas, pos):
        card_loc = (CARD_CENTER[0] + CARD_SIZE[0] * RANKS.index(self.rank), 
                    CARD_CENTER[1] + CARD_SIZE[1] * SUITS.index(self.suit))
        canvas.draw_image(card_images, card_loc, CARD_SIZE, [pos[0] + CARD_CENTER[0], pos[1] + CARD_CENTER[1]], CARD_SIZE)
        
# define hand class
class Hand:
    # create Hand object
    def __init__(self):
        self.hand = []
        self.value = 0
        
    # return a string representation of a hand
    def __str__(self):
        string = "Hand contains "
        if len(self.hand) > 0:
            for i in range(len(self.hand)):
                string += self.hand[i].get_suit() + str(self.hand[i].get_rank()) + " "
            return string                
        else:
            return 'Hand is Empty'
        
    # add a card object to a hand
    def add_card(self, card):    
        self.hand.append(card)
        self.value += VALUES[card.get_rank()]
                
    # compute the value of the hand
    # count aces as 1, if the hand has an ace, then add 10 to hand value if it doesn't bust
    def get_value(self):
        for i in range(len(self.hand)):
            if self.hand[i].get_rank() == 'A':
                if self.value + 10 <= 21:
                    return self.value + 10
                break
        return self.value
            
    # draw a hand on the canvas, use the draw method for cards
    def draw(self, canvas, pos):
        for i in range(len(self.hand)):
            self.hand[i].draw(canvas, [pos[0]+CARD_SIZE[0]*i,pos[1]])
        
# define deck class 
class Deck:
    # create a Deck object
    def __init__(self):
        self.deck = []
        for i in range(len(SUITS)):
            for j in range((len(RANKS))):
                self.deck.append(Card(SUITS[i], RANKS[j]))
    
    # shuffle the deck     
    # use random.shuffle()
    def shuffle(self):
        random.shuffle(self.deck)    
        
    # deal a card object from the deck        
    def deal_card(self):
        return self.deck.pop()
    
    # return a string representing the deck
    def __str__(self):
        string = "Deck contains "
        if len(self.deck) > 0:
            for i in range(len(self.deck)):
                string += self.deck[i].get_suit() + str(self.deck[i].get_rank()) + " "
            return string  
        return 'Deck is Empty'


#define event handlers for buttons
def deal():
    global outcome, outcome2, in_play, deck, player_hand, dealer_hand
    # your code goes here
    deck = Deck()
    player_hand = Hand()
    dealer_hand = Hand()
    
    deck.shuffle()
    player_hand.add_card(deck.deal_card())
    dealer_hand.add_card(deck.deal_card())
    player_hand.add_card(deck.deal_card())
    dealer_hand.add_card(deck.deal_card())
    
    outcome = 'Hit or Stand ??'
    outcome2 = ""
    score = 0
    in_play = True
    
def hit():
    # if the hand is in play, hit the player
    global in_play, outcome, outcome2, score
    if in_play:
        if player_hand.get_value() <= 21:
            c = deck.deal_card()
            player_hand.add_card(c)
    # if busted, assign a message to outcome, update in_play and score
        if player_hand.get_value() > 21:
            outcome = 'You have busted !! Dealer wins'
            outcome2 = 'Deal Again ??'
            in_play = False
            score -= 1
       
def stand():
    # if hand is in play, repeatedly hit dealer until his hand has value 17 or more
    global in_play, outcome, outcome2, score
    
    if in_play:
        if player_hand.get_value() > 21:
            outcome = 'You have busted !! Dealer wins'
        else:            
            while dealer_hand.get_value() < 17:
                dealer_hand.add_card(deck.deal_card())
                outcome = dealer_hand.get_value()
            if dealer_hand.get_value() > 21:
                outcome = "Dealer got busted !! Player Wins"
                score += 1
            elif dealer_hand.get_value() >= player_hand.get_value():
                outcome = 'Dealer wins'
                score -= 1
            else:
                outcome = 'Player wins'
                score += 1
    in_play = False                
    outcome2 = 'Deal Again ??'
    # assign a message to outcome, update in_play and score
    
# draw handler    
def draw(canvas):
    # test to make sure that card.draw works, replace with your code below
    global outcome, outcome2, score
    player_hand.draw(canvas, [0,0])
    canvas.draw_text("Player's Hand", [CARD_SIZE[0]*len(player_hand.hand)/2-CARD_SIZE[0]/2, CARD_SIZE[1]+24], 24, 'Black')
    dealer_hand.draw(canvas, [0,CARD_SIZE[1]+48])
    canvas.draw_text("Dealer's Hand", [CARD_SIZE[0]*len(dealer_hand.hand)/2-CARD_SIZE[0]/2, 2*CARD_SIZE[1]+72], 24, 'Black')
    canvas.draw_text('Blackjack: The Game', [100, 580], 48, 'Black')
    canvas.draw_text(str(outcome), [200, 400], 24, 'Black')
    canvas.draw_text(str(outcome2), [250, 450], 24, 'Black')
    canvas.draw_text('Score : '+str(score), [500, 24], 24, 'Black')
    if in_play:
        canvas.draw_image(card_back, CARD_BACK_CENTER, CARD_BACK_SIZE, [CARD_SIZE[0]/2, CARD_SIZE[1]+96], CARD_BACK_SIZE)

# initialization frame
frame = simplegui.create_frame("Blackjack", 600, 600)
frame.set_canvas_background("Green")

#create buttons and canvas callback
frame.add_button("Deal", deal, 200)
frame.add_button("Hit",  hit, 200)
frame.add_button("Stand", stand, 200)
frame.set_draw_handler(draw)


# get things rolling
deal()
frame.start()


# remember to review the gradic rubric
