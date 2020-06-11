package com.Aerospik.operations;

import com.aerospike.client.Bin;
import com.aerospike.client.Key;
import com.aerospike.client.Record;

public class MainClass {
	public static void main(String [] args) {
		String spacename="test";
		String set ="myTest";
		Key key =new Key(spacename,set,1);
		Bin bin =new Bin("age",25);
		System.out.println(WriteRecord.writeRecord(key, bin));
		
		
		Record result =ReadRecord.readRecord(key);
		System.out.println("****");
		System.out.println(result.toString());
		
	}

}
