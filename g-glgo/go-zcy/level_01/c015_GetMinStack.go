package main

/**
  最小栈, getMin操作是O(1)的复杂度
  测试链接 : https://leetcode.cn/problems/min-stack/

*/

type MinStack struct {
	data []int
	min  []int
}

func Constructor() MinStack {
	return MinStack{
		data: make([]int, 0),
		min:  make([]int, 0),
	}
}

/**
 * 1. 当 x <= min[len(min)-1] 时, min 压入x
 * 2. 当 x > min[len(min)-1] 时， min 再次压入自己的栈顶
 * 3. min 和 data 都是空的时候， x 压入data 也 压入 min
 */
func (this *MinStack) Push(val int) {
	this.data = append(this.data, val)
	if len(this.min) == 0 || val <= this.GetMin() {
		this.min = append(this.min, val)
	} else {
		this.min = append(this.min, this.GetMin())
	}
}

func (this *MinStack) Pop() {
	this.data = this.data[:len(this.data)-1]
	this.min = this.min[:len(this.min)-1]
}

func (this *MinStack) Top() int {
	return this.data[len(this.data)-1]
}

func (this *MinStack) GetMin() int {
	return this.min[len(this.min)-1]
}

/**
 * Your MinStack object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Push(val);
 * obj.Pop();
 * param_3 := obj.Top();
 * param_4 := obj.GetMin();
 */
