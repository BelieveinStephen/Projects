import sys
#!/usr/bin/env python2
# # -*- coding: utf-8 -*-
""" test-model-s.py """
__author__="Stevie Scheid"

def read_model(model_F):
    prob_D = gen_D(model_F)
    return prob_D
    
def gen_D(model_F):
    prob_D = {}
    with open(model_F, 'r') as f:
        for line in f:
            temp = line.replace(' ', '')
            temp = line.split('\t')
            key = temp[0]
            count = temp[1]
            count = count.rstrip()
            prob_D[key] = count
        return prob_D           
            
def sent_prob_uni(prob_D):
    for words in line:
        return gen_uni(line)

def gen_uni(line):
    count = len(prob_D)
    prob = 1
    line = replace(line)
    line_L = line.split(' ')
    for i in range(len(line_L) - 1):
        word1 = line_L[i]
        if word1 not in prob_D:
            temp_P = float(0.0000001)
        else:
            temp_P = (int(prob_D[word1])/count)*float(0.008)
        prob *= temp_P
    return prob
            
def sent_prob_bi(prob_D):
    for words in line:
        return gen_bigram(line)

def gen_bigram(line):
    prob = 1
    line = replace(line)
    line_L = line.split(' ')
    for i in range(len(line_L) - 1):
        word1 = line_L[i]
        word2 = line_L[i + 1]
        if i == 0:
            bigram = '* ' + word1
            word1 = '*'
            i = -1
        else:
            bigram = word1 + ' ' + word2
        if bigram or word1 not in prob_D:
            temp_P = float(0.0000001)
        else:
            temp_P = ((prob_D[bigram]/prob_D[word1])*float(.08)) + ((prob_D[word1]/len(prob_D))*float(.08))
        prob *= temp_P
    return prob

def sent_prob_tri(prob_D):
    for words in line:
        return gen_tri(line)

def gen_tri(line):
    prob = 1
    line = replace(line)
    line_L = line.split(' ')
    for i in range(len(line_L) - 2):
        word1 = line_L[i]
        word2 = line_L[i + 1]
        word3 = line_L[i + 2]
        if i == 0:
            trigram = '* ** ' + word1
            bigram = '* **'
            i = -1
        elif i == 1:
            trigram = '* ' + word1 + ' ' + word2
            bigram = '** ' + word1
            i = 0
        else:
            trigram = word1 + ' ' + word2 + ' ' + word3
            bigram = word1 + ' ' + word2
        if trigram or bigram not in prob_D:
            temp_P = float(0.0000001)
        else:
            temp_P = ((prob_D[trigram]/prob_D[bigram])*float(0.8))+((prob_D[bigram]/prob_D[word1])*float(0.8)) + ((prob_D[word1]/len(prob_D))*float(0.8))
        prob *= temp_P
    return prob

def replace(line):
    line = line.replace('.', ' STOP')
    line = line.replace('?', ' STOP')
    line = line.replace('!', ' STOP')
    line = line.replace(':',' ')
    line = line.replace(';',' ')
    line = line.replace('_','')
    line = line.replace('\'',' ')
    line = line.replace(',',' ')
    line = line.replace(')',' ')
    line = line.replace('(',' ')
    line = line.replace('\*','')
    return line

if __name__== "__main__":
    model_F = sys.argv[1]
    sentence_F = sys.argv[2]
    
    prob_D = read_model(model_F)
    with open(sentence_F, 'r') as f:
        for line in f:
            print sent_prob_uni(prob_D)
            
    with open(sentence_F, 'r') as f:
        for line in f:
            print sent_prob_bi(prob_D)
            
    with open(sentence_F, 'r') as f:
        for line in f:
            print sent_prob_tri(prob_D)
