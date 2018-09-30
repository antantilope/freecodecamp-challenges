<?php

/*

Translate the provided string to pig latin.

Pig Latin takes the first consonant (or consonant cluster) of an English word, moves it to the end of the word and suffixes an "ay".

If a word begins with a vowel you just add "way" to the end.

Input strings are guaranteed to be English words in all lowercase.

*/



function translatePigLatin($str) {

  $vowels = array('a', 'e', 'i', 'o', 'u', 'y', 'A', 'E', 'I', 'O', 'U', 'Y');

  // check if string starts with vowel
  if (array_search(substr($str, 0, 1), $vowels) !== false)
    return $str . 'way';

  // Get index of the first vowel
  $ix = 0;
  while(array_search(substr($str, $ix, 1), $vowels) === false) {
    $ix++;

    // No vowles in string
    if(substr($str, $ix, 1) === false)
      return $str . 'ay';
  }

  // found vowel
  $startConconants = substr($str, 0, $ix);
  $restOfWord = substr($str, $ix, strlen($str));
  return $restOfWord . $startConconants . 'ay';
  
}
  
translatePigLatin("consonant");

?>