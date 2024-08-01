package NeetCode.RoadMap;

public class PrefixTree {
    public static void main(String[] args) {
        PrefixTree tree = new PrefixTree();
        tree.insert("assess");
        tree.insert("ass");

    }

    Node root;

    private class Node {
        char val;
        boolean isWord;
        Node[] children;

        public Node() {
            isWord = false;
            children = new Node[26];
        }

        public Node(char c) {
            this.val = c;
            isWord = false;
            children = new Node[26];
        }
    }

    public PrefixTree() {
        root = new Node();
    }

    public void insert(String word) {
        Node curr = this.root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.toCharArray()[i];
            int index = charToInt(c);
            if (curr.children[index] != null) {
                curr = curr.children[index];
            } else {
                curr.children[index] = new Node(c);
                curr = curr.children[index];
            }
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        Node curr = this.root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.toCharArray()[i];
            int index = charToInt(c);
            if (curr.children[index] != null) {
                curr = curr.children[index];
            } else {
                return false;
            }
        }

        return curr.isWord;
    }

    public boolean startsWith(String prefix) {
        Node curr = this.root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.toCharArray()[i];
            int index = charToInt(c);
            if (curr.children[index] != null) {
                curr = curr.children[index];
            } else {
                return false;
            }
        }

        return true;
    }

    private static int charToInt(char c)  {
        return c - 96;
    }
}
