<?php

/*

We'll pass you an array of two numbers. Return the sum of those two numbers plus the sum of all the numbers between them.

The lowest number will not always come first.

*/

function sumAll($arr) {
    $mn = min($arr);
    $mx = max($arr);
    $summer = 0;
    for($i=$mn; $i<=$mx; $i++)
        $summer += $i;
    return $summer;
}

sumAll([1, 4]);

?>