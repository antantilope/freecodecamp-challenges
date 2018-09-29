'''

Translate the provided string to pig latin.

Pig Latin takes the first consonant (or consonant cluster) of an English word, moves it to the end of the word and suffixes an "ay".

If a word begins with a vowel you just add "way" to the end.

Input strings are guaranteed to be English words in all lowercase.

'''

def translatePigLatin(input_str):
  
  vowels = 'aeiouyAEIOUY'
  
  if input_str[0] in vowels:
    return input_str + 'way'
  
  ix = 0
  try:
    while input_str[ix] not in vowels:
      ix += 1
  except IndexError:
    return input_str + 'ay'
  
  start_conconants = input_str[:ix]
  rest_of_word = input_str[ix:]
  return rest_of_word + start_conconants + 'ay'
    


  
translatePigLatin("consonant")