package main

/**
// 设计循环双端队列
// 测试链接 : https://leetcode.cn/problems/design-circular-deque/
*/

type MyCircularDeque struct {
	deque []int
	size  int
	limit int
}

func Constructor(k int) MyCircularDeque {
	return MyCircularDeque{
		deque: make([]int, 0),
		size:  0,
		limit: k,
	}
}

// 将一个元素添加到双端队列头部。 如果操作成功返回 true ，否则返回 false
func (this *MyCircularDeque) InsertFront(value int) bool {
	if this.IsFull() {
		return false
	}
	this.deque = append([]int{value}, this.deque...)
	this.size++
	return true

}

// 将一个元素添加到双端队列尾部。如果操作成功返回 true ，否则返回 false 。
func (this *MyCircularDeque) InsertLast(value int) bool {
	if this.IsFull() {
		return false
	}
	this.deque = append(this.deque, value)
	this.size++
	return true
}

// 从双端队列头部删除一个元素。 如果操作成功返回 true ，否则返回 false 。
func (this *MyCircularDeque) DeleteFront() bool {
	if this.IsEmpty() {
		return false
	}
	this.deque = this.deque[1:]
	this.size--
	return true
}

// 从双端队列尾部删除一个元素。如果操作成功返回 true ，否则返回 false 。
func (this *MyCircularDeque) DeleteLast() bool {
	if this.IsEmpty() {
		return false
	}

	this.deque = this.deque[:this.size-1]
	this.size--
	return true
}

// 从双端队列头部获得一个元素。如果双端队列为空，返回 -1
func (this *MyCircularDeque) GetFront() int {
	if this.IsEmpty() {
		return -1
	}
	return this.deque[0]
}

// 获得双端队列的最后一个元素。 如果双端队列为空，返回 -1
func (this *MyCircularDeque) GetRear() int {
	if this.IsEmpty() {
		return -1
	}
	return this.deque[this.size-1]
}

// 若双端队列为空，则返回 true ，否则返回 false
func (this *MyCircularDeque) IsEmpty() bool {
	return this.size == 0
}

// 若双端队列满了，则返回 true ，否则返回 false
func (this *MyCircularDeque) IsFull() bool {
	return this.size == this.limit
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * obj := Constructor(k);
 * param_1 := obj.InsertFront(value);
 * param_2 := obj.InsertLast(value);
 * param_3 := obj.DeleteFront();
 * param_4 := obj.DeleteLast();
 * param_5 := obj.GetFront();
 * param_6 := obj.GetRear();
 * param_7 := obj.IsEmpty();
 * param_8 := obj.IsFull();
 */
