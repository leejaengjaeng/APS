import java.util.Scanner;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5_Wook_Jae {

	public static void main(String args[]) throws NoSuchAlgorithmException
	{
		Scanner sc = new Scanner(System.in);
		String beforeString = sc.nextLine(); //"91bebba139b8b8aee0d8e80e27f473a3";//
		String MD5="";
		
		MessageDigest md = MessageDigest.getInstance("MD5"); 
		
		md.update(beforeString.getBytes()); 
		
		byte byteData[] = md.digest();
		
		StringBuffer sb = new StringBuffer(); 
		
		for(int i = 0 ; i < byteData.length ; i++)
		{
			sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
		}
		
		MD5 = sb.toString();
		System.out.println(MD5);		
	}
}
