package ie.atu.sw;

public record Employee(String name, 
					   String department, 
					   double salary, 
					   boolean active) {
	
	//Can mutate record with helper methods like such
	 public Employee withSalary(double newSalary) {
		 return new Employee(name, department, newSalary, active);
	 }
}
