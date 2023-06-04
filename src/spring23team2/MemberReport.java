package spring23team2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * This is the method that creates all member Records in the folder MemberReports.
 * 
 * @author Jahanvi Kathiriya
 * @version 1.0
 * 
 * @throws IOException
 */
public class MemberReport {
	public static void createMemberReports(){
		String directoryPath = "MemberReports/";
        File directory = new File(directoryPath);
        if (!directory.exists()){
            directory.mkdir();
        }
        
        for (Map.Entry<Integer, List<MemberTransaction>> entry : MemberTransactionFiles.MemberTransactionMap.entrySet()) {
            Integer memberNumber = entry.getKey();
            List<MemberTransaction> transactions = entry.getValue();
            
            String fileName = String.valueOf(memberNumber) + ".txt"; 
            File file = new File(directory, fileName);
        
            try {
                FileWriter writer = new FileWriter(file);
                writer.write("MemberNumber:  " + String.valueOf(memberNumber) + "\n");
                writer.write("MemberName:  " + MemberFiles.searchMember(memberNumber).getName() + "\n");
                writer.write("MemberAddress:  " + MemberFiles.searchMember(memberNumber).getAddress() + "\n");
                writer.write("MemberCity:  " + MemberFiles.searchMember(memberNumber).getCity() + "\n");
                writer.write("MemberState:  " + MemberFiles.searchMember(memberNumber).getState() + "\n");
                writer.write("MemberZipCode:  " + String.valueOf(MemberFiles.searchMember(memberNumber).getZip()) + "\n");
                writer.write("----------------------------------------\n");
                for (MemberTransaction transaction : transactions) {
                    writer.write("ServiceDate:  " + transaction.getServiceDate() + "\n");
                    writer.write("ProviderName:  " + transaction.getProviderName() + "\n");
                    writer.write("ServiceName:  " + transaction.getServiceName() + "\n");
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
