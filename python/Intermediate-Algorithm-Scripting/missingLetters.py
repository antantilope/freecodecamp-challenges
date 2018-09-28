
'''

Find the missing letter in the passed letter range and return it.

If all letters are present in the range, return undefined/None.

'''

from string import ascii_lowercase




def fearNotLetter(input_str):
    last_char_ix = len(input_str) - 1

    for ix, char in enumerate(input_str):
        if ix == last_char_ix:
            return None

        expected_next_ord = ord(char)+1
        actual_next_ord = ord(input_str[ix+1])

        if(expected_next_ord != actual_next_ord):
            return chr(expected_next_ord) # return the missing letter

  
fearNotLetter("abce")