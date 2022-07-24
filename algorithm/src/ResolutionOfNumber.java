import java.util.Scanner;

public class ResolutionOfNumber {
    private static int[] a = new int[100000];
    private static int n ;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a[0] = 1;
        resolution(n, 1);
    }
    public static void resolution(int s, int k)
    {
        if (s == 0 && k > 2 ){//目的地
            print(k - 1);
            return;
        }

        for (int i = 1; i <= s; i++)
        {
            if (i >= a[k - 1]){// 后面这个数要大于等于前面一个数--满足条件
                a[k] = i;// 保存路径
                s = s - i;//后面数可能的情况
                resolution(s, k + 1);
                //回溯
                a[k] = 0;
                s += i;
            }
        }
    }
    private static void print(int k)
    {
        for (int i = 1 ; i < k; i++)
            System.out.print( a[i] + "+");
        System.out.println(a[k]);
    }
}
