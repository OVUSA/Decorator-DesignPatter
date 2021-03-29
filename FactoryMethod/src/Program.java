
public class Program {

	public static void main(String[] args) {
		//DeveloperFactory developerFactory = new JavaDeveloperFactory(); // to change developer I need Only change a factoryJavaDeveloperFactory  to C++DeveloeprFactory
		DeveloperFactory developerFactory = createDeveloperBySpecialty("php");
		
		Developer developer =  developerFactory.createDeveloper();
		
		developer.writeCode();

	}
	
	
	static DeveloperFactory createDeveloperBySpecialty(String st) {
		 if ( st.equalsIgnoreCase("java")) {
			 return new JavaDeveloperFactory();
		 }else if (st.equalsIgnoreCase("c++")) {
			 return new CppDeveloperFactory();
		 }else if ( st.equalsIgnoreCase("php")){
			 return new PhpDeveloperFactory();
		 }else  {
			 throw new RuntimeException(st+ "is unknow specialty");
		 }
		
	}
}
