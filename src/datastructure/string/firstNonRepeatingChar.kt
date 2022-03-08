package datastructure.string
/**return index of first non repeating char or -1**/
fun firstNonRepeatingChar(str : String) : Int {
    val map = mutableMapOf<Char, Int>()
    for(i in str) {
     map[i] = map.getOrDefault(i, 0) + 1
    }
  for (i in str.indices) {
      if(map[str[i]] == 1) {
          return i
      }
  }
    return -1
}
fun main() {
    println(firstNonRepeatingChar("bbaddn"))
}