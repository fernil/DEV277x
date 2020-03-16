package companyStrctr;

abstract class TechnicalEmployee extends Employee{
	
	int numberOfCheckIns;
	
	public TechnicalEmployee(String name) {
		super(name,75000);
		
		this.numberOfCheckIns=0;
	}
	public TechnicalEmployee(String name,double baseSalary) {
		super(name,75000);
		
		this.numberOfCheckIns=0;
	}
	public int chceckIn() {
		return numberOfCheckIns++;
	}
	
	public String employeeStatus() {
		return this.getEmployeeID()+" "+this.getName()+" has "+numberOfCheckIns+" successful chceck ins.";
		
	}
	abstract public Employee getManager();
	
}
