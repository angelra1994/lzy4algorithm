package main

import (
	"fmt"
	"math"
	"math/rand"
	"time"
)

/**
 * 峰值元素是指其值严格大于左右相邻值的元素
 * 给你一个整数数组 nums，已知任何两个相邻的值都不相等
 * 找到峰值元素并返回其索引
 * 数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 * 你可以假设 nums[-1] = nums[n] = 无穷小
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 */
func main() {

	arr0 := []int{1, 2, 2}
	//arr0 := []int{-2147483648, -2147483647}
	fmt.Println(math.MinInt)
	fmt.Println(findPeak(arr0))

	N := 100
	V := 1000
	testTimes := 50_0000
	fmt.Println("测试开始")
	start := time.Now()
	for i := 0; i < testTimes; i++ {
		// 随机得到一个长度，长度在[0~N-1]
		n := rand.Intn(N)
		arr := randomArray(n, V)
		index := findPeak(arr)

		if len(arr) == 0 && index != -1 {
			fmt.Println("出错了")
		} else if len(arr) == 1 && index != 0 {
			fmt.Println("出错了")
		}
		if index == 0 && arr[0] <= arr[1] {
			fmt.Println("出错了")
		} else if index == len(arr)-1 && arr[len(arr)-1] <= arr[len(arr)-2] {
			fmt.Println("出错了")
		} else {
			if arr[index] <= arr[index-1] || arr[index] <= arr[index+1] {
				fmt.Println("出错了")
			}
		}

	}

	fmt.Println("测试结束, 用时：", time.Since(start))

}

func randomArray(n, v int) []int {
	arr := make([]int, n)
	for i := 0; i < n; i++ {
		arr[i] = rand.Intn(v) + 1
	}
	return arr
}

/*
  - 假设 nums[-1] = nums[n] = 无穷小
    *1. 检查0位置和N-1位置 是不是峰值。如果数字长度只有1，直接返回arr[0]
    *2. [1,N-2]，判断中点是否是峰值。
    *3. 左右区间找左端点，右端点趋势不同的区间进行二分如↗️↘️(找谷值)

测试链接 : https://leetcode.cn/problems/find-peak-element/
*/
func findPeak(arr []int) int {
	if arr == nil || len(arr) == 0 {
		return -1
	}
	n := len(arr)
	if n == 1 {
		return 0
	}
	if arr[0] > arr[1] {
		return 0
	}
	if arr[n-1] > arr[n-2] {
		return n - 1
	}
	l, r, m := 1, n-2, 0
	ans := -1
	for l < r {
		m = l + (r-l)>>1
		if arr[m] > arr[m-1] {
			r = m - 1
		} else if arr[m] < arr[m+1] {
			l = m + 1
		} else {
			ans = m
			break
		}
	}
	return ans
}

func findPeakElement(nums []int) int {
	n := len(nums)
	get := func(i int) int {
		if i == -1 || i == n {
			return math.MinInt
		}
		return nums[i]
	}
	idx := rand.Intn(n)

	for !(get(idx-1) < get(idx) && get(idx) > get(idx+1)) {
		if get(idx) < get(idx+1) {
			if idx == n-2 && get(idx) == get(idx+1) {
				idx = -1
				break
			}
			idx++
		} else {
			idx--
		}
	}
	return idx
}
