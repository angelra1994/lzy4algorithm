package main

/**
// 归并排序，acm练习风格
// 测试链接 : https://www.luogu.com.cn/problem/P1177
// 请同学们务必参考如下代码中关于输入、输出的处理
// 这是输入输出处理效率很高的写法
// 提交以下的code，提交时请把类名改成"Main"，可以直接通过


1）左部分排好序、右部分排好序、利用merge过程让左右整体有序（谁小拷贝谁）
2）merge过程：谁小拷贝谁，直到左右两部分所有的数字耗尽，拷贝回原数组
3）递归实现和非递归实现
4）时间复杂度O(n * logn)
5）需要辅助数组，所以额外空间复杂度O(n)
6）归并排序为什么比O(n^2)的排序快？因为比较行为没有浪费！
7）利用归并排序的便利性可以解决很多问题 - 归并分治 - 下节课

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

// ✅ 正确的全局切片声明方式
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

	//mergeSort1(0, n-1)
	mergeSort2()
	for i := 0; i < n; i++ {
		fmt.Fprint(writer, arr[i], " ")
	}
	fmt.Fprintln(writer)

}

// 归并排序递归版
// 假设l...r一共n个数
// T(n) = 2 * T(n/2) + O(n)
// a = 2, b = 2, c = 1
// 根据master公式，时间复杂度O(n * logn)
// 空间复杂度O(n)， 额外数组
func mergeSort1(l, r int) {
	if l == r {
		return
	}
	m := l + (r-l)>>1
	mergeSort1(l, m)
	mergeSort1(m+1, r)
	merge(l, m, r)
}

// 归并排序迭代版
// 时间复杂度O(n*logn) 空间复杂读O(n)
func mergeSort2() {
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
			merge(l, m, r)
			l = r + 1
		}
	}

}

// l....r 一共有n个数 ，O(n)
func merge(l int, m int, r int) {
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

	// 左侧指针、右侧指针，必有一个越界、另一个不越界
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
