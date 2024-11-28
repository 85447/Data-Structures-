//print numbers form 5 1o 1::
/*
public class recursion{
    public static void main(String[] args) {
        int n = 5;
        printNumber(n);
    }
    public static void printNumber(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        printNumber(n-1);
    }
}
*/


// sum of n natural numbers::
/*
public class recursion{
    public static void printSum(int i, int n, int sum){
        if(i== n){
            sum += i;
            System.out.println(sum);
            return;
        }
        sum += i;
        printSum(i+1, n, sum);
    }
    public static void main(String[] args) {
        printSum(1, 5, 0);
    }
}*/

//factorial of a number
/*public class recursion{
    public static int fact(int n){
        if(n==1){
            return 1;
        }
        int nm1 = fact(n-1);
        int fact_n = n*nm1;
        return fact_n;
    }
    public static void main(String[] args) {
        int n = 5;
        int ans = fact(n);
        System.out.println(ans);
    }
}*/

//fibonacci series::
/*public class recursion{
    public static void fibo(int a, int b, int n){
        if(n==0){
            return;
        }
        int c = a + b;
        System.out.println(c);
        fibo(b, c, n-1);

    }
    public static void main(String[] args) {
        int a  = 0;
        int b = 1;
        System.out.println(a);
        System.out.println(b);
        int n = 7;
        fibo(a, b, n-2);
    }
}*/

//stack height
/*public class recursion{
    public static int calPow(int x, int n){
        if(n==0){
            return 1;
        }
        if(x==0){
            return 0;
        }
        int xPownm1 = calPow(x, n-1);
        int xPown = x * xPownm1;
        return xPown;
    }
    public static void main(String[] args) {
        int x=2;
        int n = 5;
        int ans = calPow(x, n);
        System.out.println(ans);
    }
}*/

//2.........
public class recursion{
    public static int calPow(int x, int n){
        if(n==0){
            return 1;
        }
        if(x==0){
            return 0;
        }
        //if n is even:
        if(n%2 ==0){
            return calPow(x, n/2) * calPow(x, n/2);
        }else{
            return calPow(x, n/2) * calPow(x, n/2) * x;
        }
    }
    public static void main(String[] args) {
        int x=2;
        int n = 5;
        int ans = calPow(x, n);
        System.out.println(ans);
    }
}
