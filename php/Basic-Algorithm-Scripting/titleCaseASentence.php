<?php
/*

Return the provided string with the first letter of each word capitalized. Make sure the rest of the word is in lower case.

For the purpose of this exercise, you should also capitalize connecting words like "the" and "of".

*/


// using built in function
function titleCase($str) {
    return ucwords($str); 
}

// not using ucwords
function titleCase($str) {
    // string to array
    $words = explode(' ', $str);
    for($i=0; $i<count($words); $i++) {
        $words[$i] = strtoupper(substr($words[$i], 0, 1)) . strtolower(substr($words[$i], 1, strlen($words[$i])));
    }
    return implode(' ', $words); // array back to string
}

  
titleCase("I'm a little tea pot");

?>
