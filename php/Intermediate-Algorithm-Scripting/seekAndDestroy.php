<?php
/*

You will be provided with an initial array (the first argument in the destroyer function), followed by one or more arguments. 
Remove all elements from the initial array that are of the same value as these arguments.

*/



/*
    Note: values to remove are passed as a second array, NOT as an arbitrary number of arguments
*/


function destroyer($arr, $valsToRemove) {

    $ret = array();
    foreach($arr as $v) {
        if(array_search($v, $valsToRemove) === false)
            $ret[] = $v;
    }
    return $ret;
}
  
destroyer([1, 2, 3, 1, 2, 3], [2, 3]);


?>