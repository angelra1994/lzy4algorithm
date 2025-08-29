package main

// 将两个升序链表合并为一个新的 升序 链表并返回
// 新链表是通过拼接给定的两个链表的所有节点组成的
// 测试链接 : https://leetcode.cn/problems/merge-two-sorted-lists/

//type ListNode struct {
//	val  int
//	next *ListNode
//}

func mergeTwoLists(list1 *ListNode, list2 *ListNode) *ListNode {
	if list1 == nil {
		return list2
	}
	if list2 == nil {
		return list1
	}
	dummyHead := &ListNode{}
	cur := dummyHead
	for list1 != nil && list2 != nil {
		if list1.val <= list2.val {
			cur.next = list1
			list1 = list1.next
		} else {
			cur.next = list2
			list2 = list2.next
		}
		cur = cur.next
	}
	if list1 != nil {
		cur.next = list1
	}
	if list2 != nil {
		cur.next = list2
	}
	return dummyHead.next

}
func mergeTwoLists1(list1 *ListNode, list2 *ListNode) *ListNode {
	if list1 == nil {
		return list2
	}
	if list2 == nil {
		return list1
	}
	var head *ListNode
	if list1.val <= list2.val {
		head = list1
	} else {
		head = list2
	}
	cur1 := head.next
	var cur2 *ListNode
	if head == list1 {
		cur2 = list2
	} else {
		cur2 = list1
	}
	pre := head
	for cur1 != nil && cur2 != nil {
		if cur1.val <= cur2.val {
			pre.next = cur1
			cur1 = cur1.next
		} else {
			pre.next = cur2
			cur2 = cur2.next
		}
		pre = pre.next
	}
	if cur1 != nil {
		pre.next = cur1
	} else {
		pre.next = cur2
	}

	return head

}
