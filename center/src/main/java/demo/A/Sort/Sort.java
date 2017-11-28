package demo.A.Sort;


import java.util.Arrays;


public class Sort
{
	public static void main(String[] args)
	{
		int[] number = {10,3,6,544,4,20,77,46,908,402,74,123,95,88,6,5,444,3234,3425,67,45,234,234,25,7,789,123,13,23,243};
//		sort(number);
//		System.out.println("bubble    "+Arrays.toString(bubbleSortUp(number)));
//		System.out.println("select    "+Arrays.toString(SelectSort(number)));
//		System.out.println("insert    "+Arrays.toString(InsertSort(number)));
//		System.out.println("qsort     "+Arrays.toString(QSort(number,0,number.length-1)));
		System.out.println("mergeSort "+Arrays.toString(MergeSort(number)));
//		System.out.println("headSort  "+Arrays.toString(HeapSort(number)));
//		System.out.println("shellSort "+Arrays.toString(shellsort(number)));
	}
	 /*
	 * 冒泡排序
	 * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。  
	 * 时间复杂度o(n2) 改进后o(n)-o(n2)
	 */
	public static int[] bubbleSort(int[] numbers)
	{
	    int temp = 0;
	    int size = numbers.length;
	    for(int i = 0 ; i < size-1; i ++)
	    {
	   	 for(int j = 0 ;j < size-1-i ; j++)
	   	 { }
	    }
	    return numbers;
	}
//	改进，加一个 flag,设为true，每次循环都是false，如果有改动设为true，判断如果上一次没有改动，说明都排好序了，则结束循环
	public static int[] bubbleSortUp(int[] numbers)
	{
	    int temp = 0;
	    boolean flag = true;
	    for(int i = 0 ; i < numbers.length-1 && flag ; i ++)
	    {
	   	 flag=false;
	   	 for(int j = numbers.length-1-1 ;j >=0  ; j--)
	   	 {
	   		 if(numbers[j] > numbers[j+1])  //交换两数位置
	   		 {
	   			 temp = numbers[j];
	   			 numbers[j] = numbers[j+1];
	   			 numbers[j+1] = temp;
	   			 flag=true;
	   		 }
	   	 }
	    }
	    return numbers;
	}
//	    选择排序，第一层循环 选中第一个元素为i 为哨兵min，第二层循环为i+1，第二层元素每一个与min比较
//	如果比min的元素还小，就把i+1赋给min，选出最小的和 i交换，然后把第二个元素设为哨兵，一次循环
//	时间复杂度o(n2)
	public static int[] SelectSort(int[] numbers){
		int min;
		int temp=0;
		for(int i=0;i<numbers.length-1;i++){
			min=i;
			for(int j=i+1;j<=numbers.length-1;j++){
				if(numbers[min]>numbers[j]){
					min=j;
				}
			}
			if(i!=min){
  			 temp = numbers[i];
  			 numbers[i] = numbers[min];
  			 numbers[min] = temp;
			}
		}
		return numbers;
	}
//	直接插入排序，把一个元素插入到已经排好序的有序表中，需要设置哨兵
//	时间复杂度o(n2)
	public static int[] InsertSort(int[] numbers){
		int temp;
		int j;
		for(int i=1;i<numbers.length;i++){//从第二个元素开始,每个元素，所以是<=
			if(numbers[i] < numbers[i-1]){
				temp=numbers[i];
				for(j=i-1;j>=0&&numbers[j]>temp;j--){//注意 这里必须j>=0在前面，因为最后一个在-- 会<0 数组越界
					numbers[j+1]=numbers[j];
				}
				numbers[j+1]=temp;
			}
		}
		return numbers;
	}
/**	快速排序：挖坑，填坑，选基准数，从右边选比他小的，从左边选比他大的，直到相等，左右分区递归直到只有一个
 * 实现：while 大的比哨兵大跳过，否则交换，小的比哨兵小跳过，否则交换。取第一个为哨兵
 * 时间复杂度o(nlogn)
 * 优化：三数取中，low，high，mid比较大小，比较三次（小大，大中，中小保证左边小）把中间的值和[low]交换.
 * int m =low + (high-low)/2
	**/
	public static int[] QSort(int[] num,int low,int high){
		int p;
		int l = low;
		int h = high;
		if(low<high){
			p=num[low];
			while(low<high){
				while(low<high&&num[high]>=p){	
					high--;		
				}
				num[low]=num[high];
				while(low<high&&num[low]<=p){
					low++;
				}
				num[high]=num[low];
			}
			num[low]=p;
			QSort(num,l,low-1);
			QSort(num, low+1, h);
		}
		return num;
	}
/**
 *归并排序：把两个或以上的有序表 合成一个表
 *用递归！这样递归下去，合并上来就是归并排序。
 *两个有序序列合并：从比较二个数列的第一个数，谁小就先取谁，取了后就在对应数列中删除这个数。然后再进行比较，
 *如果有数列为空，那直接将另一个数列的数据依次取出即可。 
 *先分成只有一个元素，再合并
 *
 *代码：只需要num，和temp两个数组，sort 递归是为了获取index，然后把source 数组的输出到temp整理后在source数组上更新
 *改进：已改进，有的在merge中建立临时的数组，这样代价比较大，此处在最上层地柜前建立数组，下面所有的递归都用一个
 */
	public static int[] MergeSort(int[] num){
		int[] temp=new int[num.length];
		MSort(num,0,num.length-1,temp);
		return num;
	}
	public static void MSort(int[] num ,int first , int last , int[] temp)
	{
//		if(first>=last){
//			return;
//		}
		if(first<last){
			int mid=(first+last)/2;
			MSort(num, first, mid ,temp);
			MSort(num, mid+1, last, temp);
			MergeArray(num,first,mid,last,temp);
		}
	}
	public static void MergeArray(int[] num , int first ,int mid ,int last,int[] temp){
		int i=first;
		int j=mid+1;
		int k=0;
		while(i<=mid && j<=last){
			if(num[i]<=num[j]){
				System.out.println(num[i]+"---"+num[j]+temp[k]);
				temp[k++]=num[i++];
			}
			else{
				temp[k++]=num[j++];
			}
		}
		while(i<=mid){
			temp[k++]=num[i++];
		}
		while(j<=last){
			temp[k++]=num[j++];
		}
//		System.out.println("test---"+Arrays.toString(num)+"--"
//				+ "--"+Arrays.toString(temp));

		for(int n=0;n<k;n++){
			num[first+n]=temp[n];
		}
		
	}
	/**
	 * 堆排序：
	 * 把要排序的数组构建一个大顶堆，然后取出堆顶元素放到最后，剩下的元素重新构成一个大顶堆
	 * 时间复杂度：O(N*logN)
	 * 二叉堆是完全二叉树或者是近似完全二叉树
	 * 二叉堆满足二个特性：

在堆里堆元素操作的 时间复杂度 是 logk，k为堆堆大小

1．父结点的键值总是大于或等于（小于或等于）任何一个子节点的键值。

2．每个结点的左子树和右子树都是一个二叉堆（都是最大堆或最小堆）。
堆的存储

一般都用数组来表示堆，i结点的父结点下标就为(i – 1) / 2。它的左右子结点下标分别为2 * i + 1和2 * i + 2。
如第0个结点左右子结点下标分别为1和2。
堆的插入：数组最后
对的删除：第一个元素，用最后一个元素替代

	 * @param numbers
	 */
	public static int[] HeapSort(int[] num){
		int i,temp;
		for(i=num.length/2-1 ; i>=0 ;i--){//因为另一半都是叶子结点
			HeapAdjust(num,i, num.length);
		}
		for(i=num.length-1 ; i > 0 ; i--){//从第二个元素到最后一个元素
			temp=num[i];
			num[i]=num[0];
			num[0]=temp;
			HeapAdjust(num, 0, i);//把减去1个之后的数组继续建立大顶堆
		}
		return num;
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
/**
 * 希尔排序
 * 分组插入排序，先将整个待排元素序列分割成若干个子序列分别进行直接插入排序
 * 待整个序列中的元素基本有序（增量足够小）时，再对全体元素进行一次直接插入排序
 * 
 * @param numbers
 */
	public static int[] shellsort(int[] a)
	{
		int j, gap;
		int n=a.length;
		
		for (gap = n / 2; gap > 0; gap /= 2)
			for (j = gap; j < n; j++)//从数组第gap个元素开始
				if (a[j] < a[j - gap])//每个元素与自己组内的数据进行直接插入排序
				{
					int temp = a[j];
					int k = j - gap;
					while (k >= 0 && a[k] > temp)
					{
						a[k + gap] = a[k];
						k -= gap;
					}
					a[k + gap] = temp;
				}
		return a;
	}
	
	
	public static void sort(int[] numbers){
		int size=numbers.length;
		int temp=0;
		for(int i=0;i<numbers.length-1;i++){
			for(int j=0; j<numbers.length-1-i;j++){
				if(numbers[j] > numbers[j+1]){
					temp =numbers[j];
					numbers[j]=numbers[j+1];
					numbers[j+1]=temp;
				}
			}
		}
		System.out.println(Arrays.toString(numbers));
	}

}
