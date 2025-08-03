package acm

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

// 常量定义
const (
	MAXN = 100005
	INF  = 0x3f3f3f3f
	MOD  = 1000000007
)

// 全局变量
var (
	// 输入输出相关
	scanner = bufio.NewScanner(os.Stdin)
	writer  = bufio.NewWriter(os.Stdout)

	// 常用数组（根据题目需要调整大小）
	arr   = make([]int, MAXN)
	help  = make([]int, MAXN)
	graph = make([][]int, MAXN)

	// 其他常用变量
	n, m, k int
)

// 初始化函数
func init() {
	scanner.Split(bufio.ScanWords) // 默认按空格分割，也可改为 bufio.ScanLines 按行分割
	// 初始化图结构
	for i := range graph {
		graph[i] = make([]int, 0)
	}
}

// 快速读取整数
func readInt() int {
	scanner.Scan()
	x, _ := strconv.Atoi(scanner.Text())
	return x
}

// 快速读取字符串
func readString() string {
	scanner.Scan()
	return scanner.Text()
}

// 读取一行并分割为整数数组
func readInts() []int {
	scanner.Scan()
	fields := strings.Fields(scanner.Text())
	res := make([]int, len(fields))
	for i, field := range fields {
		res[i], _ = strconv.Atoi(field)
	}
	return res
}

// 快速打印（不换行）
func print(a ...interface{}) {
	fmt.Fprint(writer, a...)
}

// 快速打印（换行）
func println(a ...interface{}) {
	fmt.Fprintln(writer, a...)
}

// 主函数
func main() {
	defer writer.Flush() // 记得刷新输出缓冲区

	// ========== 输入处理 ==========
	// 示例：读取单个整数
	// n = readInt()

	// 示例：读取两个整数
	// n, m = readInt(), readInt()

	// 示例：读取一行整数到数组
	// nums := readInts()

	// 示例：逐个读取数组元素
	// for i := 0; i < n; i++ {
	//     arr[i] = readInt()
	// }

	// ========== 算法处理 ==========
	// 在这里实现你的算法逻辑
	result := solve()

	// ========== 输出结果 ==========
	println(result)
}

// 算法主逻辑函数
func solve() interface{} {
	// 实现你的算法逻辑
	// 返回结果

	// 示例：
	// return n * m

	// 示例：调用递归函数
	// return dfs(0)

	return 0
}

// 常用算法函数模板

// 深度优先搜索
func dfs(u int) int64 {
	// 实现DFS逻辑
	return 0
}

// 广度优先搜索
func bfs() int {
	// 实现BFS逻辑
	return 0
}

// 并查集
type UnionFind struct {
	parent []int
	size   []int
	count  int
}

func NewUnionFind(n int) *UnionFind {
	uf := &UnionFind{
		parent: make([]int, n),
		size:   make([]int, n),
		count:  n,
	}
	for i := 0; i < n; i++ {
		uf.parent[i] = i
		uf.size[i] = 1
	}
	return uf
}

func (uf *UnionFind) Find(x int) int {
	if uf.parent[x] != x {
		uf.parent[x] = uf.Find(uf.parent[x]) // 路径压缩
	}
	return uf.parent[x]
}

func (uf *UnionFind) Union(x, y int) bool {
	rootX := uf.Find(x)
	rootY := uf.Find(y)
	if rootX == rootY {
		return false
	}
	// 按秩合并
	if uf.size[rootX] < uf.size[rootY] {
		rootX, rootY = rootY, rootX
	}
	uf.parent[rootY] = rootX
	uf.size[rootX] += uf.size[rootY]
	uf.count--
	return true
}

// 二分查找
func binarySearch(arr []int, target int) int {
	left, right := 0, len(arr)-1
	for left <= right {
		mid := left + (right-left)/2
		if arr[mid] == target {
			return mid
		} else if arr[mid] < target {
			left = mid + 1
		} else {
			right = mid - 1
		}
	}
	return -1
}

// 快速排序
func quickSort(arr []int, left, right int) {
	if left >= right {
		return
	}
	pivot := partition(arr, left, right)
	quickSort(arr, left, pivot-1)
	quickSort(arr, pivot+1, right)
}

func partition(arr []int, left, right int) int {
	pivot := arr[right]
	i := left
	for j := left; j < right; j++ {
		if arr[j] < pivot {
			arr[i], arr[j] = arr[j], arr[i]
			i++
		}
	}
	arr[i], arr[right] = arr[right], arr[i]
	return i
}

// 归并排序
func mergeSort(arr []int, left, right int) {
	if left >= right {
		return
	}
	mid := left + (right-left)/2
	mergeSort(arr, left, mid)
	mergeSort(arr, mid+1, right)
	mergeArr(arr, left, mid, right)
}

func mergeArr(arr []int, left, mid, right int) {
	temp := make([]int, right-left+1)
	i, j, k := left, mid+1, 0

	for i <= mid && j <= right {
		if arr[i] <= arr[j] {
			temp[k] = arr[i]
			i++
		} else {
			temp[k] = arr[j]
			j++
		}
		k++
	}

	for i <= mid {
		temp[k] = arr[i]
		i++
		k++
	}

	for j <= right {
		temp[k] = arr[j]
		j++
		k++
	}

	for i := 0; i < len(temp); i++ {
		arr[left+i] = temp[i]
	}
}
