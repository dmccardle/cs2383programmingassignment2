/**
 * CheckBST checks if a binary tree is a binary search tree
 */
public class CheckBST {

    private static class Node {
        public int data;
        public Node left;
        public Node right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        /* Tree 1: a BST */
        Node root = new Node(13);

        Node node2 = new Node(10);
        Node node4 = new Node(12);

        Node node3 = new Node(19);
        Node node5 = new Node(15);
        Node node6 = new Node(14);
        Node node7 = new Node(18);

        root.left = node2;
        root.right = node3;

        node2.right = node4;

        node3.left = node5;

        node5.left = node6;
        node5.right = node7;

        String msg = isBST(root) ? "" : "not ";
        System.out.println("Tree 1 is " + msg + "a binary search tree.");

        /* Tree 2: NOT a BST */
        Node root2 = new Node(12);

        Node n2 = new Node(10);
        Node n4 = new Node(13);

        Node n3 = new Node(19);
        Node n5 = new Node(15);
        Node n6 = new Node(14);
        Node n7 = new Node(18);

        root2.left = n2;
        root2.right = n3;

        n2.right = n4;

        n3.left = n5;

        n5.left = n6;
        n5.right = n7;

        String msg2 = isBST(root2) ? "" : "not ";
        System.out.println("Tree 2 is " + msg2 + "a binary search tree.");


    }

    public static boolean isBST(Node root)  { 
        // start off comparing against arbitrary large and small values
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE); 
    } 

    public static boolean checkBST(Node node, int min, int max) 
    { 
        // is a BST if it is empty
        if (node == null) {
            return true;
        }
  
        // if the node is smaller than the min (right subtree)
        // or larger than the max (left subtree)
        // it violates BST conditions
        if (node.data < min || node.data > max) {
            return false;
        } 
  
        // otherwise, check the subtrees on the current node
        // checks if anything on the left is bigger than the current node, or if anything on the right is smaller than the current node
        return checkBST(node.left, min, node.data-1) && checkBST(node.right, node.data+1, max); 
    }
}