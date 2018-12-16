package com.fq.leetcode

/**
 * 反转链表
 * @author lvfq
 * @date 2018/12/13 下午1:01
 * @mainFunction :
 *
 */
fun main(args: Array<String>) {
    val solution = Solution()

    val headNode = generateSingleChain(6)

    val node = solution.reverseList(headNode)


    printNode(node)
}

fun printNode(node: ListNode?) {
    println(node?.`val`)
    val next = node?.next
    if (next != null) {
        printNode(next)
    }
}


class Solution {
    /**
     * success
     * 处理思路 先用递归，获取到最后一个节点，然后从最后一个节点开始反转。
     */
    fun reverseList(headNode: ListNode?): ListNode? {
        if (headNode?.next == null) return headNode
        val node = reverseList(headNode.next)   // 递归获取最后一个节点数据， 从后往前操作。
        headNode.next?.next = headNode
        headNode.next = null
        return node
    }

    /**
     * Success
     * 思路： 引用一个临时变量，存放正序的上一个节点， 然后直接从当前第一个节点开始，依次向后反转。
     */
    fun reverseList_1(headNode: ListNode?): ListNode? {
        var prev: ListNode? = null
        var curNode = headNode
        while (curNode != null) {
            val temp = curNode.next
            curNode.next = prev
            prev = curNode
            curNode = temp

        }
        return prev
    }

}
