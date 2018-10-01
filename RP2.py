import re
def get_directions(data):
    directions = []
    for routes in data:
        routes = ''.join(routes)
        routes = routes.split('; ')
        routes = ''.join(routes[2])
        routes = routes.split(', ')
        directions.append(routes)
    return directions

def get_heading(instruction, heading):
    if '0' in instruction:
        heading = turn_around(heading)
    elif 'L' in instruction:
        heading = turn_left(heading)
    else:
        heading = turn_right(heading)
    return heading

def turn_left(heading):
    if heading == 'W':
        heading = 'S'
    elif heading == 'S':
        heading = 'E'
    elif heading == 'N':
        heading = 'W'
    else:
        heading = 'N'
    return heading

def turn_right(heading):
    if heading == 'W':
        heading = 'N'
    elif heading == 'S':
        heading = 'W'
    elif heading == 'N':
        heading = 'E'
    else:
        heading = 'S'
    return heading

def get_move(instruction):
    instruction = ''.join(instruction)
    count = re.findall(r'\d', instruction)
    count = ''.join(count)
    count = int(count)
    return count

def move(heading, count, w_count, e_count, n_count, s_count):
    if heading == 'W':
        w_count += count
    elif heading =='E':
        e_count += count
    elif heading =='N':
        n_count += count
    else:
        s_count += count
    return w_count, e_count, n_count, s_count

def optimizer(w_count, e_count, n_count, s_count, ans):
    x = w_count - e_count
    y =  n_count - s_count
    ans.append(set_instructions(x, y))
    return ans

def set_instructions(x, y):
    if y < 0:
        y = abs(y)
        y = str(y)
        y = "L" + y
    elif y > 0:
        y = str(y)
        y = "R" + y
    if x < 0:
        x = abs(x)
        x = str(x)
        ans = y + ', ' + 'L' + x
    elif x > 0:
        x = str(x)
        ans = y + ', ' + 'R' + x
    elif x == 0:
        x = 'R0'
        ans  = x + ', ' + y
        """CANT TURN LEFT"""
    return ans



def main():
    data = [["2017-01-01; Coffee Shop; L2, L5, L5, R5, L2"],["2017-01-02; Advertising Agency; R3, R3, R3, L2"]]
    heading = 'W'
    directions = get_directions(data)
    ans = []
    for instructions in directions:
        w_count, e_count, n_count, s_count = 0, 0, 0, 0
        for instruction in instructions:
            heading = get_heading(instruction, heading)
            count = get_move(instruction)
            w_count, e_count, n_count, s_count = move(heading, count, w_count, e_count, n_count, s_count)
        optimize = optimizer(w_count, e_count, n_count, s_count, ans)
    routes = []
    for route in data:
        route = ''.join(route)
        route = route.split('; ')
        routes.append(route)
    for i in range(len(optimize)):
        routes[i][2] = optimize[i]
        for k in range(len(routes[i])):
            str1 = '; '.join(routes[i])
        print (str1)

main()




