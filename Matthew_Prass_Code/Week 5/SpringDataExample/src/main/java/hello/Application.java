package hello;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class Application implements CommandLineRunner {


    @Autowired
    DataSource dataSource;

    @Autowired
    EmployeeRepository empRepo;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {

        System.out.println("DATASOURCE = " + dataSource);

        System.out.println(empRepo.count());
        System.out.println(empRepo.findOne((long) 2));
        System.out.println(empRepo.exists((long) 1));
        Employee emp = new Employee("lekjndewk", "dlkwemndew");
        empRepo.save(emp);
        
        System.out.println(empRepo.count());
        //System.out.println(empRepo.findOne((long) 4));
        System.out.println("\n1.findAll()...");
        for (Employee e : empRepo.findAll()) {
        	System.out.println(e);
        }
        
        empRepo.delete(emp);
        for (Employee e : empRepo.findAll()) {
        	System.out.println(e);
        }

        for (Employee e : empRepo.findByLastName("Smith")) {
            System.out.println(e);
        }
        
        System.out.println(empRepo.findByFirstName("Matt"));

        System.out.println("Done!");

    }
}
