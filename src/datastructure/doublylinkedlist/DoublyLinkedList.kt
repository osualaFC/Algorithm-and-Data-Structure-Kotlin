package datastructure.doublylinkedlist

fun main() {
    val list = DoublyLinkedList()
    val head = DoublyLinkedList.Node(5)
    val one = DoublyLinkedList.Node(8)
    val two = DoublyLinkedList.Node(99)
    val three = DoublyLinkedList.Node(123)
    list.head = head
    head.next = one
    one.prev = head
    one.next = two
    two.prev = one
    two.next = three
    three.prev = two
    list.tail = three
val test = DoublyLinkedList.Node(7)
    val testList = DoublyLinkedList()
    list.removeAtIndex(3)
}
class DoublyLinkedList {

    data class Node(
        var data : Int,
        var prev : Node? = null,
        var next : Node? = null
    )

     var head : Node? = null
     var tail : Node? = null

     private fun printList() {
        var current = head
        while(current != null) {
            println(current.data)
            current = current.next
        }
    }

    fun removeAtIndex(index : Int) {
        if(index == 0) removeHead()
        else if(index == getLength()) removeTail()
        else {
            var current = head
            var count = 0
            while(count < index) {
                current = current?.next
                count++
            }
            val prev = current?.prev
            val next = current?.next
            prev?.next = next
            next?.prev = prev
            printList()
        }
    }

    fun removeTail() {
        if(tail != null) {
            val newTail = tail?.prev
            newTail?.next = null
            tail = newTail
            printList()
        }
    }

    fun removeHead() {
        if(head != null) {
            val newHead = head?.next
            newHead?.prev = null
            head = newHead
            printList()
        }
    }

    fun addAtIndex(node: Node, position : Int) {
        if(position == 0) addHead(node)
        else if(position == getLength()) addTail(node)
        else {
            var count = 0
            var current = head
            while(count < position - 1) {
                current = current?.next
                count++
            }
            val newNext = current?.next
            current?.next = node
            node.prev = current
            node.next = newNext
            printList()
        }
    }

    fun getLength() : Int {
        var count = 0
        var current = head
        while(current != null) {
            current = current.next
            count++
        }
        return  count
    }

    fun addTail(node: Node) {
        if(head == null) head = node
        else {
            val currentTail = tail
            currentTail?.next = node
            tail = currentTail
        }
        printList()
    }

    fun addHead(node: Node) {
        if(head == null) head = node
        else {
            val currentHead = head
            currentHead?.prev = node
            node.next = currentHead
            head = node
        }
        printList()
    }
}