
'''

Convert a string to spinal case. Spinal case is all-lowercase-words-joined-by-dashes.

'''

def spinalCase(inp_str):
    ret = ''
    for ix, char in enumerate(inp_str.strip()):
        if char in ('_', '-', ' '):
            if ix>0 and ret[-1] != '-':
                ret += '-'
        elif char.isupper():
            if ix>0 and ret[-1] != '-':
                ret += '-'
            ret += char.lower()
        else:
            ret += char
    return ret

spinalCase('This Is Spinal Tap')