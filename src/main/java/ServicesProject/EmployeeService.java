package ServicesProject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.employee.Employee;


@Path("employees")
public class EmployeeService {
	@GET
	@Path("/get")
	@Produces(MediaType.TEXT_HTML)
	public String getEmployeeInJSON() {
		Employee employee =new Employee();
		employee.setFname("Hedaya");
		employee.setlname("Raddad");
		employee.setIdnum(1);
		return "<html> " + "<title>" + "Hello Hedaya" + "</title>"
        + "<body><h1>" + "Hello    "+ employee.getFname()+ "   "+employee.getlname() + "</body></h1>" + "</html> ";
		
		
	}
	
	@GET
	@Path("Start")
	public void PService() {
		 int queueCapacity = 200;
		 int numberOfThreads = 10;	
		if (numberOfThreads <= 0 || numberOfThreads > 100) 
		throw new IllegalArgumentException("The number of threads should be a number between 1 and 100");
		//Creating shared object
		final BlockingQueue<Employee> sharedQueue = new LinkedBlockingQueue<Employee>(queueCapacity);
		// Creating and starting the Consumer Threads
		final List<Consumer> consumers = new ArrayList<Consumer>();
		List<Employee> employeeList =new ArrayList<Employee>();
		employeeList.add(new Employee("Hedaya","Raddad",4));
		employeeList.add(new Employee("Ha","Ra",2));
		for (int i = 0; i <numberOfThreads; i++) {
		final Consumer consThread = new Consumer(i, sharedQueue ,employeeList.get(i));
		consThread.start();
		consumers.add(consThread);
		}
		// Creating and starting the Producer Thread
		final Producer prodThread = new Producer(sharedQueue, consumers);
		prodThread.start();
		
	}
	

	@GET
	@Path("/hello")
	  @Produces(MediaType.TEXT_PLAIN)
	  public String sayHelloHedayaPT( ) {
	    return "Hello Hedaya";
	  }
	
	
	
	
	
}
