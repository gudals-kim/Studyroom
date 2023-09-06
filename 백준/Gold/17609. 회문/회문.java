import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			System.out.println(hwimun(str,0,str.length()-1,0));
		}
	}

    private static int hwimun(String str, int s, int e, int chk) {
        while (s < e) {
            if (str.charAt(s) == str.charAt(e)) {
                s++;
                e--;
                continue;
            }
            if (chk != 0)
                return 2;
            chk++;
            int res = hwimun(str, s, e-1, chk);
            if (res == 1) {
                e--;
                continue;
            }
            res = hwimun(str, s+1, e, chk);
            if (res == 1) {
                s++;
                continue;
            }
      }
      return chk;
    }
}