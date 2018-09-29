<?php

/*

Remove all falsy values from an array.

Falsy values in JavaScript are false, null, 0, "", undefined, and NaN.

*/


function bouncer($arr) {
    return array_filter($arr, 'boolval');
}
  
bouncer(array(7, "ate", "", false, 9));

?>