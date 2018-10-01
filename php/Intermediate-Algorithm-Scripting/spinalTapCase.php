<?php

/*

Convert a string to spinal case. Spinal case is all-lowercase-words-joined-by-dashes.

*/


function spinalCase($str) {

    function lastChar($s) {
        return substr($s, strlen($s)-1, 1);
    }

    $ret = '';
    
    foreach(str_split($str) as $ix=>$char) {
        if(($char=='_' || $char=='-' || $char==' ') && lastChar($ret) !== '-' && $ix > 0)
            $ret = $ret . '-';
        else if (ctype_upper($char) && lastChar($ret) !== '-' && $ix > 0)
            $ret = $ret . '-' . strtolower($char);
        else
            $ret = $ret . strtolower($char);
    }

    return $ret;
}


spinalCase('This Is Spinal Tap');

?>