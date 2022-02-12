package datastructure.singlylinkedlist

fun main() {
    val list = SinglyLinkedList()
    list.head = SinglyLinkedList.ListNode(2)
    val secondNode = SinglyLinkedList.ListNode(11)
    val thirdNode = SinglyLinkedList.ListNode(8)
    val fourthNode = SinglyLinkedList.ListNode(5)

    //connect the nodes
    list.head?.next = secondNode
    secondNode.next = thirdNode
    thirdNode.next = fourthNode

     val testNode = SinglyLinkedList.ListNode(7)
    list.removeAtIndex(2)
}