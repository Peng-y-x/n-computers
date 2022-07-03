public class NComputers {
    static int n;//��������
    static int []batteries;//�������
    static boolean check(int n, int[] batteries, long t) {
        long sum = 0;
        for(int num : batteries) {
            sum += Math.min(t, num);
        }
        return sum / t >= n;
    }

    static public void main(String[] args) {
        n = 2;
        batteries = new int[]{1, 1, 1, 1};

        int m = batteries.length;
        if(m < n) {
            System.out.println("电池数过少，运行时间为0.");
        }
        else{
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
            System.out.println("运行时间为"+ans);
        }

    }
}
