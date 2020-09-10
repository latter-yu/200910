import java.util.*;

public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int num = 0; num < 1000; num++) {
            int cur = num;
            int[] arr = new int[5];
            int i = 0;
            while (cur > 9) {
                arr[i] = cur % 10;
                cur /= 10;
                i++;
            }
            arr[i] = cur;
            int sum = 0;
            for (int j = 0; j < arr.length; j++) {
                int bound = arr[j] * arr[j] * arr[j];
                sum += bound;
            }
            if (num == sum) {
                list.add(sum);
            }
        }
        for (int l : list) {
            System.out.println(list);
        }
    }

    public int GetNumberOfK(int [] array , int k) {
        int i = 0;
        int count = 0;
        while (i < array.length) {
            if (array[i] == k) {
                count++;
            }
            if (array[i] > k) {
                break;
            }
            if (i < array.length) {
                i++;
            } else {
                break;
            }
        }
        return count;
    }

    public static int MoreThanHalfNum_Solution(int[] array) {
        // 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
        // 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。

        int len = array.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (!map.containsKey(array[i])) {
                map.put(array[i], 1);
            } else {
                map.put(array[i], map.get(array[i]) + 1);
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            if ((Integer)entry.getValue() > (len / 2)) {
                return (Integer) entry.getKey();
            }
        }
        return  0;
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}

class Main {
    public int TreeDepth(TreeNode root) {
        int depth = 0;
        if (root != null) {
            Queue q = new LinkedList<TreeNode>();
            q.offer(root);
            q.offer(new TreeNode(Integer.MIN_VALUE));
            while (!q.isEmpty()) {
                TreeNode tmp = (TreeNode) q.poll();
                if (tmp.val != Integer.MIN_VALUE) {
                    if (tmp.left != null)
                        q.offer(tmp.left);
                    if (tmp.right != null)
                        q.offer(tmp.right);
                } else {
                    // 当遇到特殊节点时，说明当前层已经遍历完了同时下一层的所有节点已经全部入队了，在每层的最后压入一个特殊节点
                    depth++;
                    if (!q.isEmpty()) {
                        // 重点，不然会死循环
                        q.offer(new TreeNode(Integer.MIN_VALUE));
                    }
                }
            }
        }
        return depth;
    }
}
