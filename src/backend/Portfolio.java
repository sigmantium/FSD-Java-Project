/*FindExpiringAgreement
 * 
 *
 * 
 * 
 * 
 * 
 * 
 * 
 */
//14137400  Calvin
package backend;
// 14137400 Calvin Wong Chung Ki 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

// This is a search function for Best real estate agreement database
public class Portfolio {
//                              columns
	private ArrayList<Contract> contracts = new ArrayList<Contract>();

	public static void main(String[] args) {

		Portfolio portfolio = new Portfolio();

		Date d1 = new Date("2019/03/24");
		Date d2 = new Date("2020/03/24");
		Date d3 = new Date("2020/01/16");
		Date d4 = new Date("2020/06/16");
		Date d5 = new Date("2020/02/28");
		Date d6 = new Date("2020/08/28");
		Date d7 = new Date("2019/12/26");
		Date d8 = new Date("2020/12/26");

		// like table
		portfolio.addAgreement("Joanne", "Calvin", d1, d2);
		portfolio.addAgreement("Lee", "Jonathan", d3, d4);
		portfolio.addAgreement("Colleen", "Elliot", d5, d6);
		portfolio.addAgreement("Taryn", "Calvin", d7, d8);

		System.out.println("Search agreement form");
		System.out.println("Option 1: Agent name");
		System.out.println("Option 2: Owner name ");

		Scanner scanner0 = new Scanner(System.in);
		// Can choose between search contract by option 1: Agent Name or option 2: Owner Name
		int choice = scanner0.nextInt();
		switch (choice) {
		case 1:

			System.out.println("Please insert Agent Name");
			Scanner scanner1 = new Scanner(System.in);
			String agentname = scanner1.nextLine();
			portfolio.findAgentName(agentname);

			break;

		case 2:
			Scanner scanner2 = new Scanner(System.in);
			System.out.println("Please enter owner's name");
			String owername = scanner2.nextLine();
			portfolio.findOwnertName(owername);
			break;

		default:
			System.out.println("Error - Option not available");
		}
	}

	// This is an Agreement that consist of Owner, Agent, the start and finish date
	// of the contract
	public void addAgreement(String owner, String agent, Date start, Date expiry) {
		Contract a;
		a = new Contract();
		a.setOwner(owner);
		a.setAgent(agent);
		a.setStart(start);
		a.setExpiry(expiry);
		contracts.add(a);

	}

	//Find contract using Agent Name
	public void findAgentName(String agent) {
		int i;
		Contract a;
		for (i = 0; i < contracts.size(); i++) {
			a = contracts.get(i);
			if (a.getAgent().equals(agent)) {
				a.printAgreement();
				i++;
				continue;
			}

		}

		System.out.println("Search Completed");
	}

	// Find contract using Owner Name
	public void findOwnertName(String owner) {
		int i;
		Contract a;
		for (i = 0; i < contracts.size(); i++) {
			a = contracts.get(i);
			if (a.getOwner().equals(owner)) {
				a.printAgreement();

			}
		}
		System.out.println("Search Completed");

	}

}