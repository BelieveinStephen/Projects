import re
import random
import sys
""" CFG Sentence Generator.""" 
#!/usr/bin/env python2
# # -*- coding: utf-8 -*-
  



f = open(sys.argv[1], 'r')
count = sys.argv[2]

def create_rules(contents):
    rules = {}
    for line in f:
        line = line.strip()
        if len(line)>2 and line[0] != '#':
            temp = line.split("\t")
            key = temp[1]
            val = [temp[2].split()]
            # if the key already exists append to the value.
            if key in rules:
                rules[key].append(val)
            #Otherwise:
            else:
                rules[key] = val
    return rules   

p = create_rules(f)
print(p)

"""def generate_sentence():
    temp = 'ROOT'
    for elements in p:
        if key != temp:
            return temp
        else:
            r = random.randint(1, len(rules[key]))
            temp.replace(key, rules[key][r])         
            temp.append(temp.split())
            generate_sentence(temp)"""
    



