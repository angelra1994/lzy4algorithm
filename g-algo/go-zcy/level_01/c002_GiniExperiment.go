package main

import (
	"fmt"
	"math"
	"math/rand"
	"sort"
)

/**
  一开始有100个人，每个人都有100元
  在每一轮都做如下的事情 :
  每个人都必须拿出1元钱给除自己以外的其他人，给谁完全随机
  如果某个人在这一轮的钱数为0，那么他可以不给，但是可以接收
  发生很多很多轮之后，这100人的社会财富分布很均匀吗？
*/

func main() {
	fmt.Println("一个社会的基尼系数是一个在0~1之间的小数")
	fmt.Println("基尼系数为0代表所有人的财富完全一样")
	fmt.Println("基尼系数为1代表有1个人掌握了全社会的财富")
	fmt.Println("基尼系数越小，代表社会财富分布越均衡；越大则代表财富分布越不均衡")
	fmt.Println("在2022年，世界各国的平均基尼系数为0.44")
	fmt.Println("目前普遍认为，当基尼系数到达 0.5 时")
	fmt.Println("就意味着社会贫富差距非常大，分布非常不均匀")
	fmt.Println("社会可能会因此陷入危机，比如大量的犯罪或者经历社会动荡")
	fmt.Println("测试开始")
	var n, t = 100, 100000
	fmt.Println("人数：", n)
	fmt.Println("轮数：", t)
	experiment(n, t)
	fmt.Println("测试结束")
}
func experiment(n, t int) {
	wealth := make([]float64, n)
	// 每个人给100块钱
	for i := 0; i < n; i++ {
		wealth[i] = 100
	}
	hasMoney := make([]bool, n)
	for i := 0; i < t; i++ {
		// 每次实验开始前，重置 hasMoney 数组
		for j := range n {
			hasMoney[j] = wealth[j] > 0
		}
		for j := 0; j < n; j++ {
			if hasMoney[j] {
				var other int
				for {
					other = rand.Intn(n)
					if j != other {
						break
					}
				}
				// j 给 other 1块钱
				wealth[j] -= 1
				wealth[other] += 1
			}
		}
	}
	sort.Float64s(wealth)
	fmt.Println("列出每个人的财富(贫穷到富有) : ", wealth)
	fmt.Println("这个社会的基尼系数为 : ", calculateGini(wealth))
}

/**
 * 计算基尼系数
 * 差值总和 / 2 * 个体总数 * 财富值总和
 */
func calculateGini(wealth []float64) float64 {
	var sumOfAbsDiff, sumOfWealth float64
	sumOfAbsDiff = 0
	sumOfWealth = 0
	for i := 0; i < len(wealth); i++ {
		sumOfWealth += wealth[i]
		for j := 0; j < len(wealth); j++ {
			sumOfAbsDiff += math.Abs(wealth[i] - wealth[j])
		}
	}
	return sumOfAbsDiff / (2 * float64(len(wealth)) * sumOfWealth)
}
