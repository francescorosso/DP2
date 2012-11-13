/*

 * File: PJSInfo.java
 * 
 * Copyright (C) 2005 - 2012 - Politecnico di Torino
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 * 
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 * Author(s): Paolo Maggi <paolo.maggi@polito.it>
 * 
 * Created on Feb 22, 2005
 *
 */

package it.polito.dp2.PJS.lab2;

import it.polito.dp2.PJS.Cluster;
import it.polito.dp2.PJS.ClusterFactory;
import it.polito.dp2.PJS.Host;
import it.polito.dp2.PJS.Job;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Set;

public final class PJSInfo {

	private Cluster cluster;

	private DateFormat dateFormat;
	
	private PJSInfo() throws Exception {
		ClusterFactory factory = ClusterFactory.newInstance();

		cluster = factory.newCluster();
		
		dateFormat = new SimpleDateFormat("MMM dd HH:mm");
	}

	private void printInfo() {
		System.out.println("Cluster: " + cluster.getName());
		System.out.println("Status: "
				+ ((cluster.getStatus() == Cluster.ClusterStatus.OK) ? "OK": "UNAVAIL"));
		
		if (cluster.getMasterHost() != null) {
			System.out.println("Master host: "
					+ cluster.getMasterHost().getName());
		}
		
		System.out.println("Number of hosts: " + cluster.getNumberOfHosts());
		System.out.println("  - clients: "
				+ (cluster.getNumberOfHosts() - cluster.getNumberOfServers()));
		System.out.println("  - servers: " + cluster.getNumberOfServers());
		System.out.println();
	}

	private static String renderValue(int v) {
		if (v < 0)
			return "---";

		return Integer.toString(v);

	}

	private String hostToString(Host host) {
		String res = host.getName() + "\t";
		
		if (host.isMaster()) {
			res += "M ";
		} else {
			if (host.isServer())
				res += "S ";
			else
				res += "C ";
		}

		switch (host.getStatus()) {
		case OK:
			res += "OK      ";
			break;
		case CLOSED:
			res += "CLOSED  ";
			break;
		case UNAVAIL:
			res += "UNAVAIL ";
			break;
		case UNLICENSED:
			res += "UNLINC  ";
			break;
		}

		res += "\t" + renderValue(host.getLoad()) + "\t";
		res += renderValue(host.getPhysicalMemory());

		return res;
	}

	private void printHosts() {
		System.out.println("List of hosts:");
		System.out.println("");

		/* Print the header of the table */
		String header = new String("Name\tType & State\tLoad\tMEM");
		StringBuffer line = new StringBuffer(75);
		
		for (int i = 0; i < 75; ++i) {
			line.append('-');
		}
		
		System.out.println(header);
		System.out.println(line);

		Set<Host> c = cluster.getHosts();
		for (Host host : c) {
			System.out.println(hostToString(host));
		}

		System.out.println();
	}

	private String jobToString(Job job) {
		String res = new String("" + job.getID() + " \t");
		
		switch (job.getState()) {
		case DONE:
			res += "DONE";
			break;
		case EXIT:
			res += "EXIT";
			break;
		case PENDING:
			res += "PEND";
			break;
		case RUNNING:
			res += "RUNN";
			break;
		case SUSPENDED:
			res += "SUSP";
			break;
		}

		res += "\t" + job.getJobGroup().getName();
		res += "\t" + job.getSubmissionHost().getName();
		res += "\t" + (job.getExecutionHost() != null ? job.getExecutionHost().getName() : "---");
		res += "\t" + dateFormat.format(job.getSubmissionTime().getTime());

		return res;
	}

	private void printJobs(Set<Job> jobs) {
		for (Job job : jobs) {
			System.out.println(jobToString(job));
		}
	}
	
	private void printJobs() {
		System.out.println("List of jobs (grouped by Status):");
		System.out.println();

		/* Print the header of the table */
		String header = new String(
				"ID  \tStatus\tGroup\t\tSub.\tExec.\tSubm. Time");
		StringBuffer line = new StringBuffer(90);
		
		for (int i = 0; i < 90; ++i) {
			line.append('-');
		}
		
		System.out.println(header);
		System.out.println(line);

		Set<Job> c = cluster.getJobs(true);
		printJobs(c);
		
		System.out.println();
	}

	public void printAll() throws Exception {
		printInfo();
		System.out.println("   ");

		printHosts();
		System.out.println("   ");

		printJobs();
	}

	public static void main(String[] args) {
		try {
			PJSInfo info = new PJSInfo();

			info.printAll();

		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}
