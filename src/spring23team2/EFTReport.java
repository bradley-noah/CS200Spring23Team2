package spring23team2;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.io.FileWriter;
import java.io.IOException;


/**
 * This is a hash map that creates all EFT records when accounting procedure is ran
 * 
 * @author Noah Bradley
 * @version 1.0
 */
public class EFTReport {

	public static void createEFTReports() {
		String directoryPath = "EFTReports/";
		File directory = new File(directoryPath);
		String fileName = "EFT.txt";
		File file = new File(directory, fileName);
		if(!directory.exists()) {
			directory.mkdir();
		}
		for (Map.Entry<Integer, List<ProviderTransaction>> entry : ProviderTransactionFiles.ProviderTransactionMap.entrySet()) {
			Integer ProviderNumber = entry.getKey();
			List<ProviderTransaction> transactions = entry.getValue();
			try {
				FileWriter writer = new FileWriter(file);
				writer.write("ProviderNumber: " + String.valueOf(ProviderNumber) + "/n");
				for(ProviderTransaction transaction : transactions) {
					writer.write("Service Code: " + transaction.getServiceCode() + "/n");
					writer.write("Credit: " + transaction.getFee() + "/n");
				}
				writer.close();
				System.out.println("Saved Successfully");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
