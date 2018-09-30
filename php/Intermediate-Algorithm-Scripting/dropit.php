<?php

/*

Given the array arr, iterate through and remove each element starting from the first element (the 0 index) until the function func returns true when the iterated element is passed through it.

Then return the rest of the array once the condition is satisfied, otherwise, arr should be returned as an empty array.

*/


function dropElements($arr, $func) {
    foreach($arr as $k=>$v) {
        if($func($v)) {
            return array_slice($arr, $k, count($arr));
        }
    }
}


$func = function($n) {
    return n < 3;
};

dropElements([1, 2, 3], $func);

?>