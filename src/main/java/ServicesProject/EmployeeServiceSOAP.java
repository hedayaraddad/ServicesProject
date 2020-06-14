package ServicesProject;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

import com.employee.Employee;

@WebService(endpointInterface = "ServicesProject.EmployeeSOAP")  
public class EmployeeServiceSOAP implements EmployeeSOAP {
	private Employee e ; 
	public EmployeeServiceSOAP(Employee e ) {
		// TODO Auto-generated constructor stub
		this.e=e;
	}

	@Override
	public String getEmployeeData(Employee e) {
		// TODO Auto-generated method stub
		return  "employee name :"+e.getFname()+" "+e.getlname();
	}
	
	public static void main(String[] args) {  
	       Endpoint.publish("http://localhost:8080/ws/hello", new EmployeeServiceSOAP(new Employee("Hedaya","Raddad",5050)));  
	        }  

}
