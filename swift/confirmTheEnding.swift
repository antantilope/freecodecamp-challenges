/*
 Check if a string (first argument, str) ends with the given target string (second argument, target).
 This challenge can be solved with the .endsWith() method, which was introduced in ES2015.
 But for the purpose of this challenge, we would like you to use one of the JavaScript substring methods instead.
 */

func confirmEnding(_ inpString:String, _ ending:String) -> Bool {
    return String(inpString.suffix(ending.count)) == ending
}



print(confirmEnding("hello world", "ld"))
