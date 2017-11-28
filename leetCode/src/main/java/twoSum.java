import java.util.HashMap;
import java.util.Map;

/*用一个map存储，有空间复杂度，时间复杂度o(n)
* */
public class twoSum {
    public static void main(String args[]){
        int[] data = {2, 7, 11, 15};

        int[] result = twoSumdemo(data,9);
        System.out.println(result[0]+","+result[1]);
    }

    public static int[] twoSumdemo(int[] nums, int target) {
        Map<Integer ,Integer> tempMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            Integer index = tempMap.get( target - nums[i]);
            if( index == null ){
                tempMap.put(nums[i],i);
            }else {
                return new int[]{i,index};
            }
        }
        return new int[2];
    }
}

