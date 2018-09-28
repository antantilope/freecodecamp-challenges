'''

Return an array consisting of the largest number from each provided sub-array. 

For simplicity, the provided array will contain exactly 4 sub-arrays.

Remember, you can iterate through an array with a simple for loop, and access each member with array syntax arr[i].

'''



# Pythonic
def largestOfFour(arr):
    return [max(sub_array) for sub_array in arr]



# Still good
def largestOfFour(arr):
    return list(map(max, arr))


largestOfFour([[4, 5, 1, 3], [13, 27, 18, 26], [32, 35, 37, 39], [1000, 1001, 857, 1]])