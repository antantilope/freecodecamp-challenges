/*

Sum all the prime numbers up to and including the provided number.

A prime number is defined as a number greater than one and having only two divisors, one and itself. For example, 2 is a prime number because it's only divisible by one and two.

The provided number may not be a prime.

*/

// TODO: This is a brute force solution. It is too slow for large inputs :(

function isPrime(num) {

    if (num > 3 && num % 2 == 0) // Shortcut for even numbers
        return false;

    for(var i = 2; i < num; i++){
        if(num % i === 0) 
            return false;
    }
    return num !== 1 && num !== 0;
}
  
function sumPrimes(num) {
    let summer = 0;
    for(let i=0; i<=num; i++) {
        if(isPrime(i)) {
            summer += i;
        }
    }
    return summer;
}
  
sumPrimes(10);
