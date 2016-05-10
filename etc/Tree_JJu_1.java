/*
import java.util.HashMap;
import java.util.Scanner;
//public class Main {
public class Tree_JJu_1{
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        while(cases-- > 0) 
        {
            int n = sc.nextInt();
            TreeNode root = new TreeNode(sc.nextInt());
            TreeNode input;
            Tree t = new Tree(root);
            
   
            //전위 입력받기
            for(int i=0;i<n-1;i++)
            {
            	input = new TreeNode(sc.nextInt());
            	t.put(input);
            }
            //중위 입력받기
            for(int i=0;i<n;i++)
            {
            	sc.nextInt();
            }
            
            t.postOrder(root);
        }
    }
}
class TreeNode
{
	int value;
	TreeNode left,right;
	TreeNode()
	{
		value=0;
		left=null;
		right=null;
	}
	TreeNode(int i)
	{
		value = i;
		left=null;
		right=null;
	}
}
class Tree
{
	TreeNode root;
	Tree(TreeNode t)
	{
		root = t;
	}
	public void postOrder(TreeNode root)
	{
		if(root.left!=null)postOrder(root.left);
		if(root.right!=null)postOrder(root.right);
		System.out.print(root.value+" ");
	}
	
	//n을 트리에 삽입
	public void put(TreeNode n)
	{
		TreeNode cmp = findPosition(n);
		if(cmp.value > n.value)
			cmp.left = n;
		else
			cmp.right = n;
	}
	
	//n이 입력될 위치의 부모 노드를 찾아서 반환 해줌 
	public TreeNode findPosition(TreeNode n)
	{
		TreeNode toFind = this.root;
		
		//찾는값이 루트보다 작은 경우
		if(toFind.value > n.value)
			toFind = downLeft(toFind,n);
		
		else
			toFind = downRight(toFind,n);
		
		return toFind;
	}
	
	public TreeNode downLeft(TreeNode tmpRoot,TreeNode n)
	{
		TreeNode tr = tmpRoot;
		while(tr.left!=null && tr.value > n.value)
		{
			tr = tr.left;
		}
		if(tr.value < n.value)
		{
			return downRight(tr,n);
		}
		else
			return tr;
	}
	
	public TreeNode downRight(TreeNode tmpRoot,TreeNode n)
	{
		TreeNode tr = tmpRoot;
		while(tr.right!=null && tr.value < n.value)
		{
			tr = tr.right;
		}
		if(tr.value > n.value)
		{
			return downLeft(tr,n);
		}
		else
			return tr;
	}
}
*/