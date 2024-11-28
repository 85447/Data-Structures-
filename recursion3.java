
import java.util.ArrayList;


/*public class recursion3{
    public static void perm(String str, String permu){
        if(str.length() == 0){
            System.out.println(permu);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i);
            String newStr = str.substring(0,i) + str.substring(i+1);
            perm(newStr, permu+currChar);
        }
    }

    public static void main(String[] args) {
        String str = "abc";
        perm(str, " ");
    } 
}*/

//maze problem::
/*public class recursion3{
    public static int maze(int i, int j, int n, int m){
        if(i==n || j == m){
            return 0;
        }
        if(i == n-1 && j == m-1){
            return 1;
        }
        int down = maze(i+1, j, n, m);
        int right = maze(i, j+1, n, m);
        return down + right;
    }
    public static void main(String[] args) {
        int n = 3, m = 3;
        System.out.println(maze(0, 0, n, m));
    }
}*/

//Place Tiles::
/*public class recursion3{
    public static int tiles(int n , int m){
        if(n==m){
            return 2;
        }
        if(n < m){
            return 1;
        }
        int vertical = tiles(n-m, m);
        int horizontal = tiles(n - 1, m);
        return vertical + horizontal;
    }
    public static void main(String[] args) {
        int n = 4, m = 2;
        System.out.println(tiles(n, m));
    }
}*/

//Party question::
/*public class recursion3{
    public static int party(int n){
        if(n<=1){
            return 1;
        }
        int way1 = party( n-1);
        int way2 = (n-1) * party( n-2);
        return way1 + way2;
    }
    public static void main(String[] args) {
        int n = 4;
        System.out.println(party(n));
    }
}*/

//subbsets of natural number::
public class recursion3{
    public static void printSubset(ArrayList<Integer> subset){
        for (int i = 0; i < subset.size(); i++) {
            System.out.print(subset.get(i)+" ");
        }
        System.out.println();
    }
    public static void subset(int n, ArrayList<Integer> subset){
        if(n == 0){
            printSubset(subset);
            return ;
        }
        subset.add(n);
        subset(n-1, subset);
        subset.remove(subset.size()-1);
        subset(n-1, subset);
    }
    public static void main(String[] args) {
        int n = 3;
        ArrayList<Integer> subset = new ArrayList<>();
        subset(n, subset);
    }
}