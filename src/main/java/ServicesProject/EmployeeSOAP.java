package ServicesProject;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import com.employee.Employee;
@WebService
@SOAPBinding(style=Style.RPC)
public interface EmployeeSOAP {
@WebMethod String getEmployeeData(Employee e);
}
