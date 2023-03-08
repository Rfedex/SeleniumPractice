import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Java_Intro {

	public static void main(String[] args) {
		
		ArrayList<String> a = new ArrayList<String>();
		a.add("Himanshu");
		a.add("Pope");
		a.add("Raju");
		a.add("Laught");
		a.add(2,"Kirti");
		
//		for(String s:a) {
//			if(s.contains("Pope")) {
//				System.out.println("Found");
//			}
//		}
//		
//		System.out.println(a.contains("Pope"));
		
//		String[] arr= {"Rahul","Kishan"};
//		List<String> arrList = Arrays.asList(arr);
//		for(String s:arrList) {
//			
//			System.out.println(s);
//
//		}
//		System.out.println(arrList.contains("Kishan"));
//		
//\
		String s = "RogerFederer";
		for(int i=s.length()-1;i>=0;i--) {
			System.out.print(s.charAt(i));
		}
	}
		
}
