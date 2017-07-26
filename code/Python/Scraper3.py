import urllib2
response = urllib2.urlopen('http://abv.bg')
html = response.read()
