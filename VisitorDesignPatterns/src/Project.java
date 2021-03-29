
public class Project implements ProjectElement{
	ProjectElement[] projectElement;
	
	public Project() {
		this.projectElement = new ProjectElement[] {
				new ProjectClass(),
				new Database(),
				new Test()
		};
		
		
	}

	@Override
	public void beWritten(Developer developer) {
		for (ProjectElement element :projectElement) {
			element.beWritten(developer);
		}
		
		
	}
	

}
