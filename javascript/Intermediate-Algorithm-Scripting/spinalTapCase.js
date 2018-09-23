
/*

Convert a string to spinal case. Spinal case is all-lowercase-words-joined-by-dashes.

*/

function spinalCase(str) {
    
    function lastChar(str) {
        return str.charAt(str.length-1);
    }

    let ret = "";
    for(let i=0; i<str.length; i++) {
        let char = str.charAt(i);
        if(char=='_' || char=='-' || char==' ')
            ret += ((lastChar(ret) != '-' && i>0) ? '-' : '');
        else if (char.toUpperCase() === char)
            ret += (((lastChar(ret) != '-' && i>0) ? '-' : '') + char.toLowerCase());
        else
            ret += char;
    }
    return ret;
}

spinalCase('This Is Spinal Tap');