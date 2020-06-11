package com.Aerospik.operations;

import com.aerospike.client.AerospikeException;
import com.aerospike.client.Key;
import com.aerospike.client.policy.WritePolicy;

public class DeleteRecord {

	
	public static boolean deleteRecord(Key key) {
		boolean success =true ; 
		try {
			Parameters.client.delete(Parameters.writePolicy, key);
		}
		catch(AerospikeException ex) {
			success=false;
		}
		return success;
	}
}
