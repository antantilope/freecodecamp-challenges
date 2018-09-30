'''

Write a function that takes two or more arrays and returns a new array of unique values in the order of the original provided arrays.

In other words, all values present from all arrays should be included in their original order, but with no duplicates in the final array.

The unique numbers should be sorted by their original order, but the final array should not be sorted in numerical order.

Check the assertion tests for examples.

'''

import itertools 



# Better solution that uses python standard library
def uniteUnique(*args):

    # tuple preserves order of args
    vals_ordered = tuple(itertools.chain(*args))
    
    # Drop duplicates, cast to list, sort values by first occurance in tuple
    return sorted(set(vals_ordered), key=lambda v: vals_ordered.index(v))



# Without standard library
def uniteUnique(*args):
    ret = []
    for arr in args:
        for v in arr:
            if not (v in ret):
                ret.append(v)
    return ret

  
uniteUnique([1, 3, 2], [5, 2, 1, 4], [2, 1])


