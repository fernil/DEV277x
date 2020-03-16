package companyStrctr;

import java.util.ArrayList;

public class TechnicalLead extends TechnicalEmployee {
	 int headCount=4;
	private int reportsCount;
	 ArrayList<SoftwareEngineer> directReports;


	public TechnicalLead(String name) {
		super(name, (75000 * 1.3));
//		this.headCount = 4;
		this.reportsCount = 0;
		
		
	}

	public boolean hasHeadCount() {
		if (reportsCount < headCount) {
			return true;
		}
		return false;
	}

	public boolean addReport(SoftwareEngineer e) {
		if (headCount > 0) {
			directReports.add(e);
			headCount--;
			return true;
		}
		return false;
	}

	public boolean approveCheckIn(SoftwareEngineer e) {
		if (e.getCodeAcces() && directReports.contains(e)) {
			return true;
		}
		return false;
	}

	public boolean requestBonus(Employee e,double bonus) {
		if (((Accountant) getManager()).approveBonus(bonus)) {
            ((SoftwareEngineer) e).bonus += bonus;
			return true;
		}
		return false;
	}

	public Employee getManager() {
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
