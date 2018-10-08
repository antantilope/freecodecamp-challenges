/*

Return the length of the longest word in the provided sentence.

*/

func findLongestWordLength(_ s:String) -> Int {
    var max = 0
    for x in s.split(separator:" ") {
        if x.count > max  {
            max = x.count
        }
    }
    return max
}



print(findLongestWordLength("stricoff hello my name is jonathan"))
