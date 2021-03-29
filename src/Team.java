import java.util.ArrayList;
import java.util.List;

public class Team {
	List<Developer>developers= new ArrayList<Developer>();
	
	public void add(Developer developer) {
		developers.add(developer);
		
	}
	
	public void remove (Developer developer) {
		developers.remove(developer);
		
	}

	public void createProject() { // iterate trough team of developers and ask each of them write some code.
		for ( Developer element :developers) {
			element.writeCode();
		}
		
	}
}
