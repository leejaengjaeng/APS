import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/*
 *  ���� �ٷ����ֵ� : 1 , ���� ��¥�� �ֵ� : -1, ���� ���� : 0
 *  
 * 	�л��� ���鼭 List�� �ְ� ����Ŭ�� Ȯ���� ��, ����Ŭ�� ���Ե� �ֵ鸸 1��, �������� -1�� 	
 * 
 * 	boolean �迭�� Ȯ���ϸ� �ξ� �����ٵ� �� boolean �迭���� ä���� ���ϴ°��� 
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
            //1:��, 0: ����Ʈ, -1:���� ����
            int teamFlag[] = new int[stNum+1];
       
            //�л� �Է�
            String inputStr[] = sc.nextLine().split(" ");
            for(int i=1;i<=stNum;i++)
                students[i] = Integer.parseInt(inputStr[i-1]);
   
            // �� ã��
            for(int i=1;i<=stNum;i++)
            {
                //����ó��
                   
                //1. Ȯ�� �� ���̸� �ѱ��
                if(teamFlag[i]!=0) continue;
                //2. ���� �ϰ� ���� ģ���� �� ���ϸ� �ѱ��
                if(teamFlag[students[i]]!=0)
                {
                    teamFlag[i]=-1;
                    continue;
                }
                //3. ȥ���ϰ� ������ �ѱ��
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
                //����Ŭ�� ã�ų�, ���� ���� �ǰ� ���� ����� �̹� ���� ���ԵǾ� ������ ���� Ž��
                while(true)
                {
                    int iAm = selected.get(selectedSize);
                    int iWant = students[iAm];
   
                    //�̹� ���� �ְų�, ���� �ɼ� ���� ����� �� ���
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
                       
                    //selectedList�� ���� �� ���
                    else if(isSelected.containsKey(iWant))
                    {
                        //������ ����Ŭ ���� Ȯ��
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
                       
                    //�Ѵ� �ƴϸ� ����Ʈ�� ����
                    else
                    {
                        selected.add(iWant);
                        isSelected.put(iWant,true);
                        selectedSize++;
                    }
                }
            }
               
            //���� ���� �л� Ȯ��
            int loser=0;
            for(int i=1;i<=stNum;i++)
                if(teamFlag[i]==-1) loser++;
               
            System.out.println(loser);
        }
    }
}