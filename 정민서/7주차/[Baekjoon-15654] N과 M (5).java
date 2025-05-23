import java.util.*;
import java.io.*;


/*
 * 순서가 의미 있음 -> 순열
 * 중복 허용 안함
 */

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final StringBuilder sb = new StringBuilder("");

    static int n,m;
    static int[] input, res;
    static boolean[] isSelected;

    public static void main(String[] args) throws IOException{

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        input = new int[n];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st1.nextToken());
        }

        Arrays.sort(input);

        res = new int[m];
        isSelected = new boolean[n];

        perm(0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

    static void perm(int cnt) {

        if (cnt == m) {
            for (int i = 0; i < res.length; i++) {
                sb.append(res[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < input.length; i++) {

            if (!isSelected[i]) {
                isSelected[i] = true;
                res[cnt] = input[i];
                perm(cnt+1);
                isSelected[i] = false;
            }
        }
    }

}
