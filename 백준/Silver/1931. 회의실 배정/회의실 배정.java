import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Meeting[] arr = new Meeting[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());
            arr[i] = new Meeting(startTime, endTime);
        }

        Arrays.sort(arr, (o1, o2) -> {
            int compare = Integer.compare(o1.endTime, o2.endTime);
            if (compare==0){
                if (o1.runTime==0||o2.runTime==0){
                    return Integer.compare(o1.startTime, o2.startTime);
                }
                return Integer.compare(o1.runTime, o2.runTime);
            }
            return compare;
        });

        Meeting meeting = arr[0];
        int ans = 1;
        for (int i = 1; i < N; i++) {
            Meeting nextMeeting = arr[i];
            if (nextMeeting.startTime>=meeting.endTime){
                ans++;
                meeting = nextMeeting;
            }
        }
        System.out.println(ans);
    }



}
class Meeting{
    int startTime;
    int endTime;
    int runTime;

    public Meeting(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.runTime = endTime-startTime;
    }
}