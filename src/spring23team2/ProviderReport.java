package spring23team2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * This is the method that creates all Provider Records in the folder ProviderReports
 * 
 * @author Jahanvi Kathiriya
 * @version 1.0       
 * 
 * @throws IOException
 */
public class ProviderReport {
	public static void createProviderReports(){
		String directoryPath = "ProviderReports/";
        File directory = new File(directoryPath);
        if (!directory.exists()){
            directory.mkdir();
        }
        
        for (Map.Entry<Integer, List<ProviderTransaction>> entry : ProviderTransactionFiles.ProviderTransactionMap.entrySet()) {
            Integer ProviderNumber = entry.getKey();
            List<ProviderTransaction> transactions = entry.getValue();
            
            String fileName = String.valueOf(ProviderNumber) + ".txt"; 
            File file = new File(directory, fileName);
        
            try {
                FileWriter writer = new FileWriter(file);
                writer.write("ProviderNumber:  " + String.valueOf(ProviderNumber) + "\n");
                writer.write("ProviderName:  " + ProviderFiles.searchProvider(ProviderNumber).getName() + "\n");
                writer.write("ProviderAddress:  " + ProviderFiles.searchProvider(ProviderNumber).getAddress() + "\n");
                writer.write("ProviderCity:  " + ProviderFiles.searchProvider(ProviderNumber).getCity() + "\n");
                writer.write("ProviderState:  " + ProviderFiles.searchProvider(ProviderNumber).getState() + "\n");
                writer.write("ProviderZipCode:  " + String.valueOf(ProviderFiles.searchProvider(ProviderNumber).getZip()) + "\n");
                writer.write("----------------------------------------\n");
                for (ProviderTransaction transaction : transactions) {
                    writer.write("ServiceDate:  " + transaction.getServiceDate() + "\n");
                    writer.write("RecievedOnDate:  " + transaction.getReceivedDate() + "\n");
                    writer.write("RecievedOnTime:  " + transaction.getReceivedTime() + "\n");
                    writer.write("MemberName:  " + transaction.getMemberName() + "\n");
                    writer.write("MemberNumber:  " + transaction.getMemberNumber() + "\n");
                    writer.write("ServiceCode:  " + transaction.getServiceCode() + "\n");
                    writer.write("FeesToBePaid:  " + transaction.getFee() + "\n");
                    writer.write("----------------------------------------\n");
                }
                writer.close();
                System.out.println("Saved successfully.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
	}
}
