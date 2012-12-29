package it.polito.dp2.PJS.sol6.service;


import it.polito.dp2.PJS.sol6.server.xjc.Cluster.Hosts;

import java.math.BigInteger;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface PJSMaster {

	@WebMethod
	public BigInteger submit(String cmd, String args) throws Exception;

	@WebMethod
	public String[] getHostNames();

	@WebMethod
	public Hosts getHosts();
	
}
