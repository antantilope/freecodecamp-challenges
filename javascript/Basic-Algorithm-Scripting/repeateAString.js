/*

Repeat a given string str (first argument) for num times (second argument). 

Return an empty string if num is not a positive number.

The built-in repeat()-method should not be used

*/

function repeatStringNumTimes(str, num) {
    if (num <= 0)
        return "";
    
    let ret = "";
    let ix = num;
    while (ix>0) {
        ret += str;
        ix--;
    }

    return ret;
}
  
repeatStringNumTimes("abc", 3);