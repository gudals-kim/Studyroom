

import java.util.*;
import java.io.*;

public class Solution {
    static char[][] map;
    static boolean[][] canMoveTank, canMoveShoot, isWall;

    static int H,W;
    public static void main(String[] args) throws IOException{



        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            Tank startTank = null;//시작탱크
            map = new char[H][W];//현재 맵
            canMoveTank = new boolean[H][W];//탱크가 갈수있음
            canMoveShoot = new boolean[H][W];//대포가 갈수 있음
            isWall = new boolean[H][W];//벽돌 벽 체크
            for (int i = 0; i < H; i++) {
                String input = br.readLine();
                for (int j = 0; j < W; j++) {
                    char c = input.charAt(j);
                    map[i][j] = c;
                    if (c=='.'){//평지면 탱크와 대포 둘다 갈수있음
                        canMoveTank[i][j]=true;
                        canMoveShoot[i][j]=true;
                        continue;
                    }
                    if (c=='*'){//벽돌일때
                        isWall[i][j]=true;//벽돌이라고 체크하고
                        canMoveTank[i][j]=true;//탱크가 갈수있는 길로 체크한다.
                        canMoveShoot[i][j]=true;//대포가 갈수있는 길로 체크한다.
                        continue;
                    }
                    if (c=='-'){//물일때는
                        canMoveShoot[i][j] = true;//대포는 지나갈수 있음
                        continue;
                    }
                    if (c=='<'){//왼쪽바라보는 전차
                        startTank = new Tank(i,j,"L");
                        canMoveTank[i][j]=true;//탱크가 갈수있는 길로 체크한다.
                        canMoveShoot[i][j]=true;//대포가 갈수있는 길로 체크한다.
                    }
                    if (c=='^'){//위를 바라보는 전차
                        startTank = new Tank(i,j,"U");
                        canMoveTank[i][j]=true;//탱크가 갈수있는 길로 체크한다.
                        canMoveShoot[i][j]=true;//대포가 갈수있는 길로 체크한다.
                    }
                    if (c=='v'){//아래를 바라보는 전차
                        startTank = new Tank(i,j,"D");
                        canMoveTank[i][j]=true;//탱크가 갈수있는 길로 체크한다.
                        canMoveShoot[i][j]=true;//대포가 갈수있는 길로 체크한다.
                    }
                    if (c=='>'){//오른쪽을 바라보는 전차
                        startTank = new Tank(i,j,"R");
                        canMoveTank[i][j]=true;//탱크가 갈수있는 길로 체크한다.
                        canMoveShoot[i][j]=true;//대포가 갈수있는 길로 체크한다.
                    }
                }
            }

            int N = Integer.parseInt(br.readLine());//명령어 개수
            String line = br.readLine();//입력 명령어
            Tank tank = startTank;//시작 탱크
            for (int i = 0; i < N; i++) {
                char command = line.charAt(i);//명령어
                tank = tankOperation(tank,command);//명령어를 입력받고, 수행된 다음의 탱크
            }
            
            //답안출력
            for (char[] chars : map) {//현재 맵에 담긴걸
                for (char aChar : chars) {//sb에 담아서
                    sb.append(aChar);//출력
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);

    }
    static Tank tankOperation(Tank tank, int command){
        if (command=='U'){//위 커맨드면
            if (canMove(tank.x-1, tank.y)&&!isWall[tank.x-1][tank.y]){//위로 갈수 있는 곳이라면
                map[tank.x-1][tank.y] = '^';//탬크를
                map[tank.x][tank.y] = '.';//옮기고
                return new Tank(tank.x-1, tank.y, "U");//옮긴 탱크를 리턴
            }
            //위로 갈수없다면
            map[tank.x][tank.y] = '^';//해당 방향으로 총구만 돌린다.
            tank.direction = "U";//총구를 돌려주고
            return tank;//리턴
        }
        if (command=='D'){//아래 커맨드면
            if (canMove(tank.x+1, tank.y)&&!isWall[tank.x+1][tank.y]){//아래로 갈 수 있는 곳이라면
                map[tank.x+1][tank.y] = 'v';//탱크를
                map[tank.x][tank.y] = '.';//옮기고
                return new Tank(tank.x+1, tank.y, "D");//옮긴 탱크를 리턴
            }
            //아래로 갈 수 없다면
            tank.direction = "D";//해당 방향으로 총구만
            map[tank.x][tank.y] = 'v';//돌리고
            return tank;//리턴
        }
        if (command=='L'){//왼쪽 커맨드면
            if (canMove(tank.x, tank.y-1)&&!isWall[tank.x][tank.y-1]){//왼쪽으로 갈수 있다면
                map[tank.x][tank.y-1] = '<';//탱크를
                map[tank.x][tank.y] = '.';//옮기고
                return new Tank(tank.x, tank.y-1, "L");//옮긴 탱크를 리턴
            }
            //왼쪽으로 갈 수 없다면
            tank.direction = "L";//해당 방향으로 총구만
            map[tank.x][tank.y] = '<';//돌리고
            return tank;//리턴
        }
        if (command=='R'){//오른쪽 커맨드면
            if (canMove(tank.x, tank.y+1)&&!isWall[tank.x][tank.y+1]){//오른쪽으로 갈 수 있다면
                map[tank.x][tank.y+1] = '>';//탱크를
                map[tank.x][tank.y] = '.';//옮기고
                return new Tank(tank.x, tank.y+1, "R");//옮긴 탱크를 리턴
            }
            //오른쪽으로 갈 수 없다면
            tank.direction = "R";//해당 방향으로
            map[tank.x][tank.y] = '>';//총구를 돌리고
            return tank;//리턴
        }
        if (command=='S'){//총을 쏴야한다면
            shootTank(tank);//총쏴
        }
        return tank;
    }
    static void shootTank(Tank tank){
        int x = tank.x;
        int y = tank.y;
        if (tank.direction.equals("U")){//총구방향이 위쪽일때,
            while (canMoveShoot(x,y) && !isWall[x][y]){//총알이 갈수있고, 벽이 아닐때까지
                x -= 1;//위로 올라간다.
            }
            //이 밑은 총알이 갈 수 없거나, 벽일때 수행된다.
            if (x>=0&&x<H&&y>=0&&y<W&&isWall[x][y]){//벽일때 탈출했을경우
                map[x][y] = '.';//해당 좌표를 평지로 바꿔주고
                isWall[x][y] = false;//벽이 아니라고 체크
            }
        }
        if (tank.direction.equals("D")){//총구방향이 아래일때,
            while (canMoveShoot(x,y)&&!isWall[x][y]){//총알이 갈수있고, 벽이 아닐때까지
                x += 1;//아래로 내려간다.
            }
            //이 밑은 총알이 갈 수 없거나, 벽일때 수행된다.
            if (x>=0&&x<H&&y>=0&&y<W&&isWall[x][y]){//벽일때 탈출했을경우
                map[x][y] = '.';//해당 좌표를 평지로 바꿔주고
                isWall[x][y] = false;//벽이 아니라고 체크
            }
        }
        if (tank.direction.equals("L")){//총구방향이 왼쪽일때,
            while (canMoveShoot(x,y)&&!isWall[x][y]){//총알이 갈수있고, 벽이 아닐때까지
                y -= 1;//왼쪽으로 간다.
            }
            //이 밑은 총알이 갈 수 없거나, 벽일때 수행된다.
            if (x>=0&&x<H&&y>=0&&y<W&&isWall[x][y]){//벽일때 탈출했을경우
                map[x][y] = '.';//해당 좌표를 평지로 바꿔주고
                isWall[x][y] = false;//벽이 아니라고 체크
            }
        }
        if (tank.direction.equals("R")){//총구방향이 오른쪽일때,
            while (canMoveShoot(x,y)&&!isWall[x][y]){//총알이 갈수있고, 벽이 아닐때까지
                y += 1;//오른쪽으로 간다.
            }
            //이 밑은 총알이 갈 수 없거나, 벽일때 수행된다.
            if (x>=0&&x<H&&y>=0&&y<W&&isWall[x][y]){//벽일때 탈출했을경우
                map[x][y] = '.';//해당 좌표를 평지로 바꿔주고
                isWall[x][y] = false;//벽이 아니라고 체크
            }
        }
    }
    static boolean canMove(int x, int y){//탱크가 갈 수 있는곳
        return (x>=0&&x<H&&y>=0&&y<W&&canMoveTank[x][y]);
    }
    static boolean canMoveShoot(int x, int y){//총알이 갈 수 있는곳
        return (x>=0&&x<H&&y>=0&&y<W&&canMoveShoot[x][y]);
    }
}
class Tank{
    int x;//탱크의 x좌표
    int y;//탱크의 y좌표
    String direction;//탱크의 총구 방향
    public Tank(int x, int y, String direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }
}
