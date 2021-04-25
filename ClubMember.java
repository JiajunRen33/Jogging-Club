/*
 * Class name: ClubMember
 * Created by: Jiajun Ren
 * Date: July 20th
 */


//import java.io, ArrayLsit, Arrays
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * Class name:ClubMember
 * This class set the ClubMember as the constructor, and use it to deal with specific methods 
 * for the matching runners system
 */
public class ClubMember {
	
	//set the private variables
	private String name;
	private Integer age;
	private Integer distance;
	private boolean intensity;
	private String time;

	
	/*
	 * method name: ClubMember
	 * This is the constructor of this class with the 5 parameter for the runners
	 */
	public ClubMember(String name, Integer age, Integer distance, boolean intensity, String time) throws IllegalClubMember {
		
		//get setter
		setName(name);
		setAge(age);
		setDistance(distance);
		setIntensity(intensity);
		setTime(time);
	}
	
	
	/*
	 * method name: setName
	 * this method is the setter of name
	 */
	private void setName(String n) {
		this.name = n;
	}
	
	
	/*
	 * method name: setAge
	 * this method is the setter of age, and it throws an exception when the age less than 20
	 */
	protected void setAge(Integer a) throws IllegalClubMember {
		if(a < 20)//set condition for exception
			throw new IllegalClubMember("Illegal age – runners can only be a member of the club if they are 20+ years old");
		this.age = a;
	}
	
	
	/*
	 * method name: setDistance
	 * this method is the setter of distance, and it throws an exception when the the distance is 
	 * not one of the 5,10,15,30
	 */
	public void setDistance(Integer d) throws IllegalClubMember {
		if(d != 5 && d != 10 && d != 15 && d != 30)//set condition for exception
			throw new IllegalClubMember("Illegal distance provided");
		this.distance = d;
	}
	
	
	/*
	 * method name: setIntensity
	 * this method is the setter of intensity
	 */
	private void setIntensity(boolean i) {
		this.intensity = i;
	}
	
	
	/*
	 * method name: setTime
	 * this method id the setter of the time, and it throws an exception when the string is not one of the
	 * "Afternoon", "Morning" and "Evening"
	 */
	protected void setTime(String peroid) throws IllegalClubMember {
		//set condition for exception
		if(peroid.equals("Morning") == false && peroid.equals("Afternoon") == false && peroid.equals("Evening") == false)
			throw new IllegalClubMember("Illegal time of day provided");
		this.time = peroid;
	}
	
	
	/*
	 * method name:getName
	 * this method is the getter of name
	 */
	private String getName() {
		return this.name;
	}
	
	
	/*
	 * method name:getAge
	 * this method is the getter of age
	 */
	private int getAge() {
		return this.age;
	}
	
	
	/*
	 * method name:getDistance
	 * this method is the getter of distance
	 */
	private int getDistance() {
		return this.distance;
	}
	
	
	/*
	 * method name: getIntensity
	 * this method is the getter of intensity
	 */
	private boolean getIntensity() {
		return this.intensity;
	}
	
	
	/*
	 * method name: getTime
	 * this method is the getter of time
	 */
	private String getTime() {
		return this.time;
	}
	
	
	/*
	 * method name: toString
	 * this method get the getters and transfer them to string and return
	 */
	public String toString() {
		String memberInformation = name + ":" + age + "," + distance + "," + intensity +","+ time;
		return memberInformation;
	}
	
	
	/*
	 * method name:matchRunners
	 * input:ClubMember object mem
	 * return: true or false
	 * this method would return true if the two runners would make good running partners, otherwise false.
	 */
	public boolean matchRunners(ClubMember mem) {
		if(this.name.equals(mem.name)) {
			return false;
		}
		
		//match time
		if(!this.time.equals(mem.time)) {
			return false;
		}
		
		//match age
		for(int i = 20; i <= 70; i += 5) {
			if(this.age >= i && this.age < i + 5) {
				if(mem.age < i && mem.age >= i + 5) {
					return false;
				}
			}
		}
		
		//match distance
		if(this.distance != mem.distance) {
			return false;
		}
		
		//match intensity
		if(this.intensity != mem.intensity) {
			return false;
		}
		
		return true;
	}
	
	
	/*
	 * method name: readRunners
	 * input: path which is a string
	 * return: the array of the text in the txt file
	 * this method is edited from the professor's read file class
	 */
	public static ClubMember[] readRunners(String path) throws NumberFormatException, IllegalClubMember {
		try {
			
			//create new array list
			ArrayList<ClubMember> members = new ArrayList<>();
			File file = new File(path);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			String line;
			while((line = br.readLine()) != null) {
				
				//split the text
				String[] info = line.split(", ");
				ClubMember pMember = new ClubMember(info[0], Integer.parseInt(info[1]), Integer.parseInt(info[2]), Boolean.parseBoolean(info[3]), info[4]);	
				members.add(pMember);
				
			}
			
			br.close();
			fr.close();
			return members.toArray(new ClubMember[members.size()]);
			
		} catch(IOException e) {
			//catch for the wrong path
			System.out.println("Error Reading File.");
			return null;
		}
	
	}
	
	
	/*
	 * methods name: FindMatches
	 * input: ClubMember object
	 * return: list of the matched runners
	 */
	public static ArrayList<ClubMember> FindMatches(ClubMember testMember, ArrayList<ClubMember> members){
		//create new array list
		ArrayList<ClubMember> pMembers = new ArrayList<ClubMember>();
		for(ClubMember e : members) {
			//compare to find matching members
			if(testMember.matchRunners(e) == true) {
				if (testMember.getName() != e.getName()) {
					pMembers.add(e);
				}
			}
		}
		//return the list of matched runners
		return pMembers;
	}
	
	
	/*
	 * method name: displayPairs
	 * input: ClubMember object
	 * return: results of the pairs
	 */
	public static void displayPairs(ClubMember[] members) {
		//create new ArrayList
		ArrayList<ClubMember> pMembers = new ArrayList<>(Arrays.asList(members));
		
		//use two loops one by one to match and delete when a pair was matched
		for(int i = 0; i < pMembers.size() - 1; i++) {
			boolean matched = false;
			for(int j = 1; j < pMembers.size(); j++) {
				if(pMembers.get(i).matchRunners(pMembers.get(j)) == true) {
					System.out.println(pMembers.get(i).name + " matches with " + pMembers.remove(j).name);
					matched = true;
					break;
				}
			}
			
			//situation for no match found
			if(matched == false) {
				System.out.println("No match found for " + pMembers.get(i).name);
			}
		}		
	}
	
}
