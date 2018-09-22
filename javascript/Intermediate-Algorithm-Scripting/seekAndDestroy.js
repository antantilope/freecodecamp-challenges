/*

You will be provided with an initial array (the first argument in the destroyer function), followed by one or more arguments. 
Remove all elements from the initial array that are of the same value as these arguments.

Note
You have to use the arguments object.

*/


function destroyer(arr) {

    // build array of values we want to filter out
    let valuesToFind = [];
    for(let k in arguments) {
        if (k != 0)
            valuesToFind.push(arguments[k]);
    }

    return arr.filter(v => valuesToFind.indexOf(v) === -1);

}
  
destroyer([1, 2, 3, 1, 2, 3], 2, 3);