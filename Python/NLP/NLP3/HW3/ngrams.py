# -*- coding: utf-8 -*-
import sys
import re
import collections
from collections import Counter, OrderedDict
#!/usr/bin/env python2
# # -*- coding: utf-8 -*-
""" ngrams.py """
__author__="Stevie Scheid"

def read():
    input_F = open(sys.argv[1], 'r')
    input_F = input_F.read()
    input_F = replace(input_F)
    model_F = open(sys.argv[2], 'r')
    return input_F, model_F

def replace(input_F):
    input_F = input_F.replace('\*','')
    input_F = input_F.replace('\n','')
    input_F = input_F.replace('  ',' ')
    input_F = input_F.replace('.',' STOP * * ')
    input_F = input_F.replace('. ',' STOP * * ')
    input_F = input_F.replace('.',' STOP * * ')
    input_F = input_F.replace('!',' STOP * * ')
    input_F = input_F.replace('?',' STOP * * ')
    input_F = input_F.replace(':',' ')
    input_F = input_F.replace(';',' ')
    input_F = input_F.replace('_','')
    input_F = input_F.replace('\'',' ')
    input_F = input_F.replace(',',' ')
    input_F = input_F.replace(')',' ')
    input_F = input_F.replace('(',' ')
    return input_F

def write(words):
    #write words to file
    model_F = open(sys.argv[2], 'a')
    for word in words:
        model_F.write(word)
        model_F.write('\t')
        s = str(words[word])
        model_F.write(s)
        model_F.write('\n')

def ngrams(input_F, n):
    words = input_F.split(' ')
    words = ([' '.join(words[i:i+n]) for i in range(len(words)-n+1)])       
    words = collections.Counter(words)
    return OrderedDict(words.most_common())
    
if __name__== "__main__":
    input_F, model_F = read()

    words = ngrams(input_F, 1)
    write(words)
    words = ngrams(input_F, 2)
    write(words)
    words = ngrams(input_F, 3)
    write(words)

#ALTERNATE REGEX
"""def gen_unigram(input_F):
    word_L = re.findall(r'\w+|\*\*', input_F)
    word_L = collections.Counter(word_L)
    word_L = OrderedDict(word_L.most_common())
    write_uni(word_L)

def gen_bigram(input_F):
    bi_L = re.findall(r'(\w+ \w+)', input_F)
    bi_L = collections.Counter(bi_L)
    bi_L = OrderedDict(bi_L.most_common())
    bi_L2 = re.findall(r'\*\* \w+', input_F)
    bi_L2 = collections.Counter(bi_L2)
    bi_L2 = OrderedDict(bi_L2.most_common())
    write_bi(bi_L)
    write_bi(bi_L2)

def write_bi(bi_L):
    model_F = open(sys.argv[2], 'a')
    for word in bi_L:
        model_F.write(word)
        model_F.write('\t')
        s = str(bi_L[word])
        model_F.write(s)
        model_F.write('\n')

def gen_trigram(input_F):
    tri_L = re.findall(r'\w+ \w+ \w+|\* \*\* \w+', input_F)
    tri_L = collections.Counter(tri_L)
    tri_L = OrderedDict(tri_L.most_common())
    tri_L2 = re.findall(r'\* \w+ \w+', input_F)
    tri_L2 = collections.Counter(tri_L2)
    tri_L2 = OrderedDict(tri_L2.most_common())
    write_tri(tri_L)
    write_tri(tri_L2)

def write_tri(tri_L):
    model_F = open(sys.argv[2], 'a')
    for word in tri_L:
        model_F.write(word)
        model_F.write('\t')
        s = str(tri_L[word])
        model_F.write(s)
        model_F.write('\n')       
    
if __name__== "__main__":
    input_F, model_F = read()
    #word_L = gen_unigram(input_F)
    #bi_L = gen_bigram(input_F)
    #tri_L = gen_trigram(input_F)"""
