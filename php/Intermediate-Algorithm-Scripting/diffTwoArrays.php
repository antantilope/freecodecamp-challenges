<?php

/*

Compare two arrays and return a new array with any items only found in one of the two given arrays, but not both. 

In other words, return the symmetric difference of the two arrays.

*/

function symmetric_diff($arr1, $arr2) {
    return array_merge(
        array_diff($arr1, $arr2),
        array_diff($arr2, $arr1)
    );
}
  
symmetric_diff([1, 2, 3, 5], [1, 2, 3, 4, 5]);

?>