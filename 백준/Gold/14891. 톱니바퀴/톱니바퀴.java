
import java.io.*;
import java.util.*;

public class Main {
    static HashMap<Integer, ArrayDeque<Integer>> getWheel;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        getWheel = new HashMap<>();
        for (int i = 1; i <= 4; i++) {
            String line = br.readLine();
            getWheel.put(i,new ArrayDeque<>());
            for (int j = 0; j < 8; j++) {
                getWheel.get(i).add(Integer.parseInt(String.valueOf(line.charAt(j))));
            }
        }


        int K = Integer.parseInt(br.readLine());

        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int way = Integer.parseInt(st.nextToken());

            int left = num-1;
            int leftWay = way;
            ArrayList<int[]> temp = new ArrayList<>();
            while (left>0){
                if (chkRotateLeft(getWheelArr(getWheel.get(left+1)),getWheelArr(getWheel.get(left)))){
                    leftWay *= (-1);
                    temp.add(new int[]{left,leftWay});
                    left--;
                    continue;
                }
                break;
            }
            int right = num+1;
            int rightWay = way;
            while (right<5){
                if (chkRotateRight(getWheelArr(getWheel.get(right-1)),getWheelArr(getWheel.get(right)))){
                    rightWay *= (-1);
                    temp.add(new int[]{right,rightWay});
                    right++;
                    continue;
                }
                break;
            }
            rotateWheel(num,way);//해당 톰니바퀴 움직인다
            for (int[] ints : temp) {
                rotateWheel(ints[0],ints[1]);
            }
        }
        System.out.println(getScore());
    }

    static int getScore(){
        int result = 0;
        if (getWheel.get(1).getFirst()==1){
            result+=1;
        }
        if (getWheel.get(2).getFirst()==1){
            result+=2;
        }
        if (getWheel.get(3).getFirst()==1){
            result+=4;
        }
        if (getWheel.get(4).getFirst()==1){
            result+=8;
        }
        return result;
    }
    static void rotateWheel(int num, int way){
        ArrayDeque<Integer> wheel = getWheel.get(num);
        if (way==-1){//반시계
            wheel.addLast(wheel.pollFirst());
        }
        if (way==1){//시계
            wheel.addFirst(wheel.pollLast());
        }


    }
    static int[] getWheelArr(ArrayDeque<Integer> wheel){
        int[] wheelArr = new int[wheel.size()];
        int idx = 0;
        for (Integer i : wheel) {
            wheelArr[idx++] = i;
        }
        return wheelArr;
    }

    //true 반환이면 움직임
    //false면 움직이지 않음
    static boolean chkRotateRight(int[] wheel, int[] rightWheel){
        if (wheel[2]==rightWheel[6]){
            return false;
        }
        return true;
    }
    //true 반환이면 움직임
    //false면 움직이지 않음
    static boolean chkRotateLeft(int[] wheel, int[] leftWheel){
        if (leftWheel[2]==wheel[6]){
            return false;
        }
        return true;
    }
}