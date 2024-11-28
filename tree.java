
import java.util.*;


/*public class tree{
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static class binaryTree{
        static int idx = -1;
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }
    }
    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println(root.data);
    }
}*/

//Pre-order traversal::
public class tree{
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static void preorder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
        
    }
    public static void postorder(Node root){
        if(root == null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
    }

    public static void levelorder(Node root){
        if(root==null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node currNode = q.remove();
            if(currNode == null){
              System.out.println();
              if(q.isEmpty()){
                break;
              }else{
                q.add(null);
              }
            }else{
                System.out.print(currNode.data+" ");
                if(currNode.left != null){
                    q.add(currNode.left);
                }
                if(currNode.right != null){
                    q.add(currNode.right);
                }
            }
        }
    }
    public static int count(Node root){
        if(root==null){
            return 0;
        }
        int left = count(root.left);
        int right = count(root.right);
        return left + right + 1;
    }
    public static int sum(Node root){
        if(root == null){
            return 0;
        }
        int left = sum( root.left);
        int right = sum(root.right);
        return left + right + root.data;
    }
    public static int height(Node root){
        if(root==null){
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        int height = Math.max(left,right) +1;
        return height;
    }

    public static int diameter(Node root){
        if(root==null){
            return 0;
        }
        int diam1 = diameter(root.left);
        int diam2 = diameter(root.right);

        int diam3 = height(root.left) + height(root.right) + 1;

        return Math.max(diam3, Math.max(diam1,diam2));
    }

    static class TreeInfo{
        int ht;
        int diam;

        TreeInfo(int ht, int diam) {
            this.ht = ht;
            this.diam = diam;
        }
    }

    public static TreeInfo diameter2(Node root){
        if(root==null){
            return new TreeInfo(0,0);
        }
        TreeInfo left = diameter2(root.left);
        TreeInfo right = diameter2(root.right);

        int height = Math.max(left.ht, right.ht)+1;

        int diam1 = left.diam;
        int diam2 = right.diam;
        int diam3 = left.ht + right.ht + 1;
        int mydiam = Math.max(Math.max(diam1,diam2), diam3);
        TreeInfo myinfo = new TreeInfo(height,mydiam);
        return myinfo;
    }
    /*
    public static boolean identical(TreeNode root, TreeNode subroot){
        if(root == null && subroot == null){
            return true;
        }
        if(root == null || subroot == null){
            return false;
        }
        if(root.val == subroot.val){
            return identical(root.left, subroot.left) && identical(root.right, subroot.right);
        }
        return false;
    }
    public static boolean subtree(TreeNode root, TreeNode subroot){
        if(subroot == null){
            return true;
        }
        if(root == null){
            return false;
        }
        if(root.val == subroot.val){
            if(identical(root, subroot)){
                return true;
            }
        }
        return subtree(root.left, subroot) || subtree(root.right, subroot);
    }*/
    static class binaryTree{
        static int idx = -1;
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        } 
    }
    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        binaryTree tree = new binaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println(diameter2(root).diam); 
    }
}