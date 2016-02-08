public class Fibonacci {

    public static int fibonacci(int n){
        if(n == 1 || n == 2){
            return 1;
        }
        int im1 = 1;
        int im2 = 1;
        int fn = 0;
        for(int i = 3; i <= n; i++){
            fn = im1 + im2;
            im2 = im1;
            im1 = fn;
        }
        return fn;
    }
}
