package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
	"strconv"
	"strings"
)

/**
// 展示acm风格的测试方式
// 子矩阵的最大累加和问题，不要求会解题思路，后面的课会讲
// 每一组测试都给定数据规模
// 需要任何空间都动态生成，在大厂笔试或者比赛中，这种方式并不推荐
// 测试链接 : https://www.nowcoder.com/practice/cb82a97dcd0d48a7b1f4ee917e2c0409?
// 请同学们务必参考如下代码中关于输入、输出的处理
// 这是输入输出处理效率很高的写法
// 提交以下的code，提交时请把类名改成"Main"，可以直接通过
*/

func main() {
	reader := bufio.NewReader(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)

	defer writer.Flush()

	for {
		line, err := reader.ReadString('\n')
		if err != nil {
			break
		}
		line = strings.TrimSpace(line)
		if line == "" {
			continue
		}

		// 解析 n 和 m
		nm := strings.Split(line, " ")
		n, _ := strconv.Atoi(nm[0])
		m, _ := strconv.Atoi(nm[1])

		mat := make([][]int, n)
		for i := 0; i < n; i++ {
			rowLine, _ := reader.ReadString('\n')
			row := strings.Fields(rowLine)
			mat[i] = make([]int, m)
			for j := 0; j < m; j++ {
				num, _ := strconv.Atoi(row[j])
				mat[i][j] = num
			}
		}

		result := maxSumSubMatrix(mat, n, m)
		fmt.Fprintln(writer, result)
	}

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
