<?php

/*

Find the missing letter in the passed letter range and return it.

If all letters are present in the range, return undefined.

*/



function fearNotLetter($str){
    $alphabet = 'abcdefghijklmnopqrstuvwxyz';
    $alphabetArr = str_split($alphabet);
    $slen = strlen($str);
    foreach(str_split($str) as $ix=>$char) {
        if($ix==($slen-1))
            return;
        
        $thisCharIX = array_search($char, $alphabetArr);
        $expectedNextChar = substr($alphabet, $thisCharIX+1, 1);
        $actualNextChar = substr($str, $ix+1, 1);
        if($expectedNextChar != $actualNextChar)
            return $expectedNextChar;
    }
}
  
fearNotLetter("abce");


?>