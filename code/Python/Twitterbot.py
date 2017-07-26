#!/usr/bin/env python2

import sys
import time
from datetime import datetime
from twython import Twython

class bot:
	def __init__(self, c_key, c_secret, a_token, a_token_secret):
		# Twython API instance
		self.api = Twython(self, c_key, c_secret, a_token, a_token_secret)
		
		# Authentication check
		try:
			self.api.verify_credentials()
		except:
			sys.exit("Authentication Fail")
			
		self.last_ran = datetime.now()
		
	@staticmethod
	
	def timestr_to_datetime(timestr):
		# convert string to a datetime object
		timestr = "{0} {1}".format(timestr[:19], datetime.now().year)
		
		return datetime.strptime(timestr, '%a %b %d %H: %M: %S %Y')e
		
	def retweet_task(self, screen_name):
		print "Checking for new tweets from @{0}".format(screen_name)
		
		# get list of latest tweets
		timeline = self.api.get_user_timeline(screen_name = screen_name)
		
		# loop to check if tweet was posted since last call
		for t in timeline:
			tweet_time = bot.timestr_to_datetime(t['created_at'])
			if tweet_time > self.last_ran:
				print "Retweeting {0}".format(t['id'])
				self.api.retweet(id = t['id'])
				
if __name__ == "__main__":
	# consumer keys and tokens at dev.twitter.com/apps
	
	c_key = ""
	c_secret = ""
	a_token = ""
	a_token_secret = ""
	
	# create instance of bot class
	twitter = bot(self, c_key, c_secret, a_token, a_token_secret)
	
	# retweet anything new from @User every 5 min.
	twitter.retweet_task("@User")
	twitter.last_ran = datetime.now()
	time.sleep(5 * 60)
