def gen_array():
    drinkNo = 13
    arr = [0 for i in range(drinkNo)]
    arr[drinkNo-1] = 1
    return arr

def start(arr):
    size = len(arr)
    arr1 = arr
    for i in range(size):
        ans = check(i, arr1)
        if ans:
            print i
            break
    return False



def check(i, arr1):
    moves = 14
    distribution = len(arr1)
    for k in range(distribution, -1, -1):
        rem = moves%k
        if rem != 0:
            rem -= 1
        if arr1[rem] == 1:
            break
        if arr1[rem] == 0:
            arr1[rem] = -1
            del arr1[rem]
    return True



if __name__== "__main__":
    arr = gen_array()
    start(arr)

    """issues:
    1. array becomes single element, changed from original array
    2. last element in array is never changed therefore making it always return true"""