#!/usr/bin/python

import gdata.spreadsheets.client
import gdata.gauth
import RPi.GPIO as GPIO
import urllib
import urllib2
from time import sleep

HEATERPIN = 12
COOLERPIN = 16

GPIO.setmode(GPIO.BOARD)
GPIO.setup(HEATERPIN, GPIO.OUT, initial=0)
GPIO.setup(COOLERPIN, GPIO.OUT, initial=0)

def baseN(num,b,numerals="0123456789abcdefghijklmnopqrstuvwxyz"):
    return ((num == 0) and numerals[0]) or (baseN(num // b, b, numerals).lstrip(numerals[0]) + numerals[num % b])

GURL = 'your-script-url'  # without ?aurl params
GID=1542622212
SPID = '1W2l7WWIQTx-mZtEbvDAxfQJvmwEnrDje57iBlHpnpgM'
MCLIENT_ID = '101533832-dil3ulvlq372edkb3a59dltqik2g1f1e.apps.googleusercontent.com'
MCLIENT_SECRET = 'eK3oAbkFWMzrnyW1qvBPI9EW'
MSCOPE = 'https://spreadsheets.google.com/feeds https://docs.google.com/feeds'
MREDIRECT_URI = 'urn:ietf:wg:oauth:2.0:oob'

if GID>31578:
    WID = 'o' + str(baseN(GID^474,36))
else:
    WID = str(baseN(GID^31578,36))

try:
    OAuthToken = gdata.gauth.OAuth2Token(client_id=MCLIENT_ID,
    client_secret=MCLIENT_SECRET,
    scope= MSCOPE,
    user_agent='iotdevice.client')
    token_url =  OAuthToken.generate_authorize_url()
    print token_url

    # this will send the token url to google sheet. use GoogleAppScriptForPI.txt file to create
	# another Google Appscript with anonymous access.
	# Usage: After running this module, this will ask for verification code. Go and execute your appscript
	# from your browser to get Authorization Link and click on it to get Verification code.
    values = {'aurl': token_url}
    data = urllib.urlencode(values)
    req = urllib2.Request(GURL,data)
    response=urllib2.urlopen(req)
    resp = response.read()

    print resp

    code = raw_input('Run Google App Script on your browser for Authorization and enter  verification code here: ').strip()
    OAuthToken.get_access_token(code)

    rtoken= OAuthToken.refresh_token
    atoken=OAuthToken.access_token

    OAuthToken = gdata.gauth.OAuth2Token(client_id=MCLIENT_ID,
    client_secret=MCLIENT_SECRET,
    scope=MSCOPE,
    user_agent='iotdevice.client',
    access_token=atoken,
    refresh_token=rtoken)

    client = gdata.spreadsheets.client.SpreadsheetsClient()
    OAuthToken.authorize(client)

    while True:
        print 'CHECK FOR UPDATE...'
        cquery = gdata.spreadsheets.client.CellQuery(2,2,6,7)
        cells = client.GetCells(SPID, WID, q=cquery)
        heaterswitch = cells.entry[0].cell.input_value
        coolerswitch = cells.entry[1].cell.input_value
        if heaterswitch == '1':
            print 'HEATER ON'
            GPIO.output(HEATERPIN, 1)
        else:
            print 'HEATER OFF'
            GPIO.output(HEATERPIN, 0)
        if coolerswitch == '1':
            print 'COOLER ON'
            GPIO.output(COOLERPIN, 1)
        else:
            print 'COOLER OFF'
            GPIO.output(COOLERPIN, 0)
        print 'UPDATE COMPLETE.'
        sleep(5)
except KeyboardInterrupt:
    print 'Program stopped through break!'
except:
    print 'Some error occured!'
finally:
    GPIO.cleanup()
