package ServicesProject;

import com.employee.*;
import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Consumer extends Thread{
	boolean blnExit =false ; 
	private final int id ; 
	private final BlockingQueue<Employee> sharedQueue ; 
	private Employee e;
	
	public Consumer(final int id,final BlockingQueue<Employee> sharedQueue,Employee e) {
		// TODO Auto-generated constructor stub
		this.id=id; 
		this.sharedQueue=sharedQueue;
		this.e = e ;
	}
	
	public void setExitCondition(final boolean blnDoExit) {
		this.blnExit=blnDoExit;
	}
	
	public Employee getEmployee() {
		return this.e;
	}
	
	@Override
	public void run() {
		final Random generator =new Random();
		
		while(!blnExit) {
			try {
				if(sharedQueue.size() >0) {
					Employee e =sharedQueue.take(); 
					try {
						 
						URL url = new URL("http://localhost:8080/DemoProject/rest/employees/get");
						HttpURLConnection conn = (HttpURLConnection) url.openConnection();
						conn.setRequestMethod("GET");
						conn.setRequestProperty("Accept", "text/html");
			 
						if (conn.getResponseCode() != 200) 
							System.out.println("Failed : HTTP error code : " + conn.getResponseCode());
						
			 
						BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			 
						String output;
						while ((output = br.readLine()) != null) {
			 
							System.out.println(output);
						}
						
						conn.disconnect();
			 
					} catch (MalformedURLException ex) {
			 
						ex.printStackTrace();
					} catch (IOException ex) {
			 
						ex.printStackTrace();
						
					}
					// run the service here 
					final long start =System.currentTimeMillis();
					Thread.sleep(generator.nextInt(1000)+1000);
					final long end =System.currentTimeMillis();
				}
				else {
					Thread.sleep(500);
				}
			}
			catch(InterruptedException ex) {
				ex.printStackTrace();
			}
		}
		System.out.println("consumer "+id+" exiting");
	}

}
