/*

Reverse the provided string.

You may need to turn the string into an array before you can reverse it.

Your result must be a string.

*/


func reverseString(_ s:String) -> String {
    return String(s.reversed())
}


// Following the rules
func reverseString(_ s:String) -> String {
    var charArr: [String] = []
    let startIx = s.startIndex
    var ix = s.count-1
    while ix > -1{
        charArr.append(String(s[s.index(startIx, offsetBy: ix)]))
        ix-=1
    }
    return charArr.joined(separator:"")
    
}

print(reverseString("Hello World!"))
