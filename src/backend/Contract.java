package backend;
//14137400 Calvin Wong Chung Ki 
import java.text.SimpleDateFormat;
import java.util.Date;

public class Contract {
	private String owner;
	private String agent;
	private Date expiry;
	private Date start;

	
	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

	public Date getExpiry() {
		return expiry;
	}

	public void setExpiry(Date expiry) {
		this.expiry = expiry;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}
	public void printAgreement() {
		SimpleDateFormat dateform = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("\nI \"" + owner + "\" have agreed to the following advertising commitments \nsurpervise by \""
							+ agent +"\"the real estate agent." 
							+ "\nThis contract is valid from (" + dateform.format(start) + ") to (" + dateform.format(expiry) +")\n" );
	}
	

}
