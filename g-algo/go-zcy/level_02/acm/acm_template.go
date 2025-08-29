package acm

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

	for i := 0; i < n; i++ {
		fmt.Fprint(writer, arr[i], " ")
	}

	fmt.Fprintln(writer)

}
