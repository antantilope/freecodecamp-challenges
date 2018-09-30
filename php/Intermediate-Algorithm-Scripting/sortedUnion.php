<?php

/*

Write a function that takes two or more arrays and returns a new array of unique values in the order of the original provided arrays.

In other words, all values present from all arrays should be included in their original order, but with no duplicates in the final array.

The unique numbers should be sorted by their original order, but the final array should not be sorted in numerical order.

Check the assertion tests for examples.

*/




/*
    Note, arrays are nested inside an array and passed to uniteUnique as a single argument
*/

function uniteUnique($arr) {
    $merged = call_user_func_array('array_merge', $arr);
    return array_unique($merged);
}
  
uniteUnique(array(
        array(1, 3, 2), 
        array(5, 2, 1, 4), 
        array(2, 1)
    ));

?>