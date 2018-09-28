'''

Convert the characters &, <, >, " (double quote), and ' (apostrophe), in a string to their corresponding HTML entities.

'''

def convertHTML(string):
    replace = {
      '>': '&gt;',
      '<': '&lt;',
      "'":  '&apos;',
      '"': '&quot;',
      '&': '&amp;',
    }
    return ''.join(replace.get(c, c) for c in string)
  



  
convertHTML("Dolce & Gabbana")