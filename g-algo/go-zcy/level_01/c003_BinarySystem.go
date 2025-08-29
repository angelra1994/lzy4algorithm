package main

import (
	"fmt"
	"math"
)

/**
本文件的实现是用int来举例的
对于long类型完全同理
不过要注意，如果是long类型的数字num，有64位
num & (1 << 48)，这种写法不对
因为1是一个int类型，只有32位，所以(1 << 48)早就溢出了，所以无意义
应该写成 : num & (1L << 48)
*/

func printBinary(num int) {
	fmt.Printf("%b -> %d\n", num, num)
}
func printBinary32(num int32) {
	for i := 31; i >= 0; i-- {
		if num&(1<<i) == 0 {
			fmt.Print("0")
		} else {
			fmt.Print("1")
		}
	}
	fmt.Println(" ->", num)
}

func main() {
	var a int = 78
	printBinary(a)
	printBinary32(int32(a))
	fmt.Println("===a===")

	b := -6
	printBinary(b)
	printBinary32(int32(b))
	fmt.Println("===b===")

	c := 0b1001110
	fmt.Println(c)
	printBinary32(int32(c))
	fmt.Println("===c===")

	d := 0x4e
	fmt.Println(d)
	printBinary(d)
	printBinary32(int32(d))
	fmt.Println("===d===")

	// ^a 将a中的所有位按位取反，效果同 java 中的 ~a
	fmt.Println(^a)
	printBinary(^a)
	// 相反数， 取反后再 + 1 或者 先-1再取反
	printBinary32(int32(^a + 1))
	printBinary(^a + 1)
	printBinary(^(a - 1))
	printBinary(a)

	// go 中的 int类型和平台有关，go中的int32和java中的int是类似的标准4个字节
	var f int32 = math.MinInt32
	fmt.Println(f)
	printBinary(int(f))
	fmt.Printf("%T, %T\n", f, int(f))
	fmt.Println(-f)
	fmt.Println(^f)
	fmt.Println("===a1===")

	// | & ^
	var g int32 = 0b0001010
	var h int32 = 0b0001100
	printBinary32(g | h)
	printBinary32(g & h)
	printBinary32(g ^ h)
	fmt.Println("===g,h===")

	// go 中只有 >> 带符号右移。uint的最大值确定 int是int32 还是 int64
	//fmt.Println(^uint(0), ^uint(0)>>63)
	//fmt.Println(^uint(0) >> 64)
	//fmt.Println(^uint(0) >> 31)
	//fmt.Println(^uint(0) >> 32)
	//
	//fmt.Println(^uint32(0), ^uint32(0)>>63)
	//fmt.Println(^uint32(0) >> 64)
	//fmt.Println(^uint32(0) >> 31)
	//fmt.Println(^uint32(0) >> 32)
	//
	//fmt.Println(^int32(0), ^int32(0)>>63)
	//fmt.Println(^int32(0) >> 64)
	//fmt.Println(^int32(0) >> 31)
	//fmt.Println(^int32(0) >> 32)
	fmt.Printf("%p %p %p\n", &f, &g, &h)

	// ||, &&, !。go中的逻辑运算，不支持 | 和 &。只有短路运算。| 和 & 是位运算
	test1 := returnTrue() || returnFalse()
	fmt.Println("test1:", test1)
	test2 := returnTrue() && returnFalse()
	fmt.Println("test1:", test2)
	fmt.Println("===||,&&===")

	// <<,>> go中只有左移，右移。没有类似java的 >>> 无符号的右移
	var i int32 = 0b0011010
	printBinary32(i)
	printBinary32(i >> 2)
	printBinary32(i << 1)
	j := 0b1111_0000_0000_0000_0000_0000_0000_0000
	fmt.Println(j, int32(j), 1<<32-j)
	printBinary32(int32(j) << 2)
	printBinary32(int32(j))
	printBinary32(int32(j) >> 1)
	printBinary32(int32(j) >> 2)
	printBinary32(int32(j) >> 3)
	printBinary32(int32(j) >> 30)
	printBinary32(int32(j) >> 31)
	printBinary32(int32(j) >> 32)
	printBinary32(int32(j) >> 33)

	fmt.Println("===-1===")
	printBinary32(int32(-1 << 1))
	printBinary(-1 << 1)
	printBinary32(int32(-1 >> 1))
	printBinary(-1 >> 1)
	fmt.Println("===math.MinInt32===")
	printBinary32(int32(math.MinInt32 >> 1))
	printBinary(math.MinInt32 << 1)
	// 非负数 >> i，等同于除以2的i次方, 非负数 << i，等同于乘以2的i次方。负数不满足如上规律

}

func returnTrue() bool {
	fmt.Println("enter returnTrue")
	return true
}
func returnFalse() bool {
	fmt.Println("enter returnFalse")
	return false
}
