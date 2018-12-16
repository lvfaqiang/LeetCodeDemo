package com.fq.leetcode

/**
 * ChainList
 * @author lvfq
 * @date 2018/12/16 下午3:14
 * @mainFunction :
 *  用于生成链表
 */

/**
 * 生成一个单链表
 * @param size 链表长度
 */
fun generateSingleChain(size: Int = 5): ListNode? {
    var index = size
    var node: ListNode? = null
    var nextNode: ListNode? = null
    while (index > 0) {
        node = ListNode(index)
        node.next = nextNode
        nextNode = node
        index--
    }
    return node
}


/**
 * 生成一个有环链表
 * @param size 链表长度
 * @param startIndex 环的位置
 */
fun generateLoopChain(size: Int, startIndex: Int): ListNode? {
    var headNode: ListNode? = null
    var nextNode: ListNode? = null

    var lastNode: ListNode? = null

    var index = size

    while (index > 0) {
        headNode = ListNode(index)
        headNode.next = nextNode
        nextNode = headNode

        if (lastNode == null) {
            lastNode = headNode
        }
        if (index == startIndex) {
            lastNode.next = headNode
        }
        index--
    }

    return headNode
}