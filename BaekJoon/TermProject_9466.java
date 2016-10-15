import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/*
 *  팀이 꾸려진애들 : 1 , 팀을 못짜는 애들 : -1, 아직 미정 : 0
 *  
 * 	학생들 돌면서 List에 넣고 싸이클을 확인한 후, 싸이클에 포함된 애들만 1로, 나머지는 -1로 	
 * 
 * 	boolean 배열로 확인하면 훨씬 빠를텐데 왜 boolean 배열쓰면 채점을 못하는거지 
 */

public class TermProject_9466{
   
       
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int testCase = Integer.parseInt(sc.nextLine());
       
        for(int tc=0;tc<testCase;tc++)
        {
            int stNum = Integer.parseInt(sc.nextLine());
               
            int students[] = new int[stNum+1];
            //1:팀, 0: 디폴트, -1:팀이 못됨
            int teamFlag[] = new int[stNum+1];
       
            //학생 입력
            String inputStr[] = sc.nextLine().split(" ");
            for(int i=1;i<=stNum;i++)
                students[i] = Integer.parseInt(inputStr[i-1]);
   
            // 팀 찾기
            for(int i=1;i<=stNum;i++)
            {
                //예외처리
                   
                //1. 확인 된 점이면 넘기기
                if(teamFlag[i]!=0) continue;
                //2. 내가 하고 싶은 친구와 팀 못하면 넘기기
                if(teamFlag[students[i]]!=0)
                {
                    teamFlag[i]=-1;
                    continue;
                }
                //3. 혼자하고 싶으면 넘기기
                if(i == students[i])
                {
                    teamFlag[i]=1;
                    continue;
                }
       
                List<Integer> selected = new ArrayList<Integer>();
                HashMap<Integer,Boolean> isSelected = new HashMap<Integer,Boolean>(); 
                //boolean isSelected[] = new boolean[stNum+1];
                   
                int selectedSize=0;
                selected.add(i);
                isSelected.put(i, true);
//                isSelected[i]=true;
                //싸이클을 찾거나, 내가 팀이 되고 싶은 대상이 이미 팀에 포함되어 있을때 까지 탐색
                while(true)
                {
                    int iAm = selected.get(selectedSize);
                    int iWant = students[iAm];
   
                    //이미 팀이 있거나, 팀이 될수 없는 사람을 고른 경우
                    if(teamFlag[iWant]!=0)
                    {
                        for(int st=0; st<selected.size(); st++)
                        {
                            int currentStudent = selected.get(st);
                               
                            if(teamFlag[currentStudent]!=0) continue;
                            else teamFlag[currentStudent]=-1;   
                        }
                        break;
                    }
                       
                    //selectedList에 포함 된 경우
                    else if(isSelected.containsKey(iWant))
                    {
                        //어디까지 싸이클 인지 확인
                        int cycleStart = selected.indexOf(iWant);
                        for(int st=0;st<selected.size();st++)
                        {
                            int currentStudent = selected.get(st);
   
                            if(st<cycleStart)
                                teamFlag[currentStudent]=-1;
                            else
                                teamFlag[currentStudent]=1;
                        }
                        break;
                    }
                       
                    //둘다 아니면 리스트에 삽입
                    else
                    {
                        selected.add(iWant);
                        isSelected.put(iWant,true);
                        selectedSize++;
                    }
                }
            }
               
            //팀이 없는 학생 확인
            int loser=0;
            for(int i=1;i<=stNum;i++)
                if(teamFlag[i]==-1) loser++;
               
            System.out.println(loser);
        }
    }
}