


'''

Remove all falsy values from an array.

Falsy values in JavaScript are false, null, 0, "", undefined, and NaN.

'''


def bouncer(arr):
    return list(filter(lambda v: v, arr))

  
bouncer([7, "ate", "", False, 9])