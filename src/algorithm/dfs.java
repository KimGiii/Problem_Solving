package algorithm;

public class dfs {
    private Node root;

    static class Node {
        int data;
        Node lt, rt;
        public Node(int value) {
            data = value;
            lt = rt = null;
        }
    }

    private void dfs(Node root) {
        if (root == null) return;
        else {
            System.out.print(root.data + " ");
            dfs(root.lt);
            dfs(root.rt);
        }
    }

    public static void main(String[] args) {
        dfs tree = new dfs();
        tree.root = new Node(0);

    }
}
