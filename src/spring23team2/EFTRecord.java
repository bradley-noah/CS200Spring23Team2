package spring23team2;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * @author Andrew Carter
 * @version 1.0
 *
 * This is a function that sends transaction data to a disk so the bank can comfirm providers are paid.
 *
 */
public class EFTRecord {

	public static void createEFTReports() {
		String directoryPath = "EFTRecords/";
		File directory = new File(directoryPath);
		String fileName = "EFTData.txt";
		File file = new File(directory, fileName);
		if(!directory.exists()) {
			directory.mkdir();
		}
		for (Map.Entry<Integer, List<ProviderTransaction>> entry : ProviderTransactionFiles.ProviderTransactionMap.entrySet()) {
			Integer ProviderNumber = entry.getKey();
			List<ProviderTransaction> transactions = entry.getValue();
			try {
				FileWriter writer = new FileWriter(file);
				writer.write("Provider Name: " + String.valueOf(ProviderName) + "/n");
				writer.write("ProviderNumber: " + String.valueOf(ProviderNumber) + "/n");
				int total = 0;
				for(ProviderTransaction transaction : transactions) {
					total += transaction.getFee(); //add all of transaction fees up to a total for each provider
				}
				writer.write("Amount to be transferred: " + total + "/n");
				writer.close();
				System.out.println("Saved Successfully");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
