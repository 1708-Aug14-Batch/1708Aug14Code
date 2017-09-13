import com.reimburse.service.Service;

public class Tester {
	
	// FIXME use logging instead of syso
	public static void main(String[] args) {
		System.out.println("Begin Tester main method");
		Service serv = new Service();
		
		int num = serv.getNumReimbursements();
		System.out.println("Number of reimbursements: " + num);
		
		System.out.println("Error: Tests are not implemented yet");
		
		System.out.println("End Tester main method");
	}

}
