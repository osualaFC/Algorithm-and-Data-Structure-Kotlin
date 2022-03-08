package datastructure.string

/**A subsequence is a new string formed from the origin string by deleting one or more char without changing the order
 * eg "ace" is a subsequence of "abcde"
 *      "aec" is not a subsequence of "abcde"
 *      "cac" -> "acccaccc"
**/
fun isSubsequence(str: String, seq: String): Boolean {
    var i = 0
    var j = 0
    while(i < str.length && j < seq.length) {
        if(str[i] == seq[j]) {
            j++
        } else {
            i++
        }
    }
    return j == seq.length
}

fun main() {
    println(isSubsequence( "cccaccc", "cac"))
}