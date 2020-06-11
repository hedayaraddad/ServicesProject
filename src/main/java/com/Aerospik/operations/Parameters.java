package com.Aerospik.operations;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.policy.Policy;
import com.aerospike.client.policy.ScanPolicy;
import com.aerospike.client.policy.WritePolicy;


public class Parameters {
	public static AerospikeClient client =AerospikeConnection.getInstance();
	public static WritePolicy writePolicy =new WritePolicy();
	public static Policy policy =new WritePolicy() ;
	public static ScanPolicy scanPolicy =new ScanPolicy() ;
	

}
