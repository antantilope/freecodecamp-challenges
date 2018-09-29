
<?php

/*

Create a function that looks through an array (first argument) and returns the first element in the array that passes a truth test (second argument). 
If no element passes the test, return undefined.

*/

function findElement($arr, $func) {
    foreach($arr as $v) {
        if ($func($v)) {
            return $v;
        }
    }
}


function filterFunc($v) {
    return $v % 2 == 0;
}

findElement(array(1, 2, 3, 4), 'filterFunc');

?>