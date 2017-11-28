public class leetcode {
}
/*
题目：
Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

翻译：
实现一个atoi函数来把字符串转换为整型变量。

分析：
这道题的AC率只有13.4%，主要是因为对特殊情况的处理上。具体有这么几种情况需要考虑：
1. 前面的空格
2. 除去前面的空格后，可以以“+、-、0”开头，需要做对应的处理
3. 除了起始处可以出现前2种情况提到的非数字字符，其他地方一旦出现，则忽略该字符以及其后的字符
4. 考虑边界，即是否超出Integer.MAX_VALUE，Integer.MIN_VALUE。下面的方案采用long作为临时存储，方便做边界的判断。但是还要考虑是否会超出long的最大值，所以笔者采用length长度做初步判断。
 */
/*
public class Solution {
    public int myAtoi(String str) {
        char[] charArr=str.toCharArray();
        Long result=0L;
        int startIndex=0;
        boolean flag=true;//正数
        int length=0;
        for(int i=0;i<charArr.length;i++){
            if(startIndex==i){
                if(charArr[i]==' '){
                    startIndex++;
                    continue;
                }
                if(charArr[i]=='+'||charArr[i]=='0'){
                    continue;
                }
                if(charArr[i]=='-'){
                    flag=false;
                    continue;
                }
            }
            if(charArr[i]>='0'&&charArr[i]<='9'){
                result=result*10+charArr[i]-'0';
                length++;
                if(length>10){
                    break;
                }
            }else{
                break;
            }
        }
        if(flag){
            if(result>Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
        }else{
            result=-result;
            if(result<Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
        }
        return result.intValue();
    }
}*/


/*
* 题目：
Given a string containing just the characters , determine if the input string is valid.

The brackets must close in the correct order, “()” and “()[]{}” are all valid but “(]” and “([)]” are not.

翻译：
给定一个字符串，只包含’(‘, ‘)’, ‘{‘, ‘}’, ‘[’ 和’]’这些字符，检查它是否是“有效”的。
括号必须以正确的顺序关闭，例如”()” 和”()[]{}”都是有效的，”(]” 和”([)]”是无效的。

分析：
本题考查的是栈结构，具有后进先出的特性。有效包含2个方面，第一个是如果是关闭的括号，前一位一定要刚好有一个开启的括号；第二个是最终结果，需要把所有开启的括号都抵消完。一个比较容易出错的地方是，遇到关闭括号时，要先判断栈是否已经空了。

* */

/*
public class Solution {
    public boolean isValid(String s) {
        char[] charArr=s.toCharArray();
        List<Character> list=new ArrayList<>();
        for(Character c:charArr){
            if(c=='('||c=='{'||c=='['){
                list.add(c);
            }else{
                if(list.size()==0){
                    return false;
                }
                char last=list.get(list.size()-1);
                if(c==')'&&last!='('){
                    return false;
                }else if(c=='}'&&last!='{'){
                    return false;
                }else if(c==']'&&last!='['){
                    return false;
                }
                list.remove(list.size()-1);
            }
        }
        if(list.size()!=0){
            return false;
        }
        return true;
    }
}
 */


/*
题目：
Implement strStr().
Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

翻译：
实现一个方法strStr()。返回字符串needle第一次在字符串haystack出现的下标，如果needle不是haystack的一部分，就返回-1。

分析：
在文本中查找某个模式出现的位置的算法，称为字符串匹配算法。常用的方法有朴素字符串匹配算法、KMP算法等。朴素字符串匹配算法，就是把2个字符串头部对齐，然后逐一字符匹配，失配后，把needle右移一位，继续从头匹配。我们这里采用KMP算法。

代码：
 */
/*

public class Solution {

//     * 改进的Next指针算法

//     * @param s
//     * @return

private int[] getNext(String s) {
    int[] next = new int[s.length()];
    next[0] = 0;
    if (s.length() == 1) {
        return next;
    }
    next[1] = 0;
    int i = 1;
    int j = 0;
    while (i < s.length() - 1) {
        if (s.charAt(i) == s.charAt(j)) {
            j++;
            i++;
            if (s.charAt(i) == s.charAt(j)) {
                next[i] = next[j - 1];
            } else {
                next[i] = j;
            }
        } else {
            if (j == 0) {
                i++;
                next[i] = 0;
            } else {
                j = next[j];
            }
        }
    }
    return next;
}
//     * KMP字符串匹配算法

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        int[] next = getNext(needle);
        int index = -1;
        int i = 0;
        int j = 0;
        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                if (j == needle.length() - 1) {
                    return i - j;
                }
                i++;
                j++;
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = next[j];
                }
            }
        }
        return index;
    }
}

*/
  /*
贪心：
        http://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock/
        http://oj.leetcode.com/problems/jump-game/
        http://oj.leetcode.com/problems/jump-game-ii/
        http://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
        http://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
        http://oj.leetcode.com/problems/maximum-subarray/
        http://oj.leetcode.com/problems/minimum-window-substring/
        http://oj.leetcode.com/problems/maximal-rectangle/
        http://oj.leetcode.com/problems/longest-substring-without-repeating-characters/

        分治 & 递归：
        http://oj.leetcode.com/problems/unique-binary-search-trees-ii/
        http://oj.leetcode.com/problems/restore-ip-addresses/  （时间复杂度有限，递归满足）
        http://oj.leetcode.com/problems/permutations/
        http://oj.leetcode.com/problems/permutations-ii/
        http://oj.leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
        http://oj.leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
        http://oj.leetcode.com/problems/median-of-two-sorted-arrays/
        http://oj.leetcode.com/problems/validate-binary-search-tree/
*/
