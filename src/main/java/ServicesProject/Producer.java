package ServicesProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.checkerframework.common.reflection.qual.GetClass;
import com.employee.Employee;


public class Producer extends Thread {
	private boolean blnExit =false ; 
	private final List<Consumer> consumers ; 
	private final BlockingQueue<Employee> sharedQueue ;
	
	public Producer (final BlockingQueue<Employee> sharedQueue,List<Consumer> consumers) {
		// TODO Auto-generated constructor stub
		this.sharedQueue=sharedQueue;
		this.consumers=consumers;
	}
	
	
	
	
	
	
	@Override
	public void run() {
		int i =0 ;
		
		//producing the objects to be consumed 
		
		while(!blnExit) {
			try {
				i++;
				if(i >= consumers.size()) {
					break ;
				}
				else {
					sharedQueue.put(consumers.get(i).getEmployee());
				}
				
				// run the service 
			}
			catch(final InterruptedException ex ) {
				ex.printStackTrace();
			}
		}//end of while 
		
		//wait until the queue is empty 
		
		while(sharedQueue.size() > 0) {
			try {
				Thread.sleep(200);
				System.out.println("producer waiting to end");
			}
			catch(final InterruptedException ex) {
				break;
			}
		}
		
		for(final Consumer consumer :consumers) {
			consumer.setExitCondition(true);
		}
	}// end of run

}
