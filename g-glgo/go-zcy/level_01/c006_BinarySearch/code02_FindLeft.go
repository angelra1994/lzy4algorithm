package main

import (
	"fmt"
	"math/rand"
	"sort"
	"time"
)

func main() {
	N := 100
	V := 1000
	testTimes := 50_0000
	fmt.Println("测试开始")
	start := time.Now()
	for i := 0; i < testTimes; i++ {
		// 随机得到一个长度，长度在[0~N-1]
		n := rand.Intn(N)
		arr := randomArray(n, V)
		sort.Ints(arr)
		num := rand.Intn(V)
		if findLeft(arr, num) != findLeft0(arr, num) {
			fmt.Println("出错了")
			//fmt.Println(arr)
			//fmt.Println(num)
			//fmt.Println(findLeft(arr, num), findLeft0(arr, num))

			return
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
func findLeft0(arr []int, num int) int {
	// 从小往大找
	for i, v := range arr {
		if v >= num {
			return i
		}
	}
	return -1
}

/**
 *找到>=num的最左边位置
 *arr[m]>=num, ans暂存m，继续往左二分
 *arr[m]<num, 不记录m，往右二分
 */
func findLeft(arr []int, num int) int {
	l, r := 0, len(arr)-1
	ans := -1
	for l <= r {
		m := l + ((r - l) >> 1)
		if arr[m] >= num {
			ans = m
			r = m - 1
		} else {
			l = m + 1
		}
	}
	return ans
}
