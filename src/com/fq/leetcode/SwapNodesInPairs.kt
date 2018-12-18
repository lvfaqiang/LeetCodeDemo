package com.fq.leetcode

/**
 * SwapNodesInPairs
 * @author lvfq
 * @date 2018/12/18 上午8:43
 * @mainFunction :
 *  两两交换链表中的节点
 *  eg : 1->2->3->4,
 *  result ：2->1->4->3
 */
fun main(args: Array<String>) {
    val node = generateSingleChain(5)
    val swap = SwapSolution()
    val result = swap.swapPairs(node)
    printNode(result)

}

class SwapSolution {

    /**
     * 传入的只是 头指针，
     * 循环的时候需要记录三个指针，
     * 首先是相邻的两个元素。因为要让它们进行交换，所以这是必须的。
     * 然后要记录两个相邻元素的前一个元素。用来协助后面两个节点进行反转，
     */

    fun swapPairs(head: ListNode?): ListNode? {
        // 1, 先定义一个虚拟节点，用于交换开头的两个指针
        var node: ListNode? = ListNode(-1).apply {
            next = head
        }
        var preNode = node

        while (preNode?.next != null && preNode.next?.next != null) {
            val first = preNode.next    // 获取到第一个节点 1
            val second = first?.next         // 获取到第二个节点 2

            first?.next = second?.next // 因为要交换 second 和 first 节点位置，所以，要先把 second 的 next 节点调整到 first.next .
            second?.next = first    // 然后，再把 second.next 指向 first.
            preNode.next = second   // 最后，把两个相邻节点的前一个节点 next 指向 second . 这样就完成了一次 两个节点互换。
            preNode = first     // 重新调整 preNode 节点，继续下一次轮询节点互换。
        }
        return node?.next
    }

}