'''

Given the array arr, iterate through and remove each element starting from the first element (the 0 index) until the function func returns true when the iterated element is passed through it.

Then return the rest of the array once the condition is satisfied, otherwise, arr should be returned as an empty array.

'''


def dropElements(arr, func) :
    for ix, val in enumerate(arr):
        if func(val):
            return arr[ix:]
    return []


dropElements([1, 2, 'cat', 3, 6,7], lambda n: n =='cat')