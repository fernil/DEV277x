package companyStrctr;

public abstract class Employee {
	private String name;
	 double baseSalary;
	private int id;
	private static int count;
	 double bonus;
	 double budget;
	

	public Employee(String name, double baseSalary) {
		this.name = name;
		this.baseSalary = baseSalary;
		this.id = ++count;
	}

	public String getName() {
		return name;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public int getEmployeeID() {
		return id;
	}
	abstract Employee getManager();
	
	public boolean equals(Employee other) {
		if(this.getEmployeeID()==other.getEmployeeID()) {
			return true;
		}return false;
	}
	public String toString() {
		return this.getEmployeeID()+" "+this.getName();
	}
	abstract  String employeeStatus(); 
	
	
	
}