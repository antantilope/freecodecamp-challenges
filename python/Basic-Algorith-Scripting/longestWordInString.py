
'''

Return the length of the longest word in the provided sentence.

'''



def findLongestWordLength(string):
    return max(len(word) for word in string.split(' '))

# OR

def findLongestWordLength(string):
    return max(map(len, string.split(' ')))


findLongestWordLength("The quick brown fox jumped over the lazy dog")
