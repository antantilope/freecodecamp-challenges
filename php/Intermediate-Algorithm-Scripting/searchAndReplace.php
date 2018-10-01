<?php

/*

Perform a search and replace on the sentence using the arguments provided and return the new sentence.

First argument is the sentence to perform the search and replace on.

Second argument is the word that you will be replacing (before).

Third argument is what you will be replacing the second argument with (after).

*/

function myReplace($str, $before, $after) {
    $modAfter = $after;
    if(ctype_upper(substr($before, 0, 1)))
        $modAfter = strtoupper(substr($after, 0, 1)) . substr($after, 1, strlen($after));
    
    # case insensitive replace 
    return str_ireplace($before, $modAfter, $str);
}

  
myReplace("A quick brown fox jumped over the lazy dog", "jumped", "leaped");


?>