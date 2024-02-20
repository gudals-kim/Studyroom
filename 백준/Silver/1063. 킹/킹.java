import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        HashMap<String, int[]> comb = new HashMap<>();
        comb.put("R", new int[] {1,0});
        comb.put("L", new int[] {-1,0});
        comb.put("B", new int[] {0,1});
        comb.put("T", new int[] {0,-1});
        comb.put("RT", new int[] {1,-1});
        comb.put("LT", new int[] {-1,-1});
        comb.put("RB", new int[] {1,1});
        comb.put("LB", new int[] {-1,1});

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        String tempKing = st.nextToken();
        Node king = new Node(tempKing);
//        System.out.println("king = " + king);
        String tempStone = st.nextToken();
        Node stone = new Node(tempStone);
//        System.out.println("stone = " + stone);
        int num = Integer.parseInt(st.nextToken());

        for (int i = 0; i < num; i++) {
            String s = br.readLine();
            int[] mvComb = comb.get(s);
//            System.out.println(s +" : "+ Arrays.toString(mvComb));
            //킹 이동
//            System.out.println("킹 이동");
            king.x += mvComb[0];
            king.y += mvComb[1];
//            System.out.println("king = " + king);
            //돌과 킹의 위치 확인
            //만약 돌과 킹의 위치가 같다면 돌 이동
            if (king.x== stone.x&& king.y== stone.y){
//                System.out.println("돌과 킹의 위치가 같음");
                stone.x += mvComb[0];
                stone.y += mvComb[1];
//                System.out.println("stonex = " + stone.x);
//                System.out.println("stone y= " + stone.y);
//                System.out.println("-------------------");
                //범위를 벗어났을 경우 초기화
                if (stone.x<0||stone.x>=8||stone.y<0||stone.y>=8){
//                    System.out.println("돌 범위 초과");

                    stone.x -= mvComb[0];
                    stone.y -= mvComb[1];
                    king.x -= mvComb[0];
                    king.y -= mvComb[1];
//                    System.out.println("stone = " + stone);
//                    System.out.println("-------------------");
                }
            }else {
                if (king.x<0||king.x>=8||king.y<0||king.y>=8) {
//                    System.out.println("킹 범위 초과");
                    king.x -= mvComb[0];
                    king.y -= mvComb[1];
//                    System.out.println("king = " + king);
//                    System.out.println("-------------------");
                }
            }


        }
        sb.append(king.toString()).append("\n").append(stone.toString());
        System.out.println(sb);
    }
    static class Node{
        int x;
        int y;

        public Node(String x) {
            this.x = x.charAt(0) - 'A';
            this.y = 8-Integer.parseInt(String.valueOf(x.charAt(1)));
        }

        @Override
        public String toString() {
            return Character.toString((char) (this.x+'A'))+(8-this.y);
        }
    }
}