package test;

import com.pone.pojos.AUser;
import com.pone.service.Service;

public class Main {

	private static Service remService;
	
	public static void main(String[] args) {
		remService = new Service();
//		
		AUser chichi = remService.addUser("Pen", "Satan", "penny", "pen@hercule.com", "pazz");
//		int chiId = chichi.getU_id();
//		remService.addReimbursement(chiId, "Goku, please stop destroying the laptops. I need a new one.", 1000);
//		
//		remService.editUserName(1,"kakarot");
//		
//		ArrayList<Reimbursement> theReimbursements = remService.getAllReimbursements();
//		for (Reimbursement i:theReimbursements) {
//			System.out.println(i.toString());
//		}
//		
//		
	}
	
}
