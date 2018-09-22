
/*

Return an array consisting of the largest number from each provided sub-array. 

For simplicity, the provided array will contain exactly 4 sub-arrays.

Remember, you can iterate through an array with a simple for loop, and access each member with array syntax arr[i].

*/



// Method 0
function largestOfFour(arr) {
    return arr.map(subArr=>{return subArr.reduce((a,b)=>{return a>b ? a:b;})})
}


// Method 1
function largestOfFour(arr) {
    let ret = [];
    // Loop over outer array
    for (var i=0; i<arr.length; i++) {
        // Add max value from inner array to result
        ret.push(arr[i].reduce((a,b)=>a>b ? a:b))
    }
    return ret;
}
  

largestOfFour([[4, 5, 1, 3], [13, 27, 18, 26], [32, 35, 37, 39], [1000, 1001, 857, 1]]);