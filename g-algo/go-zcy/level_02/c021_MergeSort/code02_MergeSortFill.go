package main

import "fmt"

/**
// 归并排序，填函数练习风格
// 测试链接 : https://leetcode.cn/problems/sort-an-array/


1）左部分排好序、右部分排好序、利用merge过程让左右整体有序（谁小拷贝谁）
2）merge过程：谁小拷贝谁，直到左右两部分所有的数字耗尽，拷贝回原数组
3）递归实现和非递归实现
4）时间复杂度O(n * logn)
5）需要辅助数组，所以额外空间复杂度O(n)
6）归并排序为什么比O(n^2)的排序快？因为比较行为没有浪费！
7）利用归并排序的便利性可以解决很多问题 - 归并分治 - 下节课

*/

// > N
const maxn = 100001

// ✅ 正确的全局切片声明方式
var help = make([]int, maxn) // 辅助切片

func main() {
	nums := []int{5, 2, 3, 1}
	fmt.Println(nums)

	fmt.Println(sortArray(nums))

}

func sortArray(nums []int) []int {
	if len(nums) > 1 {
		// mergeSort1为递归方法
		// mergeSort2为非递归方法
		// 用哪个都可以
		// mergeSort1(nums);
		mergeSort2(nums)
	}
	return nums
}

func mergeSort1(arr []int) {
	sort(arr, 0, len(arr)-1)

}

func sort(arr []int, l, r int) {
	if l >= r {
		return
	}
	m := l + (r-l)>>1
	sort(arr, l, m)
	sort(arr, m+1, r)
	merge(arr, l, m, r)
}

// 归并排序迭代版
// 时间复杂度O(n*logn) 空间复杂读O(n)
func mergeSort2(arr []int) {
	n := len(arr)
	// 一共发生O(logn)次
	for l, m, r, step := 0, 0, 0, 1; step < n; step <<= 1 {
		// 内部分租merge，时间复杂读O(n)
		l = 0
		for l < n {
			m = l + step - 1
			if m+1 >= n {
				break
			}
			r = min(l+step<<1-1, n-1)
			//l...m   m+1...r
			//                 l...m  m+1...r
			//                 				  l...m  m+1...r
			merge(arr, l, m, r)
			l = r + 1
		}
	}

}

func merge(arr []int, l int, m int, r int) {
	i := l
	a := l
	b := m + 1
	for a <= m && b <= r {
		if arr[a] <= arr[b] {
			help[i] = arr[a]
			i++
			a++
		} else {
			help[i] = arr[b]
			i++
			b++
		}
	}

	for a <= m {
		help[i] = arr[a]
		i++
		a++
	}

	for b <= r {
		help[i] = arr[b]
		i++
		b++
	}

	for i = l; i <= r; i++ {
		arr[i] = help[i]
	}

}
