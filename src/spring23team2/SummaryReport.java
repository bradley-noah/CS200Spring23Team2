package spring23team2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * This is a hash map that creates Summary Records when accounting procedure is ran.
 * 
 * @author Jahanvi Kathiriya
 * @version 1.0       
 * 
 */
public class SummaryReport {
	public static void createSummaryReports(){
		String directoryPath = "SummaryReport/";
        File directory = new File(directoryPath);
        if (!directory.exists()){
            directory.mkdir();
        }
        File file = new File(directory, "SummaryReport");
        
        try {
        	FileWriter writer = new FileWriter(file);
        	
        	for (Map.Entry<Integer, List<ProviderTransaction>> entry : ProviderTransactionFiles.ProviderTransactionMap.entrySet()) {
                Integer ProviderNumber = entry.getKey();
                List<ProviderTransaction> transactions = entry.getValue();
                int fee = 0;
                int numOfConsultaions = 0;
                for (ProviderTransaction transaction : transactions) {
                	fee = fee + transaction.getFee();
                	numOfConsultaions++;
                }
                writer.write("Provider Number:  " + ProviderFiles.searchProvider(ProviderNumber).getProviderNumber() + "\n");
                writer.write("Provider Name:  " + ProviderFiles.searchProvider(ProviderNumber).getName() + "\n");
                writer.write("Number of Consultations:  " + numOfConsultaions + "\n");
                writer.write("Total Fees:  " + fee + "\n");
                writer.write("----------------------------------------\n");
        	}
        	
        	writer.close();
        	System.out.println("Saved successfully.");
        } catch (IOException e) {
        	e.printStackTrace();
        }
	}
}
