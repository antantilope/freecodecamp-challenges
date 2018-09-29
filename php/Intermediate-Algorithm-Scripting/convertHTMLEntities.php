<?php

/*

Convert the characters &, <, >, " (double quote), and ' (apostrophe), in a string to their corresponding HTML entities.

*/

function convertHTML($str) {
    $replace = array(
      '>'=> '&​gt;',
      '<'=> '&​lt;',
      "'"=>  '&​apos;',
      '"'=> '&​quot;',
      '&'=> '&​amp;',
    );
    $chars = str_split($str);

    for($i=0; $i<count($chars); $i++){
        if(array_key_exists($chars[$i], $replace))
            $chars[$i] = $replace[$chars[$i]];
    }

    return implode('', $chars);
}

/*

Note: PHP has a built in function called htmlspecialchars which can perform this task.

*/
  


?>