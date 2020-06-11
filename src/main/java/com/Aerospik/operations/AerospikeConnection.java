package com.Aerospik.operations;

import com.aerospike.client.AerospikeClient;
public final  class AerospikeConnection {
	
	private static String localHost ="172.28.128.3";
	private static int port =3000 ;
	private final static  AerospikeClient client = new AerospikeClient(localHost,port);
	
	private AerospikeConnection()
	{
	}
	
	public static AerospikeClient getInstance() 
	{
		return AerospikeConnection.client;
	}

}// end of class


