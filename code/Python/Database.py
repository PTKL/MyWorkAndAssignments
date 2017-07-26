# Most common DBAPI conversion modules
# MySQL - MySQLdb
# PostrgeSQL - psycopg(2)
# SQLite - sqlite3
# Oracle - oracle
# M$ SQL server - adodbapi
# to create user (as root) with necessary privilages:
# mysql&gt; grant all on *.* to test_user@localhost identified by 'showmedo' with grant option;
# import relevant module
import MySQLdb 

# test variables for database access
HOST = 'localhost'
USER = 'test_user'
PASSWD = 'showmedo'
DATABASE = 'showmedo_test'

# test DB data to insert into new tables
# name, email, join-date, author-status
table_data = {
        'showmedo_user':(
        ('kyran dale', 'kg@showmedo.com', '2007-09-11',0),
        ('ian ozsvald', 'ian@showmedo.com', '2008-01-11',1),
        ('thomas eddison', 'tom@gec.com', '2007-11-24',1),
        ('richard coates', 'rc@tinburgen.org', '2008-04-22',0),
        ('karl von frisch', 'kvf@maxplank.ac.de', '2008-01-09',0),
        ('susan mortimer', 'suzie@backlogger.com', '2007-08-15',1),
        ('alan sussman', 'alan.sussman@gmail.com', '2007-07-15',0),
        ('bernard reeves', 'bernie@abc.com', '2007-07-23',0),
        ('phil tensing', 'phit@mmd.com', '2008-02-05',0),
        ('elaine dean', 'ellie@lotech.com', '2007-11-24',1),
        )
    }

def prettyPrint(data):
    print "There are %d data items"%len(data)
    for i,d in enumerate(data):
        print "%d --- "%i, d

# make a connection to the DATABASE database
# if we were using, for example, a Postrgres database this line would start:
# db_connection = psycopg.connect( ...
db_connection = MySQLdb.connect(
        host=HOST,
        user=USER, 
        passwd=PASSWD, 
        #db=DATABASE
        )

# we'll need a cursor to this database to execute commands
cursor = db_connection.cursor()

# demonstrate the creation of a database
#cursor.execute('show databases')
#prettyPrint(cursor.fetchall())
#cursor.execute('create database showmedo_test')
#cursor.execute('show databases')
#prettyPrint(cursor.fetchall())

## switch to using the newly-created database
cursor.execute('use showmedo_test')

# use the cursor to execute a 'create table' command
#cursor.execute("""
#CREATE TABLE showmedo_user(
  #id INTEGER  NOT NULL AUTO_INCREMENT,
  #name VARCHAR(255)  NOT NULL,
  #email VARCHAR(255),
  #join_date DATE,
  #author_status TINYINT(1),
  #PRIMARY KEY(id)
#)
#""")

# loop through our table-data, inserting items into the database
for data in table_data['showmedo_user']:
    qstr = "INSERT INTO showmedo_user " +\
            "(name, email, join_date, author_status) values ('%s', '%s', '%s', %d)"%(data[0], data[1], data[2], data[3])
    print qstr         
    cursor.execute(qstr)