package BinarySearchTree;


/*
 * Created by aolie on 2017/4/15.
 */
public class BinarySearchTree {

    //迭代的方式插入；
     public TreeNode insert1(int data,TreeNode root) {
         TreeNode insertNode = new TreeNode(data);
         if (root == null) {
             root = insertNode;
             return root;
         }//root是否为空 空则直接插入root根节点，
         else {
                TreeNode cur =root;
                while(true){
                    if(data<cur.val){
                        cur =cur.left;
                        if(cur==null) cur = insertNode;

                    }
                    else{

                        cur =cur.right;
                        if(cur==null) cur = insertNode;
                    }



                }

             }

         }
         //递归的方式来插入
         public TreeNode insert2(int data,TreeNode root){
                if(root==null) {
                    root = new TreeNode(data);
                    return root;
                }

                if(data<root.val) return insert2(data,root.left);

                if(data>root.val) return insert2(data,root.right);
                else ;
                return root;


         }

    /**
     *
     * @param key
     * @param root
     * @return 返回找到的节点
     */
         public TreeNode search(int key,TreeNode root){
             TreeNode res = root;
             if(key==root.val) return res;
             while(key!=res.val) {
                 if (key < root.val) {
                     res = res.left;

                 }
                 else{
                     res = res.right;
                 }
                 if(res==null) return null;//not find;the key is not in this bst;

             }
                return res;
         }

    /**
     * 找二叉查找树的最小值和最大值，最小值是最左孩子，最大值是最右孩子
     * @param root
     * @return
     */
    public TreeNode findmin(TreeNode root){
        if(root==null) return null;
        else if(root.left==null){ return root ;}
        return findmin(root.left);
    }
 public TreeNode finmax(TreeNode root){
      if(root==null) return null;
      else if(root.right==null) return root;
      else return  finmax(root.right);


 }


 public TreeNode remve(int key,TreeNode root){
     if(root==null) return root;
     if(key<root.val) root.left =  remve(key,root.left);
     else if(key>root.val) root.right= remve(key,root.right);
     else if(root.left!=null&&root.right!=null) {
         root.val = findmin(root.right).val;
         root.right = remve(root.val,root.right);


     }
     else
         root =(root.left==null)?root.right:root.left;
     return root;

 }

     }


