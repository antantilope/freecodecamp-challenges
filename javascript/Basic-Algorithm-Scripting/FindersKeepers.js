/*

Create a function that looks through an array (first argument) and returns the first element in the array that passes a truth test (second argument). 
If no element passes the test, return undefined.

*/

function findElement(arr, func) {
    for(let i in arr) {
        if(func(arr[i]))
            return arr[i];
    }
}
  
findElement([1, 2, 3, 4], num => num % 2 === 0);