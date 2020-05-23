package Hackerrank;

import java.util.Scanner;

public class HeightOfTree {
    public static int height(Node root){
        return maxDepth(root) - 1;
    }

    /**
     * Since the height of the tree start of 0. Max height will be maxDepth - 1
     * @param root
     * @return
     */
    public static int maxDepth(Node root){
        if(root == null) {
            return 0;
        }
        else {
            int left_height = height(root.left);
            int right_height = height(root.right);
            return 1 + Math.max(left_height, right_height);
        }
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }

}
