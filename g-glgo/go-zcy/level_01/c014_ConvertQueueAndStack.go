package main

import "math"

/*
*
用栈实现队列
用队列实现栈
测试链接 : https://leetcode.cn/problems/implement-queue-using-stacks/
*/
type MyQueue struct {
	in  []int
	out []int
}

func Constructor() MyQueue {
	return MyQueue{
		in:  make([]int, 0),
		out: make([]int, 0),
	}

}

/** Push element x to the back of queue. */
func (this *MyQueue) Push(x int) {
	for len(this.out) != 0 {
		val := this.out[len(this.out)-1]
		this.out = this.out[:len(this.out)-1]
		this.in = append(this.in, val)
	}
	this.in = append(this.in, x)

}

/** Removes the element from in front of queue and returns that element. */
func (this *MyQueue) Pop() int {
	for len(this.in) != 0 {
		val := this.in[len(this.in)-1]
		this.in = this.in[:len(this.in)-1]
		this.out = append(this.out, val)
	}
	// in栈 和 out栈 都是空的
	if len(this.out) == 0 {
		return math.MinInt
	}
	val := this.out[len(this.out)-1]
	this.out = this.out[:len(this.out)-1]
	return val

}

/** Get the front element. */
func (this *MyQueue) Peek() int {
	val := this.Pop()
	if val == math.MinInt {
		return math.MinInt
	}
	this.out = append(this.out, val)
	return val

}

/** Returns whether the queue is empty. */
func (this *MyQueue) Empty() bool {
	return len(this.in) == 0 && len(this.out) == 0
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Push(x);
 * param_2 := obj.Pop();
 * param_3 := obj.Peek();
 * param_4 := obj.Empty();
 */

/**
用队列实现栈。 队列的操作都是尾部进入（尾插），头部出去
// 测试链接 : https://leetcode.cn/problems/implement-stack-using-queues/
*/

type MyStack struct {
	queue []int
}

func Constructor() MyStack {
	return MyStack{
		queue: make([]int, 0),
	}
}

/** Push element x onto stack. 每次入栈的时候，已经调整好了成了先入后出 */
func (this *MyStack) Push(x int) {
	n := len(this.queue)
	this.queue = append(this.queue, x)
	for i := 0; i < n; i++ {
		this.queue = append(this.queue, this.queue[0])
		this.queue = this.queue[1:]
	}

}

/** Removes the element on top of the stack and returns that element. */
func (this *MyStack) Pop() int {
	val := this.queue[0]
	this.queue = this.queue[1:]
	return val
}

func (this *MyStack) Top() int {
	return this.queue[0]

}

func (this *MyStack) Empty() bool {
	return len(this.queue) == 0

}

/**
 * Your MyStack object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Push(x);
 * param_2 := obj.Pop();
 * param_3 := obj.Top();
 * param_4 := obj.Empty();
 */
