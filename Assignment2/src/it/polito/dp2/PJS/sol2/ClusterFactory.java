package it.polito.dp2.PJS.sol2;

import it.polito.dp2.PJS.Cluster;
import it.polito.dp2.PJS.ClusterException;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;

public class ClusterFactory extends it.polito.dp2.PJS.ClusterFactory {

	@Override
	public Cluster newCluster() throws ClusterException {

		//get source file
		String sourceFilePath = System.getProperty("it.polito.dp2.sol2.Cluster.file");
		
		if (sourceFilePath != null) {
			File sourceFile = new File(sourceFilePath);
			
			if (sourceFile.isFile()) {
				try {
					DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
					dbf.setValidating(true);
					dbf.setNamespaceAware(true);
					DocumentBuilder db = dbf.newDocumentBuilder();
					Document dom = db.parse(sourceFile);
					
					return this.parse(dom);
				} catch (ParserConfigurationException e) {
					throw new ClusterException("Bad configuration...");
				} catch (Exception e) {
					e.printStackTrace();
					throw new ClusterException("Bad sourceFile or no DTD/schema found...");
				}
			} else {
				throw new ClusterException("'" + sourceFilePath + "' is not a file...");
			}
		} else {
			throw new ClusterException("No source file provided. Set 'it.polito.dp2.sol2.Cluster.file' property with source file path...");
		}
	}
	
	private Cluster parse(Document dom) {
		Cluster cluster = new ClusterImpl(dom);
		return cluster;
	}
}
