/*
 * Class name: driver 
 * Created By: Jiajun Ren
 * Date: July 20th
 */


//import the ArrayList and Arrays
import java.util.ArrayList;
import java.util.Arrays;

/*
 * class name: driver
 * This class get the methods from the ClubMember class to display the result of the sample
 */
public class driver {
	/*
	 * method name: main
	 * The method get the methods from the ClubMember class to display the result of the sample
	 */
	public static void main(String[] args) throws IllegalClubMember {
		//test the matchRunners function
		System.out.println("display the two-ways matching by matchRunners method:");
		ClubMember sample1 = new ClubMember("Bob Jones", 20, 15, true, "Morning");
		ClubMember sample2 = new ClubMember("Sally Jane", 23, 15, true, "Morning");
		System.out.println("sample1 is: Bob Jones: 22, 15, true, Morning ");
		System.out.println("sample2 is: Sally Jane: 23, 15, true, Morning");
		System.out.println("match sample1 with sample2: " + sample1.matchRunners(sample2));
		System.out.println("match sample2 with sample1: " + sample2.matchRunners(sample1));
		System.out.println("");
		
		
		//display readRunners with the sample txt file and transfer the result to an Array
		System.out.println("display the readRunner method by using the sample text file:");
		ClubMember.readRunners("D:\\Queen's university\\CISC124\\assignment 2\\member's information.txt");
		ClubMember[] data = ClubMember.readRunners("D:\\Queen's university\\CISC124\\assignment 2\\member's information.txt");	
		ArrayList<ClubMember> testingData = new ArrayList<>(Arrays.asList(data));
		for(int i = 0; i < testingData.size(); i++) {
			System.out.println(testingData.get(i));
		}
		System.out.println("");
		
		
		//display the setDistance function
		System.out.println("Changing the distance: ");
		ClubMember distance1 = new ClubMember("Bob Jones", 20, 10, true, "Morning");
		System.out.println(distance1);
		System.out.println("we can see the original distance is 10");
		distance1.setDistance(15);
		System.out.println("After changing it to 15:");
		System.out.println(distance1);
		System.out.println("");
		
	
		//display the findMatches method
		System.out.println("Display the FindMatches Method: ");		
		ClubMember Matching1 = new ClubMember("Robert Smith", 24, 15, true, "Morning");
		System.out.println("We have a ClubMember object which is Robert Smith: 24, 15, true, Morning");
		System.out.println("Now we try to find matches for him in the sample text file:");
		System.out.println(ClubMember.FindMatches(Matching1, testingData));
		System.out.println("");

		
		//display the displayPairs method
		System.out.println("Display the displayPairs method by the sample text file:");
		System.out.println("Here are the results of matching: ");
		ClubMember.displayPairs(data);
		
		
		
	}
	
}
