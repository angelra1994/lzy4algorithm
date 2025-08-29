package main

import (
	"fmt"
)

type treeNode struct {
	val   int
	left  *treeNode
	right *treeNode
}

/*
*
先序：中左右

	 中
	 栈	|左|
		|右|
*/
func preOrderTraversal(root *treeNode) {
	if root != nil {
		stack := []*treeNode{root}
		for len(stack) > 0 {
			// 1. 从栈中弹出一个元素
			node := stack[len(stack)-1]
			stack = stack[:len(stack)-1]
			fmt.Print(node.val, " ")
			// 2. 添加右子树，先压右，后弹出
			if node.right != nil {
				stack = append(stack, node.right)
			}

			// 3. 添加左子树，后压右，先弹出
			if node.left != nil {
				stack = append(stack, node.left)
			}
		}
		fmt.Println()
	}
}

/*
*
* 中序：左中右
 1. 子树左边界的进栈。
 2. 栈中弹出元素就打印。元素右节点重复步骤1
 3. 没有子树且栈为空。结束遍历
*/
func inOrderTraversal(root *treeNode) {
	if root != nil {
		stack := make([]*treeNode, 0)
		for len(stack) > 0 || root != nil {
			if root != nil {
				stack = append(stack, root)
				root = root.left
			} else {
				node := stack[len(stack)-1]
				stack = stack[:len(stack)-1]
				fmt.Print(node.val, " ")
				root = node.right
			}
		}
		fmt.Println()
	}
}

/*
* 后序（两个栈实现）：左右中 （中左右 -> 中右左 -> 左右中）
*   中	         中    辅助栈 |左|
*   栈 |左|	 栈	|右|         |右|
*      |右|		|左|         |中|
 */
func posOrderTwoStacks(root *treeNode) {
	if root != nil {
		stack := []*treeNode{root}
		var help []*treeNode
		for len(stack) > 0 {
			// 1. 从栈中弹出一个元素
			node := stack[len(stack)-1]
			stack = stack[:len(stack)-1]
			help = append(help, node)

			//help = append([]*treeNode{node}, help...)

			// 2. 添加左子树，后压右，先弹出
			if node.left != nil {
				stack = append(stack, node.left)
			}

			// 3. 添加右子树，先压右，后弹出
			if node.right != nil {
				stack = append(stack, node.right)
			}
		}

		for i := len(help) - 1; i >= 0; i-- {
			fmt.Print(help[i].val, " ")
		}
		fmt.Println()
	}

}

/*
* 后序（一个栈实现）：左右中
1. 有左树且左树没处理过，左节点进栈。
2. 有右树且右树没处理过，左节点进栈。
3. 无左树或左树已处理过，无右树或右树已处理过，打印节点。并标记该节点为root，表明处理过。
*/
func posOrderOneStack(root *treeNode) {
	if root != nil {
		stack := make([]*treeNode, 0)
		stack = append(stack, root)
		// 如果始终没有打印过节点，root就一直是头节点
		// 一旦打印过节点，root就变成打印节点
		// 之后root的含义 : 上一次打印的节点
		for len(stack) != 0 {
			curNode := stack[len(stack)-1]
			if curNode.left != nil && curNode.left != root && curNode.right != root {
				// 有左树且左树没有被处理过。左节点入栈
				stack = append(stack, curNode.left)
			} else if curNode.right != nil && curNode.right != root {
				// 左边界处理完毕后，有右树且右树没有被处理过。右节点入栈
				stack = append(stack, curNode.right)
			} else {
				// 左边界处理完毕后，不存在右子树，或者右子树已经被处理过。打印节点
				fmt.Print(curNode.val, " ")
				stack = stack[:len(stack)-1]
				root = curNode
			}
		}
		fmt.Println()
	}

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
	preOrderTraversal(root)
	fmt.Println("inOrderTraversal:")
	inOrderTraversal(root)
	fmt.Println("posOrderTwoStacks:")
	posOrderTwoStacks(root)
	fmt.Println("posOrderOneStack:")
	posOrderOneStack(root)
	fmt.Println("preorderTraversal:", preorderTraversal(root))
	fmt.Println("inorderTraversal:", inorderTraversal(root))
	fmt.Println("postorderTraversal1:", postorderTraversal1(root))
	fmt.Println("postorderTraversal2:", postorderTraversal2(root))
}

/*
*
// 用一个栈完成先序遍历
// 测试链接 : https://leetcode.cn/problems/binary-tree-preorder-traversal/
*/
func preorderTraversal(root *treeNode) []int {
	ans := make([]int, 0)
	if root != nil {
		stack := make([]*treeNode, 0)
		stack = append(stack, root)
		for len(stack) > 0 {
			node := stack[len(stack)-1]
			stack = stack[:len(stack)-1]
			ans = append(ans, node.val)
			if node.right != nil {
				stack = append(stack, node.right)
			}
			if node.left != nil {
				stack = append(stack, node.left)
			}
		}
	}
	return ans
}

/*
*
// 用一个栈完成中序遍历
// 测试链接 : https://leetcode.cn/problems/binary-tree-inorder-traversal/
*/
func inorderTraversal(root *treeNode) []int {
	ans := make([]int, 0)
	if root != nil {
		stack := make([]*treeNode, 0)
		for len(stack) > 0 || root != nil {
			if root != nil {
				stack = append(stack, root)
				root = root.left
			} else {
				node := stack[len(stack)-1]
				stack = stack[:len(stack)-1]
				ans = append(ans, node.val)
				root = node.right
			}
		}
	}
	return ans
}

/*
*
// 用两个栈完成后序遍历
// 提交时函数名改为postorderTraversal
// 测试链接 : https://leetcode.cn/problems/binary-tree-postorder-traversal/
*/
func postorderTraversal1(root *treeNode) []int {
	ans := make([]int, 0)
	if root != nil {
		stack := make([]*treeNode, 0)
		stack = append(stack, root)
		for len(stack) > 0 {
			node := stack[len(stack)-1]
			stack = stack[:len(stack)-1]
			ans = append([]int{node.val}, ans...)

			if node.left != nil {
				stack = append(stack, node.left)
			}

			if node.right != nil {
				stack = append(stack, node.right)
			}
		}
	}

	return ans
}

/*
*
// 用一个栈完成中序遍历
// 测试链接 : https://leetcode.cn/problems/binary-tree-inorder-traversal/
*/
func postorderTraversal2(root *treeNode) []int {
	ans := make([]int, 0)
	if root != nil {
		stack := make([]*treeNode, 0)
		stack = append(stack, root)
		for len(stack) > 0 {
			node := stack[len(stack)-1]
			if node.left != nil && node.left != root && node.right != root {
				stack = append(stack, node.left)
			} else if node.right != nil && node.right != root {
				stack = append(stack, node.right)
			} else {
				ans = append(ans, node.val)
				stack = stack[:len(stack)-1]
				root = node
			}
		}
	}

	return ans
}
