package demo.A.arithmetic;

/**
 * 输入n个整数，找出其中最小的k个整数，找出其中最小的k个数。
 * 例如输入4，5，1，6，2，7，3，8这8个数字，则最小的4个数字为1，2，3，4
 */

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Stack;

public class k {
	//新建大顶堆
	public void buildMaxHeap(int[] arr,int lastIndex){
		for(int i = (lastIndex-1)/2;i>=0;i--){
			int k = i;
			while(2*k+1 <= lastIndex){
				int biggerIndex = 2*k+1;
				if(biggerIndex <lastIndex){
					if(arr[biggerIndex]< arr[biggerIndex+1])
						biggerIndex++;
				}
				if(arr[k] < arr[biggerIndex]){
					swap(arr,k,biggerIndex);
					k = biggerIndex;
				}
				else
					break;
			}
		}
	}
	public static void swap(int[] arr,int i ,int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
//		HttpSession session ;
//		HttpServletRequest request;
//		session=request.getSession();
	}
	
	public void heapSort(int[] arr){
		for(int i = 0;i<arr.length-1;i++){
			buildMaxHeap(arr,arr.length-i-1);
			swap(arr,0,arr.length-i-1);
		}
	}
	
	public void getLeastNumbers(int[] arr,int k){
		if(arr == null || k<0 || k>arr.length)
			return;
		//  根据输入数组前k个数简历最大堆
		//  从   k+1  个数开始与根节点比较
		//  大于根节点   ，   舍去
		//  小于    ，   取代根节点 ， 重建最大堆
		int[] kArray = Arrays.copyOfRange(arr, 0, k);
		heapSort(kArray);
		for(int i = k;i<arr.length;i++){
			if(arr[i]<kArray[k-1]){
				kArray[k-1] = arr[i];
				heapSort(kArray);
			}
		}
		for(int i:kArray)
			System.out.print(i);
	}
	public static void main(String[] args){
		int[] arr= {4,5,1,6,2,7,3,8};
//		k test = new k();
//		test.getLeastNumbers(arr, 3);
		GetTopNums(arr, 3);
	}
	public static void GetTopNums(int[] a ,int k){
		int i,temp;
		if(a.length<k || k<1){
			return;
		}
		int[] b=Arrays.copyOfRange(a, 0,k);
		for(i=k/2-1 ; i>=0 ;i--){//因为另一半都是叶子结点
			HeapAdjust(b,i, k);
		}
		for(int j=k;j<a.length;j++){
			if(a[j]<b[0]){
				b[0]=a[j];
				HeapAdjust(b, 0, k);
			}
		}
		System.out.print(Arrays.toString(b));
		Stack<Integer> integers=new Stack<Integer>();
		integers.peek();
	}
//	把 num[s]-num[m]变成一个大顶堆-----把s点 作为大顶堆 缕顺
// 从s节点开始调整,m为节点总数 ，注意m为节点的总数，不是最后一个元素的位置，因为j<m 判断，决定了是个数
	public static void HeapAdjust(int[] num, int s , int m){
		int temp=num[s];
		int j;
		for(j=2*s+1; j < m ; j=2*j+1 )//从0开始计算 i节点的子节点为 2*i+1, 2*i+2  
		{
			if(j+1 < m && num[j]<num[j+1]){
				j++;							//比较左右子树哪个大，j指向大的节点
			}
			if(temp >= num[j]){//如果s比最大的子树大，替换
				break;
			}
			num[s]=num[j];
			s=j;
		}
		num[s]=temp;//吧最开始的s 放到空位上
	}
}


