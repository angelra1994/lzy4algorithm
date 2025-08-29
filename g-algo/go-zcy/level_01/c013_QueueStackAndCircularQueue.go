package main

import (
	"container/list"
)

// 使用链表实现队列
type queue1 struct {
	list *list.List
}

func NewQueue1() *queue1 {
	return &queue1{
		list: list.New(),
	}
}

func (q *queue1) isEmpty() bool {
	return q.list.Len() == 0
}

// 向队列中加入num，加到尾巴
func (q *queue1) offer(num int) {
	q.list.PushBack(num)
}

// 从队列拿，从头拿出元素
func (q *queue1) poll() int {
	return q.list.Remove(q.list.Front()).(int)
}

// 返回队列头的元素但是不弹出
func (q *queue1) peek() int {
	return q.list.Front().Value.(int)
}

func (q *queue1) size() int {
	return q.list.Len()
}

// 使用slice实现队列 [l, r)
type queue2 struct {
	slice []int
	l     int
	r     int
}

func (q *queue2) isEmpty() bool {
	return q.l == q.r
}

// 向队列中加入num，加到尾巴
func (q *queue2) offer(num int) {
	q.slice[q.r] = num
	q.r = q.r + 1
}

func (q *queue2) poll() int {
	e := q.slice[q.l]
	q.l = q.l + 1
	return e
}

// 返回队列头的元素但是不弹出
func (q *queue2) peek() int {
	return q.slice[q.l]
}

// 返回队列头的元素但是不弹出
func (q *queue2) head() int {
	return q.slice[q.l]
}

// 返回队列头的元素但是不弹出
func (q *queue2) tail() int {
	return q.slice[q.r-1]
}

func (q *queue2) size() int {
	return q.r - q.l
}

//todo: 使用channel实现队列

// 使用链表实现栈
type stack1 struct {
	list *list.List
}

func NewStack1() *stack1 {
	return &stack1{
		list: list.New(),
	}
}

func (s *stack1) isEmpty() bool {
	return s.list.Len() == 0
}

func (s *stack1) push(num int) {
	s.list.PushBack(num)
}

// 从栈pop出元素，从尾巴拿出元素
func (s *stack1) pop() int {
	return s.list.Remove(s.list.Back()).(int)
}

// 返回栈顶头的元素但是不弹出
func (s *stack1) peek() int {
	return s.list.Back().Value.(int)
}

func (s *stack1) size() int {
	return s.list.Len()
}

// 基于切片的栈
type stack2 struct {
	slice []int
}

func (s *stack2) isEmpty() bool {
	return len(s.slice) == 0
}
func (s *stack2) push(num int) {
	s.slice = append(s.slice, num) // 入栈
}

func (s *stack2) pop() int {
	e := s.slice[len(s.slice)-1]
	s.slice = s.slice[:len(s.slice)-1] // 出栈
	return e
}

func (s *stack2) peek() int {
	return s.slice[len(s.slice)-1]
}

func (s *stack2) size() int {
	return len(s.slice)
}

// 设计循环队列
// 测试链接 : https://leetcode.cn/problems/design-circular-queue/
type MyCircularQueue struct {
	queue []int
	l     int
	r     int
	size  int
	limit int
}

// 同时在队列里面的数字个数不超过k个
func Constructor(k int) MyCircularQueue {
	return MyCircularQueue{
		queue: make([]int, k),
		l:     0,
		r:     0,
		size:  0,
		limit: k,
	}

}

// 如果队列满了，什么也不做，返回false
// 如果队列没满，加入value，返回true
func (this *MyCircularQueue) EnQueue(value int) bool {
	if this.IsFull() {
		return false
	}
	this.queue[this.r] = value
	if this.r == this.limit-1 {
		this.r = 0
	} else {
		this.r++
	}
	this.size++
	return true
}

// 如果队列空了，什么也不做，返回false
// 如果队列没空，弹出头部的数字，返回true
func (this *MyCircularQueue) DeQueue() bool {
	if this.IsEmpty() {
		return false
	}
	if this.l == this.limit-1 {
		this.l = 0
	} else {
		this.l++
	}
	this.size--
	return true

}

// 返回队列头部的数字（不弹出），如果没有数返回-1
func (this *MyCircularQueue) Front() int {
	if this.IsEmpty() {
		return -1
	}
	return this.queue[this.l]

}

// 返回队列尾部的数字（不弹出），如果没有数返回-1
func (this *MyCircularQueue) Rear() int {
	if this.IsEmpty() {
		return -1
	}
	var last int
	if this.r == 0 {
		last = this.limit - 1
	} else {
		last = this.r - 1
	}
	return this.queue[last]

}

func (this *MyCircularQueue) IsEmpty() bool {
	return this.size == 0
}

func (this *MyCircularQueue) IsFull() bool {
	return this.size == this.limit
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * obj := Constructor(k);
 * param_1 := obj.EnQueue(value);
 * param_2 := obj.DeQueue();
 * param_3 := obj.Front();
 * param_4 := obj.Rear();
 * param_5 := obj.IsEmpty();
 * param_6 := obj.IsFull();
 */
