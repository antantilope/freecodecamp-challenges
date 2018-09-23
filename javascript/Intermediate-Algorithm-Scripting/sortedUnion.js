/*

Write a function that takes two or more arrays and returns a new array of unique values in the order of the original provided arrays.

In other words, all values present from all arrays should be included in their original order, but with no duplicates in the final array.

The unique numbers should be sorted by their original order, but the final array should not be sorted in numerical order.

Check the assertion tests for examples.

*/


function uniteUnique(arr) {
    let ret = [];
    Object.values(arguments).forEach((a)=>{
        a.forEach((value)=>{
            if(ret.indexOf(value) == -1)
                ret.push(value);
        });
    });
    return ret;
}
  
uniteUnique([1, 3, 2], [5, 2, 1, 4], [2, 1]);


