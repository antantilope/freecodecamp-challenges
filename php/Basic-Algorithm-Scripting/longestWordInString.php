<?php
/*

Return the length of the longest word in the provided sentence.

*/



function findLongestWordLength($str) {
    return max(array_map('strlen', explode(' ', $str)));
}


findLongestWordLength("The quick brown fox jumped over the lazy dog");


?>