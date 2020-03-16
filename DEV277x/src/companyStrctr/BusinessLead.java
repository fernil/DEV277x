package companyStrctr;

import java.util.ArrayList;

public class BusinessLead extends BusinessEmployee {
	private int headCount;

	private ArrayList<Accountant> directReports= new ArrayList<>();

	public BusinessLead(String name) {
		super(name);
		baseSalary *= 2;
		this.headCount = 10;
		
	}

	public boolean hasHeadCount() {
		if (directReports.size() < headCount) {
			return true;
		}
		return false;
	}

	public boolean addReport(Accountant e, TechnicalLead supportTeam) {
		if (hasHeadCount()) {
			directReports.add(e);
			
			bonusBudget += e.getBaseSalary() * 1.1;
			e.manager = this;
			e.supportTeam(supportTeam);

			return true;
		}
		return false;
	}

	public boolean requestBonus(Employee e, double bonus) {
		if (bonus <= bonusBudget) {
			bonusBudget -= bonus;
			e.bonus += bonus;
			return true;
		}
		return false;
	}

	public boolean approveBonus(Employee e, double bonus) {

		return false;
	}

	Employee getManager() {
		return null;
	}

	public String getTeamStatus() {
		String s = "";
		s += employeeStatus();
		if (directReports.size() == 0) {
			s += " and no direct reports yet";
		}
		s += " and is managing: \n";
		for (int i = 0; i < directReports.size(); i++) {
			s += directReports.get(i).employeeStatus() + " \n";
		}

		return s;
	}

}
