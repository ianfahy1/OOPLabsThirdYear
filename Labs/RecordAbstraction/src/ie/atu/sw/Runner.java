package ie.atu.sw;

public class Runner {
	
	//Defining record in main //Does not have to be own file
	record Person(String name, int age, String email) {};
	
	public static void main(String[] args) {
		
		//Mutable object can be changed
		var p1 = new Person1("Ian", 22, "ianfahy1@gmail.com");
		p1.setAge(90);
		
		System.out.println(p1);
		System.out.println(System.identityHashCode(p1));
		
		
		//////////
		
		//Immutable record object cannot be changed
		//Record generates hashCode, .toString, constructor, .equals etc.
		var p2 = new Person("Ian", 22, "ianfahy1@gmail.com");
		
		//////////
		
		//Immutable but can be changed with helper methods
		var emp = new Employee("Joe", "HR", 20, false);
		emp = emp.withSalary(80);
		System.out.println(emp);
				
	}
}
