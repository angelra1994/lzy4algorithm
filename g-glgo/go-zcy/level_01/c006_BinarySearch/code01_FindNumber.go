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
		if exists(arr, num) != exists0(arr, num) {
			fmt.Println("出错了")
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

func exists0(arr []int, num int) bool {
	for v := range arr {
		if v == num {
			return true
		}
	}
	return false
}

// 二分查找, 有序数组中，查找num是否存在
func exists(arr []int, num int) bool {
	if arr == nil || len(arr) == 0 {
		return false
	}
	l, r := 0, len(arr)-1
	for l <= r {
		m := l + ((r - l) >> 1)
		if arr[m] == num {
			return true
		} else if arr[m] > num {
			r = m - 1
		} else {
			l = m + 1
		}
	}
	return false

}
