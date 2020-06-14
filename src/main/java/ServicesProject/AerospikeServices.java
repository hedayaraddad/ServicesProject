package ServicesProject;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;
import com.Aerospik.operations.*;
import com.aerospike.client.Bin;
import com.aerospike.client.Key;
@Path("Aerospike")
public class AerospikeServices {
	
@GET
@Path("/start")
@Produces(MediaType.TEXT_PLAIN)
public String sayHello()
{
	return " Aerospike service is Working !!" ; 
	
}

@GET
@Path("add/{id}")
public void add(@PathParam("id") int id) {
	String spacename="test";
	String set ="myTest";
	Key key =new Key(spacename,set,id);
	Bin bin =new Bin("age",25);
	System.out.println(WriteRecord.writeRecord(key, bin));
}


@GET
@Path("get/{id}")
@Produces(MediaType.TEXT_PLAIN)
public String getRecord(@PathParam("id") int id) {
	String spacename="test";
	String set ="myTest";
	Key key =new Key(spacename,set,id);
	Bin bin =new Bin("age",25);
	return ReadRecord.readRecord(key).toString();
}

}
