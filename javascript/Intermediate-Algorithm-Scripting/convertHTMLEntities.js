/*

Convert the characters &, <, >, " (double quote), and ' (apostrophe), in a string to their corresponding HTML entities.

*/

function convertHTML(str) {
    const replace = {
      '>': '&​gt;',
      '<': '&​lt;',
      "'":  '&​apos;',
      '"': '&​quot;',
      '&': '&​amp;',
    };
    const keys = Object.keys(replace);
  
    return str.split('').map(char=>{
        return keys.indexOf(char) != -1 ? replace[char] : char;
    })
    .join("");

}
  
convertHTML("Dolce & Gabbana");