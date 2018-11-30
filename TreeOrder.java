/**
 * TreeOrder
 */
public class TreeOrder {

    
    /**
     * Node
     */
    private static class Node {
        public int id;
        public int data;
        public int parent;
        public int left;
        public int right;

        public Node(int id, int data, int parent, int left, int right) {
            this.id = id;
            this.data = data;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
    }
    public static void main(String[] args) {
        /* tree structure:
        *
        *          ( root  )
        *       /            \
        *   node2           node3
        *        \           /
        *       node4    node5
        *               /     \
        *           node6    node7
        */
        
        
        Node root = new Node(1, 12, -1, 2, 3);
        Node node2 = new Node(2, 10, 1, -1, 4);
        Node node3 = new Node(3, 19, 1, 5, -1); 
        Node node4 = new Node(4, 13, 2, -1, -1); 
        Node node5 = new Node(5, 15, 3, 6, 7); 
        Node node6 = new Node(6, 14, 5, -1, -1); 
        Node node7 = new Node(7, 18, 5, -1, -1);
        Node[] nodes = { root, node2, node3, node4, node5, node6, node7 };
        
        System.out.print("Pre Order: ");
        preOrder(nodes, 0);
        System.out.println();

        System.out.print("In Order: ");
        inOrder(nodes, 0);
        System.out.println();

        System.out.print("Post Order: ");
        postOrder(nodes, 0);
        System.out.println();
    }

    public static void preOrder(Node[] nodes, int i) {
        /* node, left, right */
        if (i < nodes.length && i >= 0 && nodes[i] != null) {
            // node
            System.out.print(nodes[i].data + " ");
            // left
            preOrder(nodes, nodes[i].left - 1);
            // right
            preOrder(nodes, nodes[i].right - 1);
        }

    }

    public static void inOrder(Node[] nodes, int i) {
        /* left, node, right */
        if (i < nodes.length && i >= 0 && nodes[i] != null) {
            // left
            inOrder(nodes, nodes[i].left - 1);
            // node
            System.out.print(nodes[i].data + " ");
            // right
            inOrder(nodes, nodes[i].right - 1);
        }
    }

    public static void postOrder(Node[] nodes, int i) {
        /* left, right, node */
        if (i < nodes.length && i >= 0 && nodes[i] != null) {
            // left
            postOrder(nodes, nodes[i].left - 1);
            // right
            postOrder(nodes, nodes[i].right - 1);
            // node
            System.out.print(nodes[i].data + " ");
        }
        
    }

    private static void printTree(Node root) {
        
    }
}
