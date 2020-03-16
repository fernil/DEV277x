package companyStrctr;

public class SoftwareEngineer extends TechnicalEmployee {
	private boolean codeAccess;
	private int codeCheckIns;
	TechnicalLead manager;

	public SoftwareEngineer(String name) {
		super(name);
		this.codeAccess = false;
		this.codeCheckIns = 0;
	}

	public boolean getCodeAcces() {
		return codeAccess;
	}

	public void setCodeAcces(boolean acces) {
		this.codeAccess = acces;
	}

	public int getSuccessfulChceckIns() {
		return codeCheckIns;
	}

	public boolean checkInCode() {
		if (manager.approveCheckIn(this)) {
			codeCheckIns++;
			codeAccess = true;
			return true;
		}
		codeAccess = false;
		return false;
	}

	public Employee getManager() {
		return manager;
	}

}
