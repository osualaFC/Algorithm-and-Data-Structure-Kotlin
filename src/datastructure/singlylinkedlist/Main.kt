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

    val list1 = SinglyLinkedList()
    list1.head = SinglyLinkedList.ListNode(3)
    val second1 = SinglyLinkedList.ListNode(7)
    val third1 = SinglyLinkedList.ListNode(11)
    val fourth1 = SinglyLinkedList.ListNode(21)
    list1.head?.next = second1
    second1.next = third1
    third1.next = fourth1

    val list2 = SinglyLinkedList()
    list2.head = SinglyLinkedList.ListNode(1)
    val second2 = SinglyLinkedList.ListNode(5)
    val third2 = SinglyLinkedList.ListNode(33)
    list2.head?.next = second2
    second2.next = third2

    list.mergeTwoSortedList(list1.head, list2.head)
}