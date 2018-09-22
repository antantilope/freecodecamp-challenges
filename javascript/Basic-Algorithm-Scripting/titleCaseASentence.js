
/*

Return the provided string with the first letter of each word capitalized. Make sure the rest of the word is in lower case.

For the purpose of this exercise, you should also capitalize connecting words like "the" and "of".

*/

function titleCase(str) {
    return str.split(' ').map(s=>{
        return s.charAt(0).toUpperCase() + (s.length>1 ? s.substring(1,s.length).toLowerCase() : "")
    })
    .join(" ");
}
  
titleCase("I'm a little tea pot");