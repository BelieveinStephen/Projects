def avg(l):
    avg = sum(l)/ len(l)
    print avg

def l_sqr(l):
    squares = []
    for number in l:
        new_square = number**2
        squares.append(new_square)
    for square in squares:
        print square


def var(l):
    m = sum(l) / len(l)

    # calculate variance using a list comprehension
    var_res = sum([(xi - m) ** 2 for xi in l]) / len(l)
    print var_res
