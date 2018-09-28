'''

Write a function that splits an array (first argument) into groups the length of size (second argument) and returns them as a two-dimensional array.

'''


def chunkArrayInGroups(arr, size):
    return [arr[i:i+size] for i in range(0, len(arr), size)]

  
chunkArrayInGroups(["a", "b", "c", "d"], 2)