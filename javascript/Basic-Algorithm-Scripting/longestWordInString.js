
/*

Return the length of the longest word in the provided sentence.

*/


// Method 0
function findLongestWordLength(str) {
    return str.split(' ').map(s=>s.length).reduce((a,b)=>{return a>b ? a:b});
}



// Method 1
function findLongestWordLength(str) {
    let wordArr = str.split(" ");
    let maxLen = 0;
    for(var i =0; i<wordArr.length; i++) {
        if(wordArr[i].length > maxLen)
            maxLen = wordArr[i].length;
    }
    return maxLen;
}


findLongestWordLength("The quick brown fox jumped over the lazy dog");