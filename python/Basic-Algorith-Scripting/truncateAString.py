'''

Truncate a string (first argument) if it is longer than the given maximum string length (second argument). 
Return the truncated string with a ... ending.

'''


def truncateString(string, num):
    return string if len(string) <= num else (string[0:num] + '...')

  
truncateString("A-tisket a-tasket A green and yellow basket", 8)