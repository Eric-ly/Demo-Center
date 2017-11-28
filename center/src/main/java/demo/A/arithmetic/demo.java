package demo.A.arithmetic;

import javax.servlet.http.HttpServlet;

public class demo
{


//	非递归实现斐波那次序列，第三项等于前两项之和，
	public double Fibonacci(int n){
		int[] result={0,1};
		if(n<2){
			return result[n];
		}
		double FibONE=1;
		double FibTWO=0;
		double FibN=0;
		for(int i=2;i<=n;i++){
			FibN = FibONE+FibTWO;
			FibTWO=FibONE;
			FibONE=FibN;
		}
		HttpServlet servlet;
		return FibN;
		
	}
//	替换字符串中的空格为%20
//	（1）是否需要新建字符数组，如果之前的字符数组够大的话
//	（2）在同一个字符数组上如果从头到尾替换 后面的 一致会往后移，即 o（n2）
//	（3）新位置指针和 老位置指针，读取
	
}

