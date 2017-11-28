package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSum {
    /*
    3sum，3个数相加为0
        算法：
        先排序，小到大
        一次for循环，i从前往后走，设置j=i+1 为i的下一位，k=length-1 为最后一位， j，k两个指针，如果nums[i]+nums[j]+nums[k]==0 j往后走，k往前走，则输入到list中，否则 如果>0 前面的j 往后移一位，如果<0,后面的k往前移一位，
        去除重复数据,即重复数据只用一次：
        在for循环里面 判断，如果if(i==0 || nums[i] > nums[i-1])
        {执行，如果i和前一个一样跳过，找到合围0的数时，判断j，k和下一个如果一样，跳过
    */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if(nums == null || nums.length<3)
            return result;

        Arrays.sort(nums);

        for(int i=0; i<nums.length-2; i++){
            if(i==0 || nums[i] > nums[i-1]){
                int j=i+1;
                int k=nums.length-1;

                while(j<k){
                    if(nums[i]+nums[j]+nums[k]==0){
                        List<Integer> l = new ArrayList<Integer>();
                        l.add(nums[i]);
                        l.add(nums[j]);
                        l.add(nums[k]);
                        result.add(l);

                        j++;
                        k--;

                        //handle duplicate here
                        while(j<k && nums[j]==nums[j-1])
                            j++;
                        while(j<k && nums[k]==nums[k+1])
                            k--;

                    }else if(nums[i]+nums[j]+nums[k]<0){
                        j++;
                    }else{
                        k--;
                    }
                }
            }

        }

        return result;
    }
    @Test
    public void test(){
        int[] nums = {1,2,3,1,0,-1,-2,-1,-3,-4,-5,6,2,4,6,8,5,4,2,-1,3,-6,-4,-5,0};
        System.out.println(Arrays.toString(nums) );
    }
}
