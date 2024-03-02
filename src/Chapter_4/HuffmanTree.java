package Chapter_4;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 功能描述
 *
 * @author 古月
 * @date 2023/11/07  20:12
 */
public class HuffmanTree {
    //定义节点
    public static class TreeNode implements Comparable<TreeNode>{
        char data;
        int weight;
        boolean isLeaf;
        TreeNode left, right;

        TreeNode(char data, int weight){
            this.data = data;
            this.weight = weight;
            this.isLeaf = true;
        }
        //非叶节点
        TreeNode(int weight, TreeNode left, TreeNode right) {
            this.weight = weight;
            this.left = left;
            this.right = right;
            this.isLeaf = false;
        }

        @Override
        //用于确定优先级队列中元素的顺序
        public int compareTo(TreeNode o) {
            return this.weight - o.weight;
        }
    }
    //实现哈夫曼树
    public static TreeNode humanTree(Map<Character, Integer> f) {
        //创建优先级队列并添加所有元素
        PriorityQueue<TreeNode> queue = new PriorityQueue<>();
        for (Character c :
                f.keySet()) {
            queue.add(new TreeNode(c, f.get(c)));
        }
        //选取weight最小的两个节点，合并后放回
        while (queue.size() > 1) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            queue.add(new TreeNode(left.weight + right.weight, left, right));
        }
        return queue.poll();
    }

    //递归实现编码
    public static void encode(TreeNode node, String encoding, HashMap<Character, String> encodingChar) {
        //如果是叶节点，放入字符和编码
        if (node.isLeaf) {
            encodingChar.put(node.data, encoding);
            return;
        }
        encode(node.left, encoding + "0", encodingChar);
        encode(node.right, encoding + "1", encodingChar);
    }

    public static void main(String[] args) {
        Map<Character, Integer> f = new HashMap<>();
        f.put('a', 45);
        f.put('b', 13);
        f.put('c', 12);
        f.put('d', 16);
        f.put('e', 9);
        f.put('f', 5);
        TreeNode root = humanTree(f);
        HashMap<Character, String> encodingChar = new HashMap<>();
        encode(root, "", encodingChar);

        for (Character c:
             encodingChar.keySet()) {
            System.out.println(c+":"+encodingChar.get(c));
        }
    }
}
