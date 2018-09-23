
/*

Find the missing letter in the passed letter range and return it.

If all letters are present in the range, return undefined.

*/


const alphabet = 'abcdefghijklmnopqrstuvwxyz';


function fearNotLetter(str) {
    for(let i=0; i<str.length; i++) {
    
        if(i==(str.length-1))
            return
    
        if(alphabet.indexOf(str.charAt(i)) - alphabet.indexOf(str.charAt(i+1)) != -1)
            return  alphabet.charAt(alphabet.indexOf(str.charAt(i)) + 1);
        
    }
}
  
fearNotLetter("abce");