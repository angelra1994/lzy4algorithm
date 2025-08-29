package main

// 给你两个 非空 的链表，表示两个非负的整数
// 它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字
// 请你将两个数相加，并以相同形式返回一个表示和的链表。
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头
// 测试链接：https://leetcode.cn/problems/add-two-numbers/
func addTwoNumbers1(l1 *ListNode, l2 *ListNode) *ListNode {
	var ans, cur *ListNode
	carry := 0
	sum := 0
	val := 0

	for l1 != nil && l2 != nil {
		sum = l1.val + l2.val + carry
		val = sum % 10
		carry = sum / 10
		if ans == nil {
			ans = &ListNode{val: val}
			cur = ans
		} else {
			cur.next = &ListNode{val: val}
			cur = cur.next
		}

		l1 = l1.next
		l2 = l2.next
	}

	for l1 != nil {
		sum = l1.val + carry
		val = sum % 10
		carry = sum / 10
		cur.next = &ListNode{val: val}
		cur = cur.next
		l1 = l1.next
	}

	for l2 != nil {
		sum = l2.val + carry
		val = sum % 10
		carry = sum / 10
		cur.next = &ListNode{val: val}
		cur = cur.next
		l2 = l2.next
	}

	if carry == 1 {
		cur.next = &ListNode{val: 1}
	}

	return ans

}

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	pre := &ListNode{}
	cur := pre

	carry := 0
	sum := 0
	val := 0

	for l1 != nil || l2 != nil {
		a, b := 0, 0
		if l1 != nil {
			a = l1.val
			l1 = l1.next
		}
		if l2 != nil {
			b = l2.val
			l2 = l2.next
		}
		sum = a + b + carry
		val = sum % 10
		carry = sum / 10

		cur.next = &ListNode{val: val}
		cur = cur.next

	}

	if carry == 1 {
		cur.next = &ListNode{val: 1}
	}

	return pre.next

}

func addTwoNumbers2(l1 *ListNode, l2 *ListNode) *ListNode {
	var ans, cur *ListNode
	carry := 0
	for sum, val := 0, 0; l1 != nil || l2 != nil; {
		sum = carry
		if l1 != nil {
			sum += l1.val
			l1 = l1.next
		}
		if l2 != nil {
			sum += l2.val
			l2 = l2.next
		}

		val = sum % 10
		carry = sum / 10

		if ans == nil {
			ans = &ListNode{val: val}
			cur = ans
		} else {
			cur.next = &ListNode{val: val}
			cur = cur.next
		}
	}

	if carry == 1 {
		cur.next = &ListNode{val: 1}
	}

	return ans

}
