package datastructure.string


fun checkPalindrome(str: String): Boolean {
    //brute force using stack data structure
   /** val stack = ArrayDeque<Char>()
    for(i in str) {
        stack.addFirst(i)
    }
    var inverse = ""
    for(i in stack) {
        inverse+=i
    }
    return inverse == str **/

    var left = 0
    var right = str.length - 1
    while(left < right) {
        if(str[left] == str[right]) {
            left++
            right--
        }
        else {
           return false
        }
    }
     return true
}


fun main() {
    //madam, racecar, reviver, kayak, refer,  tattarrattat
    println(checkPalindrome("madame"))
}