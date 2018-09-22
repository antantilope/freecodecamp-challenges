/*

Compare two arrays and return a new array with any items only found in one of the two given arrays, but not both. 

In other words, return the symmetric difference of the two arrays.

*/

function diffArray(arr1, arr2) {

    return Array.prototype.concat(
        arr1.filter(v => arr2.indexOf(v) === -1),
        arr2.filter(v => arr1.indexOf(v) === -1)
    )
    
}
  
diffArray([1, 2, 3, 5], [1, 2, 3, 4, 5]);