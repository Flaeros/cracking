package hard_17;

import java.util.LinkedList;
import java.util.Queue;

public class KthMultiple_17_9 {

    public static void main(String[] args) {
        System.out.println(new KthMultiple_17_9().getKthMagicNumber(5));
        System.out.println(new KthMultiple_17_9().getKthMagicNumber(15));
    }


    public int getKthMagicNumber(int k) {
        if (k < 0)
            return 0;

        int val = 0;
        Queue<Integer> q3 = new LinkedList<>();
        Queue<Integer> q5 = new LinkedList<>();
        Queue<Integer> q7 = new LinkedList<>();
        q3.offer(1);

        for (int i = 0; i <= k; i++) {

            int v3 = q3.size() > 0 ? q3.peek() : Integer.MAX_VALUE;
            int v5 = q5.size() > 0 ? q5.peek() : Integer.MAX_VALUE;
            int v7 = q7.size() > 0 ? q7.peek() : Integer.MAX_VALUE;

            val = Math.min(v3, Math.min(v5, v7));

            if (val == v3) {
                q3.remove();
                q3.add(3*val);
                q3.add(5*val);
            } else if (val == v5) {
                q5.remove();
                q3.add(5*val);
            } else if (val == v7) {
                q7.remove();
            }

            q7.add(7*val);
        }

        return val;
    }

}
