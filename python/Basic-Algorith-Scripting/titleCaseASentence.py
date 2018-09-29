
'''

Return the provided string with the first letter of each word capitalized. Make sure the rest of the word is in lower case.

For the purpose of this exercise, you should also capitalize connecting words like "the" and "of".

'''



def titleCase(input_string):
    return input_string.title() # :D


def titleCase(input_string):
    return ' '.join(s[0].upper()+s[1:].lower() for s in input_string.split(' '))
  
titleCase("I'm a little tea pot")