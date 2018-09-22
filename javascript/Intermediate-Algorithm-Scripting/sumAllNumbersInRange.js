/*

We'll pass you an array of two numbers. Return the sum of those two numbers plus the sum of all the numbers between them.

The lowest number will not always come first.

*/

function sumAll(arr) {
    let ret = 0;
    for(let i = Math.min(arr[0], arr[1]); i<=Math.max(arr[0], arr[1]); i++)
        ret += i;
    return ret;
}

sumAll([1, 4]);