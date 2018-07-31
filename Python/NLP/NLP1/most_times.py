from collections import Counter
# Start with an empty list. You can 'seed' the list with
#  some predefined values if you like.
numbers = []

# Set new_n to something
new_n = input("Please tell me how many numbers you would like to use: ")
current_number = 0


while current_number < new_n:
    new_num = raw_input("Please tell me your next number: ")
    numbers.append(new_num)
    current_number = current_number + 1
    
    if current_number == new_n:
        print("Your most common number is: ")
        print(Counter(numbers).most_common(1))
	

