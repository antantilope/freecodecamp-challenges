

/*

Create a function that sums two arguments together. If only one argument is provided, then return a function that expects one argument and returns the sum.

For example, addTogether(2, 3) should return 5, and addTogether(2) should return a function.

Calling this returned function with a single argument will then return the sum:

var sumTwoAnd = addTogether(2);

sumTwoAnd(3) returns 5.

If either argument isn't a valid number, return undefined.

*/

function addTogether() {

    let vals = Object.values(arguments)

    if(vals.length == 2 && typeof vals[0]=='number' &&  typeof vals[1]=='number')
        return vals[0] + vals[1];
    
    else if (vals.length == 1 && typeof vals[0]=='number')
        return (x)=>{return addTogether(vals[0], x)};
    
}
  
addTogether(2,3);