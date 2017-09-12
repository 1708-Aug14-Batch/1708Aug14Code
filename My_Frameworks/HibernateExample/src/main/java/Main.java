import com.hibernate.beans.Instructor;
import com.hibernate.beans.Student;
import com.hibernate.dao.HibernateDao;

public class Main {

	public static void main(String[] args) {
		
		HibernateDao dao = new HibernateDao();

		Instructor inst = new Instructor();
		
		inst.setName("Dr. Koszuta");
		dao.addInstructor(inst);
	}
}
