package it.polito.dp2.PJS.sol6.service;

import it.polito.dp2.PJS.sol6.server.xjc.Cluster.Hosts.Host;

import java.math.BigInteger;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface PJSMaster {

	@WebMethod
	public String[] getHostNames();

	@WebMethod
	public Host[] getHosts(String[] hostnames);

	@WebMethod
	public BigInteger submit(String cmd, String stdin) throws NoFreeExecutionHost;
}
