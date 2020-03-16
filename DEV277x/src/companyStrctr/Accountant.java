package companyStrctr;

public class Accountant extends BusinessEmployee {
	
	private TechnicalLead teamSupported;
	BusinessLead manager;

	public Accountant(String name) {
		super(name);		
		this.teamSupported = null;
	}

	public TechnicalLead getTeamSupported() {
		return teamSupported;
	}

	public void supportTeam(TechnicalLead lead) {
		this.teamSupported=lead;
		double total=0;
		for (int i = 0; i < lead.directReports.size(); i++) {
			total+=lead.directReports.get(i).getBaseSalary();
		}
		budget = total*1.1;
	}

	public boolean approveBonus(double bonus) {
		if(teamSupported==null&&bonus<=budget) {
			return false;
		}		
		return true;
		
	}

	public String employeeStatus() {
		return this.getEmployeeID() + " " + this.getName() + " with a budget of " + (int)budget + " is supporting "
				+ teamSupported;
	}

	Employee getManager() {
		return manager;
	}
}
