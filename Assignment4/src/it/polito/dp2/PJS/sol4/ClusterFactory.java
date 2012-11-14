package it.polito.dp2.PJS.sol4;


import it.polito.dp2.PJS.sol4.jaxb.Cluster;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class ClusterFactory extends it.polito.dp2.PJS.ClusterFactory {

	@Override
	public it.polito.dp2.PJS.Cluster newCluster() throws it.polito.dp2.PJS.ClusterException {

		//get source file
		String sourceFilePath = System.getProperty("it.polito.dp2.PJS.sol4.Cluster.file");
		
		if (sourceFilePath != null) {
			File sourceFile = new File(sourceFilePath);
			
			if (sourceFile.isFile()) {
				try {
					JAXBContext context = JAXBContext.newInstance(it.polito.dp2.PJS.sol4.jaxb.Cluster.class);
					Unmarshaller unmarshaller = context.createUnmarshaller();
					Cluster jaxb = (Cluster) unmarshaller.unmarshal(sourceFile);
					
					return this.parse(jaxb);
				} catch (Exception e) {
					e.printStackTrace();
					throw new it.polito.dp2.PJS.ClusterException("Bad sourceFile or no DTD/schema found...");
				}
			} else {
				throw new it.polito.dp2.PJS.ClusterException("'" + sourceFilePath + "' is not a file...");
			}
		} else {
			throw new it.polito.dp2.PJS.ClusterException("No source file provided. Set 'it.polito.dp2.sol4.Cluster.file' property with source file path...");
		}
	}
	
	private it.polito.dp2.PJS.Cluster parse(Cluster jaxb) {
		it.polito.dp2.PJS.Cluster cluster = new ClusterImpl(jaxb);
		return cluster;
	}
}
