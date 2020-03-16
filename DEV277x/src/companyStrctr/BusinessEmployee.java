package companyStrctr;

abstract class BusinessEmployee extends Employee{
	 double bonusBudget;
	
	public BusinessEmployee(String name) {
		super(name, 50000);
		
	}

	
	public double getBonusBudget() {
		return bonusBudget;
	}
	public String employeeStatus() {
		return this.getEmployeeID()+" "+this.getName()+" with a budget of "+this.bonusBudget;
	}
	abstract Employee getManager();
}
