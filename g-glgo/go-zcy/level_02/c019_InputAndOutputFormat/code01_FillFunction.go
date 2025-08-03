package c019_InputAndOutputFormat

import "math"

/**
// 展示填函数风格的测试方式
// 子矩阵的最大累加和问题，不要求会解题思路，后面的课会讲
// 测试链接 : https://www.nowcoder.com/practice/840eee05dccd4ffd8f9433ce8085946b
*/

func sumOfSubMatrix(mat [][]int, n int) int {
	return maxSumSubMatrix(mat, n, n)
}

/*
*
求子矩阵的最大累加和
*/
func maxSumSubMatrix(mat [][]int, n, m int) int {
	ans := math.MinInt
	for i := 0; i < n; i++ {
		arr := make([]int, m)
		for j := i; j < n; j++ {
			for k := 0; k < m; k++ {
				arr[k] += mat[j][k]
			}
			ans = max(ans, maxSumSubArray(arr, m))
		}
	}
	return ans
}

/*
*
求子数组的最大累加和
*/
func maxSumSubArray(arr []int, n int) int {
	ans := math.MinInt
	sum := 0
	for i := 0; i < n; i++ {
		sum += arr[i]
		ans = max(ans, sum)
		if sum < 0 {
			sum = 0
		}
	}
	return ans
}
