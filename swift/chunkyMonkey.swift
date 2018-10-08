/*

Write a function that splits an array (first argument) into groups the length of size (second argument) and returns them as a two-dimensional array.

*/

func chunkArrayInGroups(_ arr:[String], _ chunckSize:Int) -> [[String]] {
    var ret: [[String]] = []
    var ix = 0
    var maxIx = 0
    while ix < arr.count {
        maxIx = ix+chunckSize < arr.count ? ix+chunckSize : arr.count
        ret.append( Array(arr[ix..<maxIx]) )
        ix += chunckSize
    }
    return ret
}



print(chunkArrayInGroups(["ab", "cd", "ef", "gh", "ij", "kl", "derp"], 2))
