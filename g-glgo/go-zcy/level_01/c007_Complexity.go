package main

import (
	"fmt"
	"math/rand"
	"time"
)

/**
常数时间操作：位运算, 算数运算，数组寻址，hash运算(常数时间比较大)
O(1) O(logN) O(N*logN) O(N^2) ... O(N^k) O(2^N) ...  O(k^N) ... O(N!)
*/

func main() {
	arr0 := []int{1, 5, 3, 2, 4, 4, 9, 10, 1}
	//selectSort(arr0)
	bubbleSort(arr0)
	//insertSort(arr0)
	fmt.Println(arr0)

	n, v := 10, 4
	arr1 := make([]int, n)
	arr1[0] = rand.Intn(v)
	// 生成相邻位置不重复的数组
	for i := 1; i < n; i++ {
		for {
			arr1[i] = rand.Intn(v)
			if arr1[i] != arr1[i-1] {
				break
			}
		}
	}
	fmt.Println(arr1)
	bubbleSort(arr1)
	//insertSort(arr0)
	fmt.Println(arr1)

	N := 20_0000
	start := time.Now()
	for i := 1; i < N; i++ {
		for j := i; j < N; j += i {
			// 这两个嵌套for循环的流程，时间复杂度为O(N * logN)
			// 1/1 + 1/2 + 1/3 + 1/4 + 1/5 + ... + 1/n，也叫"调和级数"，收敛于O(logN)
			// 所以如果一个流程的表达式 : n/1 + n/2 + n/3 + ... + n/n
			// 那么这个流程时间复杂度O(N * logN)
		}
	}
	fmt.Println("N =", N, ", O(N*logN) 用时", time.Since(start))

	start = time.Now()
	for i := 1; i < N; i++ {
		for j := i; j < N; j++ {
			// 这两个嵌套for循环的流程，时间复杂度为O(N^2)
			// 很明显等差数列
		}
	}
	fmt.Println("N =", N, ", O(N^2) 用时", time.Since(start))

}

/**
 * 使用一个循环完成冒泡排序，但是时间复杂度依旧是O(N^2)
 * 双指针形式
 */
func bubbleSort(arr []int) {
	if arr == nil || len(arr) < 2 {
		return
	}
	end := len(arr) - 1
	i := 0
	for end > 0 {
		if arr[i] > arr[i+1] {
			arr[i], arr[i+1] = arr[i+1], arr[i]
		}
		if i < end-1 {
			i++
		} else { // 此时 i 来到end位置。固定end位置的数据，i回到0位置，end位置减1
			end--
			i = 0
		}
	}
}

func selectSort(arr []int) {
	if arr == nil || len(arr) < 2 {
		return
	}
	for i := 0; i < len(arr); i++ {
		minIndex := i
		for j := i + 1; j < len(arr); j++ {
			if arr[j] < arr[minIndex] {
				minIndex = j
			}
		}
		arr[i], arr[minIndex] = arr[minIndex], arr[i]
	}
}

func insertSort(arr []int) {
	if arr == nil || len(arr) < 2 {
		return
	}
	for i := 1; i < len(arr); i++ {
		for j := i - 1; j >= 0; j-- {
			if arr[j] > arr[j+1] {
				arr[j], arr[j+1] = arr[j+1], arr[j]
			}
		}
	}
}
