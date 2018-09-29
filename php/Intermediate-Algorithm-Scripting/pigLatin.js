/*

Translate the provided string to pig latin.

Pig Latin takes the first consonant (or consonant cluster) of an English word, moves it to the end of the word and suffixes an "ay".

If a word begins with a vowel you just add "way" to the end.

Input strings are guaranteed to be English words in all lowercase.

*/



function translatePigLatin(str) {

    const vowels = ['a', 'e', 'i', 'o', 'u', 'y', 'A', 'E', 'I', 'O', 'U', 'Y'];
  
    if (vowels.indexOf(str.charAt(0)) > -1)
      return str + 'way';
    
    // Get index of the first vowel
    let ix = 0;
    while(vowels.indexOf(str.charAt(ix)) == -1) {
      ix++;
      if(ix > str.length)
        return str + 'ay';
    }
    
    const startConconants = str.slice(0, ix);
    const restOfWord = str.slice(ix, str.length);
    return restOfWord + startConconants + 'ay';
  
  }
  
  translatePigLatin("consonant");