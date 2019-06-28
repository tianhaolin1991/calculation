package capture5;

/**使用递归实现三角数字和阶乘
 * @author:tianhaolin
 * @version:1.0
 */
public class NumberTest {
    public static void main(String[] args) {
        System.out.println(fact(99, 1));
    }
    public static long fact(long n, long a) {
        if (n == 1) {
            return a;
        } else {
            return fact(n - 1, n * a);
        }
    }
}

    /*//三角数字
    public static int getSum(int n){
        //结束条件
        if(n==0){
            return 0;
        }
        //递归调用
        return n+getSum(n-1);
    }

    //递归阶乘
    public static int getFactorial(int n){
        //提高健壮性
        if(n<=0){
            return 0;
        }
        //结束条件
        if(n==1){
            return 1;
        }
        //递归调用
        return n*getFactorial(n-1);
    }


}*/
