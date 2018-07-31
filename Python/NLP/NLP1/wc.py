import string
data = open('AI_HW1.txt', 'r').read()
print ("Types:%d") % len(string.split(data))
print ("Chars:%d") % len(data)
print ("Lines:%d") % len(data.splitlines())

