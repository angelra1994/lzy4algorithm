package main

// 给你一个链表的头节点 head 和一个特定值 x
// 请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
// 你应当 保留 两个分区中每个节点的初始相对位置
// 测试链接 : https://leetcode.cn/problems/partition-list/
func partition(head *ListNode, x int) *ListNode {

	var smallHead, smallTail, largeHead, largeTail *ListNode
	var tmp *ListNode
	for head != nil {
		tmp = head.next
		head.next = nil
		if head.val < x {
			if smallHead == nil {
				smallHead = head
				smallTail = head
			} else {
				smallTail.next = head
				smallTail = head
			}
		} else {
			if largeHead == nil {
				largeHead = head
				largeTail = head
			} else {
				largeTail.next = head
				largeTail = head
			}
		}
		head = tmp
	}
	if smallHead == nil {
		return largeHead
	}
	smallHead.next = largeHead
	return smallHead

}
