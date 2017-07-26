from webscraping import download, xpath
D = download.Download()

html = D.get('www.abv.bg')
for row in xpath.search(html, '//table[@class="spad"]/tbody/tr'):
    cols = xpath.search(row, '/td')
    print 'Sunrise: %s, Sunset: %s' % (cols[1], cols[2])
