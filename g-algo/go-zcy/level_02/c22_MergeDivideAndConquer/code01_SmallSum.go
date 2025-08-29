package main

/**
// 小和问题
// 测试链接 : https://www.nowcoder.com/practice/edfe05a1d45c4ea89101d936cac32469

*/

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

// > N
const maxn = 100001

// 正确的全局切片声明方式
var (
	arr  = make([]int, maxn) // 全局切片
	help = make([]int, maxn) // 辅助切片
	n    int
)

/**
高效输入（适合ACM竞赛）
reader := bufio.NewReader(os.Stdin)
data, _ := reader.ReadString('\n') // 读整行
nums := strings.Fields(data)      // 拆分字符串

多行输入处理
scanner := bufio.NewScanner(os.Stdin)
for scanner.Scan() {
    line := scanner.Text() // 逐行读取
    // 处理每行数据
}

字符串转换
strconv.Atoi("123")  // 字符串转整数
fmt.Sprint(123)      // 其他类型转字符串
*/

func main() {
	//reader := bufio.NewReader(os.Stdin)
	scanner := bufio.NewScanner(os.Stdin)
	scanner.Split(bufio.ScanLines) // 按行读取
	writer := bufio.NewWriter(os.Stdout)

	defer writer.Flush()

	// 读取n
	scanner.Scan()
	n, _ = strconv.Atoi(scanner.Text())

	// 读取数组
	scanner.Scan()
	nums := strings.Fields(scanner.Text())
	for i := 0; i < n; i++ {
		arr[i], _ = strconv.Atoi(nums[i])
	}

	//fmt.Println(arr[:n])

	fmt.Fprint(writer, smallSum(0, n-1))
	fmt.Fprintln(writer)

}

// 结果比较大，用int会溢出的，所以返回long类型
// 特别注意溢出这个点，笔试常见坑
// 返回arr[l...r]范围上，小和的累加和，同时请把arr[l..r]变有序
// 时间复杂度O(n * logn)
func smallSum(l, r int) int64 {
	if l == r {
		return 0
	}
	m := l + (r-l)>>1
	return smallSum(l, m) + smallSum(m+1, r) + merge(l, m, r)
}

// 返回跨左右产生的小和累加和，左侧有序、右侧有序，让左右两侧整体有序
// arr[l...m] arr[m+1...r]
func merge(l int, m int, r int) int64 {
	//var ans int64 = 0
	ans := int64(0)

	// 小和计算部分：模拟 Java 中的 for 循环逻辑
	for j, i, sum := m+1, l, int64(0); j <= r; j++ {
		for i <= m && arr[i] <= arr[j] {
			sum += int64(arr[i])
			i++
		}
		ans += sum
	}

	// 标准 merge 过程
	i := l
	a := l
	b := m + 1

	// 合并两个有序数组到 help
	for a <= m && b <= r {
		if arr[a] <= arr[b] {
			help[i] = arr[a]
			a++
		} else {
			help[i] = arr[b]
			b++
		}
		i++
	}

	// 处理剩余元素
	for a <= m {
		help[i] = arr[a]
		a++
		i++
	}

	for b <= r {
		help[i] = arr[b]
		b++
		i++
	}

	// 拷贝回原数组
	for i = l; i <= r; i++ {
		arr[i] = help[i]
	}

	return ans
}
