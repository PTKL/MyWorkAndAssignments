from pyquery import *

html = PyQuery(url='www.abv.bg')
trs = html('table.spad tbody tr')

for tr in trs:
  tds = tr.getchildren()
  print tds[1].text, tds[2].text
