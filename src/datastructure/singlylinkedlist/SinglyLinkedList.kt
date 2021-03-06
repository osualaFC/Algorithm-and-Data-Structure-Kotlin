package datastructure.singlylinkedlist

import datastructure.doublylinkedlist.DoublyLinkedList
import kotlin.IndexOutOfBoundsException

//head
//[data|next] -> [data|next] -> [data|next] -> null
class SinglyLinkedList {
    var head : ListNode? = null
    data class ListNode(val data : Int, var next : ListNode? = null)

    fun printList(){
        var current = head
        while(current != null) {
            println(current.data)
            current = current.next
        }
    }

    fun printList(head : ListNode?){
        var current = head
        while(current != null) {
            println(current.data)
            current = current.next
        }
    }

    fun getLength() : Int {
        var count = 0
        var current = head
        while(current != null) {
            count++
            current = current.next
        }
        return count
    }

    fun addHead(newNode : ListNode) {
        if(head == null) head = newNode
        val currentHead = head
        head = newNode
        newNode.next = currentHead
        printList()
    }

    fun addLast(newNode: ListNode) {
        if(head == null) head = newNode
        var current = head
        while(current?.next != null) {
            current = current.next
        }
        current?.next = newNode
        newNode.next = null
        printList()
    }

    fun addAtIndex(newNode: ListNode, position : Int) {
        when(position) {
            0 -> addHead(newNode)
            getLength() - 1 -> addLast(newNode)
            in getLength()..Int.MAX_VALUE -> throw IndexOutOfBoundsException()
            else -> {
                var current = head
                var count = 0
                while(count < position - 1) {
                    current = current?.next
                    count++
                }
                val currentNext = current?.next
                current?.next = newNode
                newNode.next = currentNext
                printList()
            }
        }
    }

    fun removeHead() {
        if(head == null) throw IndexOutOfBoundsException()
        val newHead = head?.next
        head?.next = null
        head = newHead
        printList()
    }

    fun removeLast() {
        if(head == null) throw IndexOutOfBoundsException()
        var count = 0
        var current = head
        while(count < getLength() - 2) {
            current = current?.next
            count++
        }
        current?.next = null
        printList()
    }

    fun removeAtIndex(position : Int) {
        when(position) {
            0 -> removeHead()
            getLength() - 1 -> removeLast()
            in getLength()..Int.MAX_VALUE -> throw IndexOutOfBoundsException()
            else -> {
                var current = head
                var count = 0
                while(count < position - 1) {
                    current = current?.next
                    count++
                }
                val deletedNode = current?.next
                current?.next = deletedNode?.next
                printList()
            }
        }
    }

    fun mergeTwoSortedList(a: ListNode?, b: ListNode?) : ListNode? {
        val dummy = ListNode(0)
        var tail = dummy
        var firstNode = a
        var secondNode = b
        while(firstNode != null && secondNode != null) {
            if(firstNode.data <= secondNode.data) {
                tail.next = firstNode
                firstNode = firstNode.next
            } else {
                tail.next = secondNode
                secondNode = secondNode.next
            }
            tail = tail.next!!
        }

        //in a situation where one list is longer than the other
        if(firstNode == null) {
            tail.next = secondNode
        } else {
            tail.next = firstNode
        }
        printList(dummy.next)
        return dummy.next
    }
}