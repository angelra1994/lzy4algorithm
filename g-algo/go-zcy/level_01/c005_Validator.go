package main

import (
	"fmt"
	"math/rand"
	"time"
)

func main() {
	N := 200
	V := 1000
	testTimes := 50000
	fmt.Println("测试开始")
	start := time.Now()
	for i := 0; i < testTimes; i++ {
		// 随机得到一个长度，长度在[0~N-1]
		n := rand.Intn(N)
		arr := randomArray(n, V)
		arr1 := copyArray(arr)
		arr2 := copyArray(arr)
		arr3 := copyArray(arr)
		selectSort(arr1)
		bubbleSort(arr2)
		insertSort(arr3)
		if !sameArray(arr1, arr2) || !sameArray(arr1, arr3) {
			fmt.Println("出错了")
			return
		}
	}
	fmt.Println("测试结束, 用时：", time.Since(start))
}

func sameArray(arr1 []int, arr2 []int) bool {
	if len(arr1) != len(arr2) {
		return false
	}
	for i := 0; i < len(arr1); i++ {
		if arr1[i] != arr2[i] {
			return false
		}
	}
	return true

}

func randomArray(n, v int) []int {
	arr := make([]int, n)
	for i := 0; i < n; i++ {
		arr[i] = rand.Intn(v) + 1
	}
	return arr
}

func copyArray(arr []int) []int {
	newArr := make([]int, len(arr))
	for i := 0; i < len(arr); i++ {
		newArr[i] = arr[i]
	}
	return newArr
}

func swap(arr []int, i, j int) {
	arr[i], arr[j] = arr[j], arr[i]
}

/**
 * 选择排序 o(N^2)。
 * i~n-1范围上，选出到最小值并放在i位置，然后i+1~n-1范围上继续
 */
func selectSort(arr []int) {
	if arr == nil || len(arr) < 2 {
		return
	}
	for i := 0; i < len(arr)-1; i++ {
		minIndex := i
		for j := i + 1; j < len(arr); j++ {
			if arr[j] < arr[minIndex] {
				minIndex = j
			}
		}
		//将最小值和i位置数据交换
		swap(arr, i, minIndex)
	}
}

/**
 * 冒泡排序 o(N^2)
 * 0~i范围上，相邻位置较大的数滚下去，最大值最终来到i位置，然后0~i-1范围上继续
 */
func bubbleSort(arr []int) {
	if arr == nil || len(arr) < 2 {
		return
	}
	for end := len(arr) - 1; end > 0; end-- {
		for j := 0; j < end; j++ {
			// 相邻位置的数字交换，大的往右边放
			if arr[j] > arr[j+1] {
				swap(arr, j, j+1)
			}
		}
	}
}

/**
 * 插入排序 o(N^2)
 * 0~i范围上已经有序，新来的数从右到左依次交换滑到不再小的位置插入，然后继续
 */
func insertSort(arr []int) {
	if arr == nil || len(arr) < 2 {
		return
	}
	for i := 1; i < len(arr); i++ {
		for j := i - 1; j >= 0; j-- {
			if arr[j] > arr[j+1] {
				swap(arr, j, j+1)
			}
		}
		//for j := i - 1; j > 0 && arr[j] > arr[j+1]; j-- {
		//	swap(arr, j, j+1)
		//}

	}
}
