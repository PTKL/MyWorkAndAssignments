def mul_table(x, y):
    for line in xrange(1, y+1):
        for table in xrange(1, x+1):
            print line * table, "\t",
        print


mul_table(10, 10)
