package com.fq.leetcode

/**
 * 判环链表
 * @author lvfq
 * @date 2018/12/16 上午10:37
 * @mainFunction :
 *  给定一个链表，判断链表中是否有环。
 */

fun main(args: Array<String>) {
//    val loopChain = generateLoopChain(6, 3)
    val loopChain = generateSingleChain(8)

    val lcs = LoopChainSolutioin()
    val result = lcs.plan3(loopChain)
    println("result : ${result}")

}


class LoopChainSolutioin {
    /**
     * 实现思路  在 3000 ms 内，如果 node.next 仍不为null ， 则认为当前链表有环。
     */
    fun plan1(node: ListNode?): Boolean {
        val startTime = System.currentTimeMillis()
        var curTime = startTime

        var curNode: ListNode? = node

        var hasLoop = false
        while (node?.next != null) {
            curTime = System.currentTimeMillis()
            if (curTime - startTime > 3000) {
                hasLoop = true
                break
            }
            curNode = curNode?.next
        }
        return hasLoop
    }

    /**
     * 实现思路， 用一个 Set 集合存放 ListNode，如果有重复节点，就说明有环。
     * 时间复杂度 O(n+1) = O(n)
     */
    fun plan2(node: ListNode?): Boolean {
        val sets = HashSet<ListNode>()
        var curNode = node
        var hasLoop = false
        while (curNode != null) {
            if (sets.contains(curNode)) {
                hasLoop = true
                break
            }
            sets.add(curNode)
            curNode = curNode.next
        }
        return hasLoop
    }

    /**
     * 解题思路，就是用快慢指针的方式， 慢指针每次走一步， 快指针每次走两步 ，然后判断快慢指针是否相同，如果有环，则一定会相撞。
     *
     * 该思路可以画图模拟走一下。
     */
    fun plan3(node: ListNode?): Boolean {
        var firstNode = node
        var secondNode = node
        var hasLoop = false
        while (firstNode?.next != null && secondNode?.next?.next != null) {
            firstNode = firstNode.next
            secondNode = secondNode.next?.next
            if (firstNode == secondNode) {
                hasLoop = true
                break
            }
        }
        return hasLoop
    }
}
