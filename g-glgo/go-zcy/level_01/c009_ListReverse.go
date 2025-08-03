package main

import "fmt"

type number struct {
	val int
}

type ListNode struct {
	val  int
	next *ListNode
}

// 反转单链表测试链接 : https://leetcode.cn/problems/reverse-linked-list/
func reverseList(head *ListNode) *ListNode {
	var prev *ListNode = nil
	var next *ListNode = nil
	for head != nil {
		next = head.next
		head.next = prev
		prev = head
		head = next
	}
	return prev
}

func (head *ListNode) printList() {
	for head != nil {
		fmt.Print(head.val)
		fmt.Print("->")
		head = head.next //  Go: 接收者就是普通参数，可自由修改（需明确其作用域限制），此处head的指向改变不影响调用处head
	}
	fmt.Println("nil")
	//fmt.Println("In printList", head.val)
}

type doubleListNode struct {
	val  int
	next *doubleListNode
	last *doubleListNode
}

func reverseDoubleList(head *doubleListNode) *doubleListNode {
	var prev *doubleListNode = nil
	var next *doubleListNode = nil
	for head != nil {
		next = head.next
		head.next = prev
		head.last = next
		prev = head
		head = next
	}
	return prev
}

func (head *doubleListNode) printList() {
	fmt.Print("nil<-")
	for head != nil {
		fmt.Print(head.val)
		head = head.next
		if head != nil {
			fmt.Print("<=>")
		}
	}
	fmt.Println("->nil")
	//fmt.Println("In printList", head.val)
}

func main() {
	//fTestParameter()
	sHead := ListNode{val: 0}
	sCurr := &sHead
	for i := range 4 {
		sCurr.next = &ListNode{val: i + 1}
		sCurr = sCurr.next
	}
	sHead.printList()
	head1 := reverseList(&sHead)
	head1.printList()
	fmt.Println(head1.val)

	dHead := doubleListNode{val: 0}
	dCurr := &dHead
	for i := range 4 {
		dLast := dCurr
		dCurr.next = &doubleListNode{val: i + 1}
		dCurr = dCurr.next
		dCurr.last = dLast
	}
	dHead.printList()
	head2 := reverseDoubleList(&dHead)
	head2.printList()
	//
	fmt.Println(head2.val)

}

func fTestParameter() {
	a := 10
	a1(a)
	fmt.Println(a)

	b := number{val: 5}
	b1(&b)
	fmt.Println(b.val)
	b2(&b)
	fmt.Println(b.val)
	b3(b)
	fmt.Println(b.val)

	c := []int{1, 2, 3, 4}
	c1(c)
	fmt.Println(c)
	c2(c)
	fmt.Println(c)
}

func a1(a int) {
	a = 0
}

func b1(b *number) {
	b = nil
}

func b2(b *number) {
	b.val = 6
}
func b3(b number) {
	b.val = 7
}

func c1(c []int) {
	c = nil
}

func c2(c []int) {
	c[0] = 100

}
