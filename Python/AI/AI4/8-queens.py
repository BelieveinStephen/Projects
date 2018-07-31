# -*- coding: utf-8 -*-
import sys
import re
from random import randint

#!/usr/bin/env python2
# # -*- coding: utf-8 -*-
""" 8-queens program """
__author__="Stevie Scheid"

def generate_RND_board():
    current = [randint(1,8) for k in range(8)]
    return current

def sim_restart(current):  
    prev_heur = 26
    heur = prev_heur - 1
    cost = 0
    while prev_heur > heur:
       prev_heur = heur
       heur, row_pos, col_pos = min_heur(current)
       row_pos = randint(0, len(current) - 1)
       col_pos = randint(0, len(current) - 1)
       current[col_pos] = row_pos
       cost += 1
    return current, cost, heur

# def sim_algo(current):

    #return child

# def sim_anneal(current):
    #current=initial state of problem
    #t=1 //initialize time
    #loop
        #T = coolDown(t) //converts time in Temp.
        #if T=0 then return current
        #next = random successor of current
        #δE = next.VALUE - current.VALUE
        #if δE>0 then current=next
        #else current=next with some prob (eδE T )
        #t=t+1

def sim_hill_climb(current):
    #current = problem.INITIAL_STATE
    #loop
        #neighbor = highest-value successor of current
        #if (neighbor.VALUE<=current.VALUE) then
            #return current.STATE
        #current = neighbor
    prev_heur = 26
    heur = prev_heur - 1
    cost = 0
    while prev_heur > heur:
       prev_heur = heur
       heur, row_pos , col_pos = min_heur(current)
       current[col_pos] = row_pos
       cost += 1
    return current, cost, heur

def calc_heur(current):
    h = 0
    for i in range(len(current)):
        for j in range(i+1,len(current)):
            if current[i] == current[j]:
                h +=1
            cross = j-i
            if current[i] == current[j] - cross or current[i] == current[j] + cross:
                h += 1
    return h

def min_heur(current):
    min_heur = 100
    row_pos = -1
    col_pos = -1
    for i in range(len(current)):
        curr_pos = current[i]
        for j in range(len(current)):
            current[i] = j
            heur = calc_heur(current)
            if heur < min_heur:
                min_heur = heur
                row_pos = j
                col_pos = i
        current[i] = curr_pos
    return min_heur, row_pos, col_pos

def calc_percent(total, solved):   
    if solved == 0:
        return 0
    else:
        return (solved/float(total))*100
    
if __name__== "__main__":
    print "{0} puzzles" .format(int(sys.argv[1]))
    heur = 0
    solved = 0
    cost = 0
    for i in range(int(sys.argv[1])):
        x = generate_RND_board()
        current, icost, heur = sim_hill_climb(x)
        if heur == 0:
            solved += 1
        cost += icost
    percent = calc_percent(int(sys.argv[1]), solved)
    print "Hill-climbing: {0}% solved, search cost: {1}" .format(percent, cost)

    heurRR = 0
    solvedRR = 0
    costRR = 0
    for i in range(int(sys.argv[1])):
        y = generate_RND_board()
        current, icostRR, heurRR = sim_restart(y)
        if heurRR == 0:
            solvedRR += 1
        costRR += icostRR
    percentRR = calc_percent(int(sys.argv[1]), solvedRR)
    print "Random-Restart: {0}% solved, search cost: {1}" .format(percentRR, costRR)        
