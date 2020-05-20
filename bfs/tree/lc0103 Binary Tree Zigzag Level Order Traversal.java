// 1ms 97.76%
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<List<Integer>> results = new ArrayList();
        if(root == null) return results;
        LinkedList<TreeNode> layer = new LinkedList();
        layer.offerLast(root);
        boolean odd = true;
        while(!layer.isEmpty()){
            LinkedList next = new LinkedList();
//            ArrayList<Integer> arr = new ArrayList();
//             while(!layer.isEmpty()){
//                 if(odd){
//                     TreeNode n = layer.pollFirst();
//                     if(n.left != null) next.offerLast(n.left);
//                     if(n.right != null) next.offerLast(n.right);
//                     arr.add(n.val);
//                 }
//                 else{
//                     TreeNode n = layer.pollLast();
//                     if(n.right != null) next.offerFirst(n.right);
//                     if(n.left != null) next.offerFirst(n.left);
//                     arr.add(n.val);
//                 }
            //此处按照模板格式进行套写，因为只需要将结果数组中的数字进行reverse，所以还可以采用for(TreeNode n: layer）的方式进行遍历
            //这样避免了next中添加元素时候，正反两项需要注意放入n.left与n.right顺序的问题，不过这里需要将arr设置成LinkedList
               LinkedList<Integer> arr = new LinkedList();
               for(TreeNode n: layer){
                   if(odd){
                       arr.offerLast(n.val);        //奇数行就放在最后
                   }else{
                       arr.offerFirst(n.val);       //偶数行就放在前面，顺序就是倒置了
                   }
                   //将节点的子节点依次放入next链表中
                   if(n.left!=null) next.offerLast(n.left);
                   if(n.right!=null) next.offerLast(n.right);
               }
            odd = !odd;
            results.add(arr);
            layer = next;
        }
        return results;
    }
}
