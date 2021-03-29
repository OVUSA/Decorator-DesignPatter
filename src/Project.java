
public class Project {
	public static void main (String[] args) {
		Team team = new Team();
		
		
		Developer javaDeveloper = new JavaDeveloper();
		Developer javaDeveloper2 = new JavaDeveloper();
		Developer cppDeveloper = new CppDeveloper();
		
		
		team.add(javaDeveloper);
		team.add(javaDeveloper2);
		team.add(cppDeveloper);
		team.createProject();
		
		
	}

}
