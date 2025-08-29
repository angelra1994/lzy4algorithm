package main

import (
	"fmt"
)

func main() {
	arr := []int{1, 5, 3, 2, 4, 4, 9, 10, 1}
	//selectSort(arr)
	//bubbleSort(arr)
	insertSort(arr)
	fmt.Println(arr)

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
