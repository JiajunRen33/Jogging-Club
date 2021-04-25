/*
 * Class name:IllegalClubMember
 * Created by: Jiajun Ren
 * Date: July 20th
 */
public class IllegalClubMember extends Exception{
	//This exception class only needs the one constructor that accepts a String type message
	public IllegalClubMember(String message) {
		super(message);
	}
}
