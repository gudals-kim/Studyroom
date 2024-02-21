import java.io.*;
import java.util.*;

public class Main {
    static char[][] map;
    static int XrowBingo, XcolBingo; // X로 행, 열 빙고 갯수
    static int OrowBingo, OcolBingo; // O로 행, 열 빙고 갯수
    static int OCrossBingo , XCrossBingo; // X, O로 대각선 빙고 갯수
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true){
            String tcString = br.readLine();
            if (tcString.equals("end")) break;

            int idx = 0;
            int O = 0;
            int X = 0;
            XrowBingo = 0;
            XcolBingo = 0;
            OrowBingo = 0;
            OcolBingo = 0;
            OCrossBingo = 0;
            XCrossBingo = 0;
            map = new char[3][3];


            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    map[i][j] = tcString.charAt(idx++);
                    if (map[i][j]=='O') O ++;
                    else if (map[i][j]=='X') X++;
                }
            }

            if (Math.abs(X-O)>1 || O > X){
                sb.append("invalid").append("\n");
                continue;
            }

            for (int i = 0; i < 3; i++) {
                int rowX = 0;
                int rowO = 0;
                int colX = 0;
                int colO = 0;

                for (int j = 0; j < 3; j++) {
                    if (map[i][j] == 'X') rowX++;
                    else if (map[i][j] == 'O') rowO++;

                    if (map[j][i] == 'X') colX++;
                    else if (map[j][i] == 'O') colO++;

                    if(rowO == 3) {
                        OrowBingo++;
                    }else if(rowX == 3) {
                        XrowBingo++;
                    }else if(colX == 3) {
                        XcolBingo++;
                    }else if(colO == 3) {
                        OcolBingo++;
                    }

                }
            }

            int crossX=0;
            int crossO=0;
            // 대각선 검사
            for (int i = 0; i < 3; i++) {
                if	   (map[i][i] == 'X') crossX++;
                else if(map[i][i] == 'O') crossO++;

                if(crossO == 3) OCrossBingo++;
                if(crossX == 3) XCrossBingo++;

            }
            crossX=0;
            crossO=0;

            int temp= 0;
            for (int i = 2; i >= 0; i--) {
                if	   (map[i][temp] == 'X') crossX++;
                else if(map[i][temp] == 'O') crossO++;
                temp++;
                if(crossO == 3) OCrossBingo++;
                if(crossX == 3) XCrossBingo++;
            }

            // 같은 라인 빙고가 여러개인 경우 (cross제외)
            // 같은 라인에서 빙고가 여러개라면 끝내야 할 조건에서 끝내지 않고 게임을 더 했다는 의미이다.
            if(XrowBingo > 1 || XcolBingo > 1 || OrowBingo > 1 || OcolBingo>1) {
                sb.append("invalid").append("\n");
                continue;
            }

            // X와 O가 같으면 O가 이겨야한다
            if(X == O) {
                if((XrowBingo > 0 || XcolBingo > 0 || XCrossBingo > 0) ) {
                    sb.append("invalid").append("\n");
                    continue;
                }
            }

            // X가 더 크면 X가 이겨야 한다
            else if(X > O) {

                if(OrowBingo > 0 || OcolBingo > 0 || OCrossBingo > 0) {
                    sb.append("invalid").append("\n");
                    continue;
                }
            }

            // X와 O의 합이 9인 경우
            if(X + O == 9) {
                sb.append("valid").append("\n");
                continue;
            }

            // 빙고가 하나도 없는 경우
            if(XrowBingo + XcolBingo + OrowBingo + OcolBingo + OCrossBingo + XCrossBingo == 0) {
                sb.append("invalid").append("\n");
                continue;
            }

            sb.append("valid").append("\n");
        }
        System.out.println(sb);
    }

}