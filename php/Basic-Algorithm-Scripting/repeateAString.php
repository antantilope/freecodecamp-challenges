<?php

/*

Repeat a given string str (first argument) for num times (second argument). 

Return an empty string if num is not a positive number.

The built-in repeat()-method should not be used

*/


function repeatStringNumTimes($str, $num) {
    return str_repeat($str, $num); // :D
}




// Following the rules
function repeatStringNumTimes($str, $num) {
    $ret = "";
    for($i=0; $i<$num; $i++)
        $ret .= $str;
    
    return $ret;
}



repeatStringNumTimes("abc", 3);

?>