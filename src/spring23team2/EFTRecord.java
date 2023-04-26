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
 * @version 2.0
 */
public class EFTRecord {

	public static void createEFTRecords() {
		String directoryPath = "EFTRecords/";
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
				writer.write("ProviderName: " + ProviderFiles.searchProvider(ProviderNumber).getName());
				writer.write("ProviderNumber: " + String.valueOf(ProviderNumber) + "/n");
				int total = 0;
				for(ProviderTransaction transaction : transactions) {
					writer.write("Service Code: " + transaction.getServiceCode() + "/n");
					writer.write("Credit: " + transaction.getFee() + "/n");
					total += transaction.getFee();
				}
				writer.write("Total Amount to be Credited: " + total);
				writer.close();
				System.out.println("Saved Successfully");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}