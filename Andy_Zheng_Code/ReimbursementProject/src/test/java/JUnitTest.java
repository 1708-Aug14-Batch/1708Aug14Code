import static org.junit.Assert.assertEquals;

import java.util.HashSet;

import org.junit.Test;

import com.revature.andy.dao.DAOImplementation;
import com.revature.andy.pojos.ReimStatus;
import com.revature.andy.pojos.Reimbursement;
import com.revature.andy.pojos.User;
import com.revature.andy.service.Service;

public class JUnitTest {

	@Test
	public void test(){
		
		DAOImplementation dao = new DAOImplementation();
		Service s = new Service();
		
		ReimStatus rs = new ReimStatus(1,"Approved");
		User mu = new User(207,"Caleb","Rush","cr@email.com","cr",1);
		User eu = new User(301, "Claire", "Fiauw", "cf@email.com", "cf", 0);
		Reimbursement r = new Reimbursement(229, eu, mu, "13-SEP-17 09.01.00 PM", "13-SEP-17 09.01.59 PM", rs, "Travel Expenses", "Ok", 500.0);
		
		assertEquals(rs.getStatusID(), dao.getReimStatusFromID(1).getStatusID());
		assertEquals(rs.getStatusName(), dao.getReimStatusFromID(1).getStatusName());
		
		assertEquals(mu.getUserID(), dao.getUser(207).getUserID());
		assertEquals(mu.getFName(), dao.getUser(207).getFName());
		assertEquals(mu.getLName(), dao.getUser(207).getLName());
		assertEquals(mu.getEmail(), dao.getUser(207).getEmail());
		assertEquals(mu.getPassword(), dao.getUser(207).getPassword());
		assertEquals(mu.getIsManager(), dao.getUser(207).getIsManager());
		
		assertEquals(eu.getUserID(), s.getUserByID(301).getUserID());
		assertEquals(eu.getFName(), s.getUserByID(301).getFName());
		assertEquals(eu.getLName(), s.getUserByID(301).getLName());
		assertEquals(eu.getEmail(), s.getUserByID(301).getEmail());
		assertEquals(eu.getPassword(), s.getUserByID(301).getPassword());
		assertEquals(eu.getIsManager(), s.getUserByID(301).getIsManager());
		
		HashSet<Reimbursement> ur = new HashSet<>();
		ur.add(r);
		
		for(Reimbursement reims: ur) {
			System.out.println(reims.equals(r));
			assertEquals(r.getReimID(), reims.getReimID());
			assertEquals(r.getSubmitterID().getUserID(), reims.getSubmitterID().getUserID());
			assertEquals(r.getResolverID().getUserID(), reims.getResolverID().getUserID());
			assertEquals(r.getSubmitDate(), reims.getSubmitDate());
			assertEquals(r.getResolveDate(), reims.getResolveDate());
			assertEquals(r.getStatusID().getStatusID(), reims.getStatusID().getStatusID());
			assertEquals(r.getDescription(), reims.getDescription());
			assertEquals(r.getNotes(), reims.getNotes());
			assertEquals(r.getAmount(), reims.getAmount(), 0.01);
		}
	}
}
