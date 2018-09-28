'''

We'll pass you an array of two numbers. Return the sum of those two numbers plus the sum of all the numbers between them.

The lowest number will not always come first.

'''

def sumAll(arr):
    return sum(range(min(arr), max(arr)+1))




sumAll([1, 4])