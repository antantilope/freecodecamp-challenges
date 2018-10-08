'''
Check if a string (first argument, str) ends with the given target string (second argument, target).

This challenge can be solved with the .endsWith() method, which was introduced in ES2015. 
But for the purpose of this challenge, we would like you to use one of the JavaScript substring methods instead.

'''


# Method 0- best way
def confirm_ending(string, target):
    return string.endswith(target)



# Method 1- following the above rules
def confirm_ending(string, target):
    return target == string[len(target) * -1:]


  
confirmEnding("Bastian", "ian")
