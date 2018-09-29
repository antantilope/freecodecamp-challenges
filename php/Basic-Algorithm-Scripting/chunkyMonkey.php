<?php

/*

Write a function that splits an array (first argument) into groups the length of size (second argument) and returns them as a two-dimensional array.

*/


function chunkArrayInGroups($arr, $size) {
    $ret = array();
    for($i=0; $i<count($arr); $i += $size) {
        $ret[] = array_slice($arr,$i, $i+$size);
    }
    return $ret;
}
  
chunkArrayInGroups(["a", "b", "c", "d"], 2);

?>