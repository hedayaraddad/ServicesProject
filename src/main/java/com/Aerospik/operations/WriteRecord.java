package com.Aerospik.operations;



import com.aerospike.client.AerospikeClient;
import com.aerospike.client.AerospikeException;
import com.aerospike.client.Bin;
import com.aerospike.client.Key;
import com.aerospike.client.policy.ClientPolicy;
import com.aerospike.client.policy.WritePolicy;

public class WriteRecord {
	
	
	
	public static boolean writeRecord(Key key,Bin bin) {
		boolean success =true ; 
		try {
			
			Parameters.client.put(Parameters.writePolicy, key, bin);
		}
		catch(AerospikeException ex) {
			success=false;
		}
		return success;
	}
	
	public static boolean writeRecords(Key key ,Bin...bins) {
		boolean success =true ; 
		try {
			
			Parameters.client.put(Parameters.writePolicy, key, bins);
		}
		catch(AerospikeException ex) {
			success=false;
		}
		return success;
	}

	
	
	
	
	
	

}
