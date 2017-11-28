import java.util.HashMap;
import java.util.Map;

/**
 * 要求：4个数组，每个数组重的一个数 组合相加是固定的数target 列出所有的组合
 */
public class fourSum2 {
    public int fourSum(int[] a,int[] b,int[] c,int[] d ,Integer target){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<a.length;i++){
            for(int j=0;j<b.length;j++){
                map.put(a[i]+b[j],map.getOrDefault(a[i]+b[j] , 0)+1);
            }
        }
        //第一次双循环 把 和 及 和的次数存入
        int result=0;
        for(int m =0;m<c.length;m++){
            for(int n = 0;n<d.length;n++){
                result += map.getOrDefault( target - (c[m]+d[n]) ,0);
            }
        }
        //第二次双循环，如果有取出重复的次数 加入result
        return result;
    }
}
