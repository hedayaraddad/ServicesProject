package com.Aerospik.operations;

import com.aerospike.client.AerospikeException;
import com.aerospike.client.Key;
import com.aerospike.client.Record;

public class ReadRecord {
	
	
	
	public static Record readRecord(Key key) {
		Record record=null; 
		try {
			
		 record =Parameters.client.get(Parameters.policy, key);
		}
		catch(AerospikeException ex) {
			
		}
		return record;
	}
	
	
	public static Record [] readRecords(Key []  keys) {
		Record [] records=null; 
		try {
			for(int j=0;j<keys.length;j++) {
				 records[j] =Parameters.client.get(Parameters.policy, keys[j]);}
		}
		catch(AerospikeException ex) {
			
		}
		return records;
	}
	
	

}
