
import java.util.ArrayList;


public class BST{
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
        
    }

    public static boolean search(Node root, int key){
        if(root == null){
            return false;
        }
        if(root.data > key){
            return search(root.left, key);
        }
        else if(root.data == key){
            return true;
        }
        else{
            return  search(root.right, key);
        }
    }

    public static Node insert(Node root,int val){
      if(root == null){
        root = new Node(val);
        return root;
      } 
      if(root.data > val){
        root.left = insert(root.left, val);
      }
      else{
        root.right = insert(root.right, val);
      }
      return root;
    }

    public static Node delete(Node root, int val){
        if(root.data > val){
            root.left = delete(root.left, val);
        }
        else if(root.data < val){
            root.right = delete(root.right,val);
        }
        else{
            if(root.left == null && root.right == null){
                return null;
            }
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }

            Node is = inordersucessor(root.right);
            root.data = is.data;
            root.right = delete(root.right, is.data);
        }
        return root;
    }
    public static Node inordersucessor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    public static void range(Node root, int X, int Y){
        if(root == null){
            return;
        }
        if(root.data >= X && root.data <= Y){
            range(root.left, X, Y);
            System.out.println(root.data+" ");
            range(root.right, X, Y);
        }else if(root.data >= Y){
            range(root.left, X, Y);
        }
        else{
            range(root.right, X, Y);
        }
    }

    public static void path(ArrayList<Integer> path){
        for (int i = 0; i < path.size(); i++) {
            System.out.println(path.get(i)+ "->");
        }
    }


    public static void root2leaf(Node root, ArrayList<Integer> path){
        if(root == null){
            return;
        }
        path.add(root.data);

        if(root.left == null && root.right == null){
            path(path);
        }else{
            root2leaf(root.left, path);
            root2leaf(root.right, path);
        }
        path.remove(path.size()-1);
    }

    public static void main(String[] args) {
        int values[] = {8,5,3,1,4,6,10,11,14};
        Node root = null;
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }
        inorder(root);
        System.out.println();
        root2leaf(root, new ArrayList<>());
    }
}