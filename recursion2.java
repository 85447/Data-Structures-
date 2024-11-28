



/*public class recursion2{
    public static void tower(int n, String src, String helper, String dest){
        if(n==1){
           System.out.println("transfer disk " + n + " from " +src+ " to " +dest);
           return; 
        }
        tower(n-1, src, dest, helper);
        System.out.println("transfer disk " + n + " from " +src+ " to" +dest);
        tower(n-1, helper, src, dest);
    }
    public static void main(String[] args) {
        int n = 3;
        tower(n, "S", "H", "D");
    }
}*/

//print the reverse String:
 /*public class recursion2{
    public static void reverse(String str, int idx){
        if(idx==0){
            System.out.print(str.charAt(idx));
            return;
        }
        System.out.print(str.charAt(idx));
        reverse(str, idx-1);
    }
    public static void main(String[] args) {
        String str = "abcd";
        reverse(str, str.length()-1);
    }
 }*/

//first and last index occurences:
/*public class recursion2{
    public static int first = -1;
    public static int last = -1;
    public static void string(String str, int idx, char element){
        if(idx == str.length()){
            System.out.println(first);
            System.out.println(last);
            return;
        }
        char currChar = str.charAt(idx);
        if(currChar == element){
            if(first == -1){
                first = idx;
            }else{
                last = idx;
            }
        }
        string(str, idx+1, element);
    }
    public static void main(String[] args) {
        String str = "abaacdaefaah";
        string(str, 0, 'a');
    }
}*/

//Array is sorted:
/*public class recursion2{
     public static boolean isSorted(int arr[], int idx){
        if(idx == arr.length-1){
            return true;
        }
        if(arr[idx] < arr[idx+1]){
            return isSorted(arr, idx + 1);
        }else{
            return false;
        }
     }
    public static void main(String[] args) {
        int arr[] = {1,3,5};
        System.out.println(isSorted(arr, 0));
    }
}*/

//move all x to end
/*public class recursion2{
    public static void move(String str, int idx, int count, String newString){
        if(idx == str.length()){
            for(int i = 0; i < count; i++){
                newString += 'x';
            }
            System.out.println(newString);
            return;
        }
        char currChar = str.charAt(idx);
        if(currChar == 'x'){
            count++;
            move(str, idx + 1, count, newString);
        }else{
            newString += currChar;
            move(str, idx + 1, count, newString);
        }
    }
    public static void main(String args[]){
        String str = "axbcxxd";
        move(str, 0, 0, " ");
    }
}*/

//remove duplicates from the string
/*public class recursion2{
    public static boolean[] map = new boolean[26];
    public static void duplicate(String str, int idx, String newString){
        if(idx == str.length()){
            System.out.println(newString);
            return;
        }
        char currChar = str.charAt(idx);
        if(map[currChar - 'a'] == true){
            duplicate(str, idx+1, newString);
        }else{
            newString += currChar;
            map[currChar - 'a'] = true;
            duplicate(str, idx+1, newString);
        }
    }
    public static void main(String[] args) {
        String str = "abbccda";
        duplicate(str, 0, " ");
    }
}*/

//subsequence of a string::
//1...................
/*public class recursion2{
    public static void  seq(String str, int idx, String newString){
        if(idx==str.length()){
            System.out.println(newString);
            return;
        }
        char currChar = str.charAt(idx);
        seq(str, idx+1, newString+currChar);
        seq(str, idx+1, newString);
    }
    public static void main(String[] args) {
        String str = "abc";
        seq(str, 0, " ");
    }
}*/

//2.....................
/*public class recursion2{
    public static void  seq(String str, int idx, String newString, HashSet<String> set){
        if(idx==str.length()){
            if(set.contains(newString)){
                return;
            }else{
                System.out.println(newString);
                set.add(newString);
                return;
            }
        }
        char currChar = str.charAt(idx);
        seq(str, idx+1, newString+currChar,set);
        seq(str, idx+1, newString,set);
    }
    public static void main(String[] args) {
        String str = "aaa";
        HashSet<String> set = new HashSet<>();
        seq(str, 0, " ",set);
    }
}*/

//keypad Combinations:
public class recursion2{
    public static String[] keypad = {".","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    public static void para(String str, int idx, String combination){
        if(idx == str.length()){
            System.out.println(combination);
            return;
        }
        char currChar = str.charAt(idx);
        String mapping = keypad[currChar - '0'];

        for (int i = 0; i < mapping.length(); i++) {
            para(str, idx+1, combination+mapping.charAt(i));
        }
    }
     public static void main(String[] args) {
         String str ="23";
         para(str, 0, " ");
     }
}
