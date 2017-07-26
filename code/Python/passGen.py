import itertools
res = itertools.product('abcdefghjklmnpqrstuvwxyz', repeat=8) # Virgin Media
# res = itertools.product('0123456789abcdef', repeat=10) #bt 10
for i in res: 
    print ''.join(i)
