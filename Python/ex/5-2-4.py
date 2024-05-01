import pymysql

with open("passwd.txt") as f:
    lines = f.readline()
    passwd = lines

connection = pymysql.connect(host = 'localhost', port = 3306, db = 'INVESTAR', user = 'root', passwd = passwd, autocommit = True)

cursor = connection.cursor()
cursor.execute("SELECT VERSION();")
result = cursor.fetchone()

print(f"MariaDB version : {result}")

connection.close()