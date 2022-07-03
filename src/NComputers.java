import java.util.Scanner;

public class NComputers {
    static int n;//电脑台数
    static int []batteries;//电池数组

    static long solution() {
        int m = batteries.length;
        if(m < n) {
            return 0;
        }
        long left = 0;
        long right = batteries[0];
        long ans = 1;
        for(int num : batteries) {
            left = Math.min(left, num);
            right += num;
        }
        while(left <= right) {
            long mid = (left + right) >> 1;
            if(check(n, batteries, mid)) {
                ans = mid;
                left = mid + 1;
            }
            else right = mid - 1;
        }
        return ans;
    }
    static boolean check(int n, int[] batteries, long t) {
        long sum = 0;
        for(int num : batteries) {
            sum += Math.min(t, num);
        }
        return sum / t >= n;
    }

    static public void main(String[] args) {
        System.out.println("请输入电脑运行的台数：");
        Scanner reader = new Scanner(System.in);
        n = reader.nextInt();
        System.out.println("请输入电池个数");
        int o = reader.nextInt();
        batteries = new int[o];
        for(int i = 0; i < o; i++){
            System.out.println("请输入电池的电量：");
            batteries[i] = reader.nextInt();
        }
        System.out.println("运行时间是：" + solution());
    }
}
