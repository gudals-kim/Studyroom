import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int switchN = Integer.parseInt(br.readLine()); //스위치 개수
        boolean[] isSwitchOn = new boolean[switchN]; // 스위치 상태 배열

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < switchN; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if (temp==1){
                isSwitchOn[i] = true;
                continue;
            }
            isSwitchOn[i] = false;
        }

        int studentN = Integer.parseInt(br.readLine()); // 학생 수

        for (int i = 0; i < studentN; i++) {
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (sex==1){
                for (int switchIdx = 0; switchIdx < switchN; switchIdx++) {
                    if ((switchIdx+1)>=num&&(switchIdx+1)%num==0){
                        isSwitchOn[switchIdx] = !isSwitchOn[switchIdx];
                    }
                }
                continue;
            }

            if (sex==2){
                int left = num-1;
                int right = num-1;
                while(left>0&&right<switchN-1){

                    if (isSwitchOn[--left]!=isSwitchOn[++right]){
                        left++;
                        right--;
                        break;
                    }
                }
                for (int changeIdx = left; changeIdx < right+1; changeIdx++) {
                    isSwitchOn[changeIdx] = !isSwitchOn[changeIdx];
                }
            }
        }

        int idx = 0;
        while (idx<switchN) {
            if (isSwitchOn[idx]){
                sb.append(1).append(" ");
            }
            if (!isSwitchOn[idx]){
                sb.append(0).append(" ");
            }
            int div = idx+1;
            idx++;
            if (div>=20&&div%20==0){
                sb.append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}
