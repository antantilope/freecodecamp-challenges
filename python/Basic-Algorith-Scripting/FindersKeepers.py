'''

Create a function that looks through an array (first argument) and returns the first element in the array that passes a truth test (second argument). 
If no element passes the test, return undefined.
'''



def findElement(arr, func):
    for v in arr:
        if func(v):
            return v

  
findElement([1, 2, 3, 4], lambda num: num % 2 == 0)