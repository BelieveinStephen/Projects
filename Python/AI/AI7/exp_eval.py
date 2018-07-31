import sys
#!/usr/bin/env python2
# # -*- coding: utf-8 -*-
""" KB program """
__author__="Stevie Scheid"

def generate_KB(line):
    PL, KEY = line.split(',', 1)
    KEY = generate_PL(KEY, PL)
    return PL, KEY

def generate_PL(KEY, PL):
    KEY = KEY.replace('=', ' ')
    KEY = KEY.replace('\n', '')
    KEY = KEY.split(',')
    for i in range(len(KEY)):
        KEY[i] = KEY[i].split(' ')
        key = KEY[i][0]
        val = KEY[i][1]
        PL = PL.replace(key, val)
    return PL

def logic_analysis(PL):
    PL = PL.replace('V', 'or')
    PL = PL.replace('^', 'and')
    PL = PL.replace('~F', 'T')
    PL = PL.replace('~T', 'F')
    PL = PL.replace('F', 'False')
    PL = PL.replace('T', 'True')
    return eval(PL)
        
if __name__== "__main__":
    f = open(raw_input('Enter file name: '), 'r')
    for line in f:
        PL, KEY = generate_KB(line)
        PL = generate_PL(PL,KEY)
        print line, logic_analysis(PL) 
