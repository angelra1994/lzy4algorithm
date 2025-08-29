package main

import (
	"fmt"
)

/**
// 递归序的解释
// 用递归实现二叉树的三序遍历
*/

type treeNode struct {
	val   int
	left  *treeNode
	right *treeNode
}

/**
递归序
					1
			↙↗			↘↖
		2						3
	↙↗	↘↖				↙↗	↘↖
	4		5				6		7
↙↗↘↖	↙↗↘↖	↙↗↘↖	↙↗↘↖

 		1,2,4,4,4,2,5,5,5,2,1,3,6,6,6,3,7,7,7,3,1
先序：   1,2,4,      5,        3,6,      7         (递归序中第1次出现)
中序：         4,  2,  5,    1,    6,  3,  7       (递归序中第2次出现)
后序：           4,      5,2,        6,      7,3,1 (递归序中第3次出现)

5）遍历二叉树复杂度分析：
   a. 时间复杂度O(n)，递归和非递归都是每个节点遇到有限几次，当然O(n)
   b. 额外空间复杂度O(h)，递归和非递归都需要二叉树高度h的空间来保存路径，方便回到上级去
   c. 存在时间复杂度O(n)，额外空间复杂度O(1)的遍历方式：Morris遍历
   d. Morris遍历比较难，也比较冷门
*/

func f(root *treeNode) {
	if root == nil {
		return
	}
	//1
	f(root.left)
	//2
	f(root.right)
	//3
}

func preOrder(root *treeNode) {
	if root == nil {
		return
	}
	fmt.Print(root.val, " ")
	preOrder(root.left)
	preOrder(root.right)
}

func inOrder(root *treeNode) {
	if root == nil {
		return
	}
	inOrder(root.left)
	fmt.Print(root.val, " ")
	inOrder(root.right)
}

func postOrder(root *treeNode) {
	if root == nil {
		return
	}
	postOrder(root.left)
	postOrder(root.right)
	fmt.Print(root.val, " ")
}

func main() {
	root := &treeNode{
		val: 1,
	}
	root.left = &treeNode{
		val: 2,
	}
	root.right = &treeNode{
		val: 3,
	}
	root.left.left = &treeNode{
		val: 4,
	}
	root.left.right = &treeNode{
		val: 5,
	}
	root.right.left = &treeNode{
		val: 6,
	}
	root.right.right = &treeNode{
		val: 7,
	}

	fmt.Println("preOrder:")
	preOrder(root)
	fmt.Println()

	fmt.Println("inOrder:")
	inOrder(root)
	fmt.Println()

	fmt.Println("postOrder:")
	postOrder(root)
	fmt.Println()
}
