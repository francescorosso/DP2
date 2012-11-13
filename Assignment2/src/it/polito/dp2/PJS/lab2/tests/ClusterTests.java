package it.polito.dp2.PJS.lab2.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import it.polito.dp2.PJS.Cluster;
import it.polito.dp2.PJS.ClusterFactory;
import it.polito.dp2.PJS.Host;
import it.polito.dp2.PJS.Job;
import it.polito.dp2.PJS.JobGroup;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ClusterTests {

    class HostComparator implements Comparator<Host> {
        public int compare(Host h0, Host h1) {
            return h0.getName().compareTo(h1.getName());
        }

    }

    class JobGroupComparator implements Comparator<JobGroup> {
        public int compare(JobGroup g0, JobGroup g1) {
            return g0.getName().compareTo(g1.getName());
        }

    }

    class JobComparator implements Comparator<Job> {
        public int compare(Job j0, Job j1) {

            return j0.getID() - j1.getID();
        }
    }

    private static Cluster controlCluster;
    private static Cluster testCluster;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.setProperty("it.polito.dp2.PJS.ClusterFactory", "it.polito.dp2.PJS.Random.ClusterFactoryImpl");

        controlCluster = ClusterFactory.newInstance().newCluster();

        System.setProperty("it.polito.dp2.PJS.ClusterFactory", "it.polito.dp2.PJS.sol2.ClusterFactory");

        testCluster = ClusterFactory.newInstance().newCluster();
    }

    @Before
    public void setUp() throws Exception {

        assertNotNull(controlCluster);
        assertNotNull(testCluster);
    }

    private void compareHost(Host host1, Host host2) {
        assertNotNull(host1);
        assertNotNull(host2);

        assertNotNull("NULL Host Name", host2.getName());
        assertEquals("Wrong Host Name", host1.getName(), host2.getName());
        assertEquals("Wrong Status for Host " + host2.getName(), host1.getStatus(), host2.getStatus());
        assertEquals("Wrong Master Flag for Host " + host2.getName(), host1.isMaster(), host2.isMaster());
        assertEquals("Wrong Server Flag for Host " + host2.getName(), host1.isServer(), host2.isServer());
        assertEquals("Wrong Physical Memory for Host " + host2.getName(), host1.getPhysicalMemory(), host2.getPhysicalMemory());
        assertEquals("Wrong Load for Host " + host2.getName(), host1.getLoad(), host2.getLoad());
    }

    @Test
    public final void testGetHosts() {
        Set<Host> s1 = controlCluster.getHosts();
        Set<Host> s2 = testCluster.getHosts();

        if ((s1 == null) && (s2 != null)) {
            fail();
            return;
        }

        if ((s1 == null) && (s2 == null)) {
            assertTrue("There are no hosts!", true);
            return;
        }

        assertEquals("Wrong Number of Hosts", s1.size(), s2.size());
        assertEquals("Wrong Number of Hosts", testCluster.getNumberOfHosts(), s1.size());
        assertEquals("Wrong Number of Hosts", testCluster.getNumberOfHosts(), s2.size());

        TreeSet<Host> ts1 = new TreeSet<Host>(new HostComparator());
        TreeSet<Host> ts2 = new TreeSet<Host>(new HostComparator());

        ts1.addAll(s1);
        ts2.addAll(s2);

        Iterator<Host> i1 = ts1.iterator();
        Iterator<Host> i2 = ts2.iterator();

        while (i1.hasNext() && i2.hasNext()) {
            compareHost(i1.next(), i2.next());
        }
    }

    private void compareJobs(Job job1, Job job2) {
        if (job1 == null || job2 == null) {
            fail();
        }

        assertEquals("Wrong job ID", job1.getID(), job2.getID());

        Host ex1 = job1.getExecutionHost();
        Host ex2 = job2.getExecutionHost();

        if (((ex1 == null) && (ex2 != null)) || ((ex1 != null) && (ex2 == null))) {
            assertTrue("Wrong job execution host for job '" + job1.getID() + "'", false);
        }

        if (ex1 != null) {
            assertNotNull(ex2);
            assertEquals("Wrong execution host for job '" + job1.getID() + "'", ex1.getName(), ex2.getName());
        }

        assertEquals("Wrong job state for job '" + job1.getID() + "'", job1.getState(), job2.getState());
        assertNotNull("Null submission time for job '" + job1.getID() + "'", job1.getSubmissionTime());
        assertEquals("Wrong submission time for job '" + job1.getID() + "'", job1.getSubmissionTime().getTime(), job2
                .getSubmissionTime().getTime());

        Host sh1 = job1.getSubmissionHost();
        Host sh2 = job2.getSubmissionHost();

        assertNotNull("Null submission host for job '" + job1.getID() + "'", sh2);
        assertEquals("Wrong submission host for job '" + job1.getID() + "'", sh1.getName(), sh2.getName());
    }

    private final void compareJobSets(Set<Job> s1, Set<Job> s2) {
        if ((s1 == null) && (s2 != null)) {
            fail();
        }

        if ((s1 == null) && (s2 == null)) {
            return;
        }

        assertEquals("Wrong Number of Jobs", s1.size(), s2.size());

        TreeSet<Job> ts1 = new TreeSet<Job>(new JobComparator());
        TreeSet<Job> ts2 = new TreeSet<Job>(new JobComparator());

        ts1.addAll(s1);
        ts2.addAll(s2);

        Iterator<Job> i1 = ts1.iterator();
        Iterator<Job> i2 = ts2.iterator();

        while (i1.hasNext() && i2.hasNext()) {
            compareJobs(i1.next(), i2.next());
        }
    }


    @Test
    public final void testGetMasterHost() {
        Host m1 = controlCluster.getMasterHost();
        Host m2 = testCluster.getMasterHost();

        if (m1 == null) {
            assertNull(m2);
            assertTrue(controlCluster.getStatus() == Cluster.ClusterStatus.UNAVAIL);
            assertTrue(testCluster.getStatus() == Cluster.ClusterStatus.UNAVAIL);
        } else {
            assertNotNull("NULL master host", m2);
            compareHost(m1, m2);
        }
    }

    @Test
    public final void testGetName() {
        assertNotNull("NULL cluster name", testCluster.getName());
        assertEquals("Wrong Cluster Name", controlCluster.getName(), testCluster.getName());
    }

    @Test
    public final void testGetNumberOfHosts() {
        assertEquals("Wrong Number of Hosts", controlCluster.getNumberOfHosts(), testCluster.getNumberOfHosts());
    }

    @Test
    public final void testGetNumberOfServers() {
        assertEquals("Wrong Number of Servers", controlCluster.getNumberOfServers(), testCluster.getNumberOfServers());
    }

    @Test
    public final void testGetServers() {
        Set<Host> c1 = controlCluster.getServers();
        Set<Host> c2 = testCluster.getServers();

        if ((c1 == null) && (c2 != null)) {
            fail();
            return;
        }

        if ((c1 == null) && (c2 == null)) {
            assertTrue("Warning: there are no servers!", true);
            return;
        }

        assertEquals("Wrong Number of Servers", c1.size(), c2.size());
        assertEquals("Wrong Number of Hosts", testCluster.getNumberOfServers(), c1.size());
        assertEquals("Wrong Number of Hosts", testCluster.getNumberOfServers(), c2.size());

        TreeSet<Host> ts1 = new TreeSet<Host>(new HostComparator());
        TreeSet<Host> ts2 = new TreeSet<Host>(new HostComparator());

        ts1.addAll(c1);
        ts2.addAll(c2);

        Iterator<Host> i1 = ts1.iterator();
        Iterator<Host> i2 = ts2.iterator();

        while (i1.hasNext() && i2.hasNext()) {
            compareHost(i1.next(), i2.next());
        }
    }

    @Test
    public final void testGetStatus() {
        assertEquals("Wrong Cluster Status", controlCluster.getStatus(), testCluster.getStatus());
    }

    @Test
    public final void testGetJobsBooleanTrue() {
        Set<Job> s1 = controlCluster.getJobs(true);
        Set<Job> s2 = testCluster.getJobs(true);

        compareJobSets(s1, s2);
    }

    @Test
    public final void testGetJobsBooleanFalse() {
        Set<Job> s1 = controlCluster.getJobs(false);
        Set<Job> s2 = testCluster.getJobs(false);

        compareJobSets(s1, s2);
    }
    
    @Test
    public final void testGetJobGroups() {
        Set<JobGroup> c1 = controlCluster.getJobGroups();
        Set<JobGroup> c2 = testCluster.getJobGroups();

        if ((c1 == null) && (c2 != null)) {
            fail();
            return;
        }
       
        assertEquals("Wrong Number of Job Groups", c1.size(), c2.size());        

        TreeSet<JobGroup> ts1 = new TreeSet<JobGroup>(new JobGroupComparator());
        TreeSet<JobGroup> ts2 = new TreeSet<JobGroup>(new JobGroupComparator());

        ts1.addAll(c1);
        ts2.addAll(c2);

        Iterator<JobGroup> i1 = ts1.iterator();
        Iterator<JobGroup> i2 = ts2.iterator();

        while (i1.hasNext() && i2.hasNext()) {
            compareJobGroup(i1.next(), i2.next());
        }
    }
    
    private void compareJobGroup(JobGroup jg1, JobGroup jg2) {
        if (jg1 == null || jg2 == null) {
            fail();
        }

        assertEquals("Wrong group name", jg1.getName(), jg2.getName());
        assertEquals("Wrong group description", jg1.getDescription(), jg2.getDescription());

        compareJobSets(jg1.getJobs(), jg2.getJobs());
    }  
    
    @Test
    public final void testGetDefaultJobGroup() {
        JobGroup jg1 = controlCluster.getDefaultJobGroup();
        JobGroup jg2 = testCluster.getDefaultJobGroup();
        
        compareJobGroup(jg1, jg2);
        
    }
}
