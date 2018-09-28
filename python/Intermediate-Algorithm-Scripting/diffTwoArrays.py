'''

Compare two arrays and return a new array with any items only found in one of the two given arrays, but not both. 

In other words, return the symmetric difference of the two arrays.

'''

# Order doesnt matter
def diffArray(arr1, arr2):
    return list(set(arr1).symmetric_difference(arr2))


# Order  matters
def diffArray(arr1, arr2):
    return [v for v in arr1 if v not in arr2] + [v for v in arr2 if v not in arr1]
    
  
diffArray([1, 2, 3, 5], [1, 2, 3, 4, 5])