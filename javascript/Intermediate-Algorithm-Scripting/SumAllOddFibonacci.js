/*

Given a positive integer num, return the sum of all odd Fibonacci numbers that are less than or equal to num.

The first two numbers in the Fibonacci sequence are 1 and 1. Every additional number in the sequence is the sum of the two previous numbers. The first six numbers of the Fibonacci sequence are 1, 1, 2, 3, 5 and 8.

For example, sumFibs(10) should return 10 because all odd Fibonacci numbers less than or equal to 10 are 1, 1, 3, and 5.

*/


function getFibonacciValAtIX(num) {
    if (num <= 1) 
        return 1;
    return getFibonacciValAtIX(num - 1) + getFibonacciValAtIX(num - 2);
}
  
function sumFibs(num) {
  
    let summer=0;
    let ix=0;
    let fibVal;
  
    while(true) {
        fibVal = getFibonacciValAtIX(ix);
        if (fibVal > num)
            break;
        if (fibVal % 2 == 1)
            summer += fibVal;
        ix += 1;
    }
  
    return summer;
}
  
sumFibs(4);