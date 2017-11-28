package demo.A.arithmetic;

public class tree
{

}
/**
 * 
public class Solution {
   List<Integer> result = new ArrayList<Integer>();

   public List<Integer> inorderTraversal(TreeNode root) {
       if(root !=null){
           helper(root);
       }

       return result;
   }

   public void helper(TreeNode p){
       if(p.left!=null)
           helper(p.left);

       result.add(p.val);

       if(p.right!=null)
           helper(p.right);
   }
}

非递归：
先序遍历：

public class TreeNode {
   int val;
   TreeNode left;
   TreeNode right;
   TreeNode(int x) { val = x; }
}

public class Solution {
   public ArrayList<Integer> preorderTraversal(TreeNode root) {
       ArrayList<Integer> returnList = new ArrayList<Integer>();

       if(root == null)
           return returnList;

       Stack<TreeNode> stack = new Stack<TreeNode>();
       stack.push(root);

       while(!stack.empty()){
           TreeNode n = stack.pop();
           returnList.add(n.val);

           if(n.right != null){
               stack.push(n.right);
           }
           if(n.left != null){
               stack.push(n.left);
           }

       }
       return returnList;
   }
}
中序遍历：

//Definition for binary tree
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
   public ArrayList<Integer> inorderTraversal(TreeNode root) {
       // IMPORTANT: Please reset any member data you declared, as
       // the same Solution instance will be reused for each test case.
        ArrayList<Integer> lst = new ArrayList<Integer>();

       if(root == null)
           return lst; 

       Stack<TreeNode> stack = new Stack<TreeNode>();
       //define a pointer to track nodes
       TreeNode p = root;

       while(!stack.empty() || p != null){

           // if it is not null, push to stack
           //and go down the tree to left
           if(p != null){
               stack.push(p);
               p = p.left;

           // if no left child
           // pop stack, process the node
           // then let p point to the right
           }else{
               TreeNode t = stack.pop();
               lst.add(t.val);
               p = t.right;
           }
       }
       return lst;
   }
}
//后序遍历
 * 用stack
 public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<Integer>();
 
    if(root==null) {
        return res;
    }
 
    Stack<TreeNode> stack = new Stack<TreeNode>();
    stack.push(root);
 
    while(!stack.isEmpty()) {
        TreeNode temp = stack.peek();
        if(temp.left==null && temp.right==null) {
            TreeNode pop = stack.pop();
            res.add(pop.val);
        }
        else {
            if(temp.right!=null) {
                stack.push(temp.right);
                temp.right = null;
            }
 
            if(temp.left!=null) {
                stack.push(temp.left);
                temp.left = null;
            }
        }
    }
 
    return res;
    
    public class CQueue {

    private StackM stack1,stack2;

    public CQueue(){
        stack1 = new StackM(10);
        stack2 = new StackM(10);
    }
    //元素入列
    public void appendTail(long elem){
        if(stack1.isFull()){
            System.out.println("已经满栈了");
        }else{
            stack1.push(elem);
            System.out.println(elem+"入列了");
        }

    }
    //元素出列
    public long deletedHead(){
        //若stack2为空，则stack1中元素弹出压入stack2中
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                long elem = stack1.pop();
                System.out.println(elem+"入Stack2");
                stack2.push(elem);  
            }
        }
        //执行完以上操作后，stack2依然为空则返回-1代表空栈
        if(stack2.isEmpty()){
            return -1;
        }else{
            return stack2.pop();    
        }       
    }

    public boolean isQueueEmpty(){
        return stack2.isEmpty()&&stack1.isEmpty();
    }
}
  
  
  
  
 */

