package spring23team2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * This is a hash map that creates all member Records when accounting procedure is ran.
 * 
 * @author Jahanvi Kathiriya
 * @version 1.0       
 * 
 */
public class MemberReport {
	public static void createMemberReports(){
		String directoryPath = "MemberReports/";
        File directory = new File(directoryPath);
        if (!directory.exists()){
            directory.mkdir();
        }
        System.out.println("Directory.");
        for (Map.Entry<Integer, List<MemberTransaction>> entry : MemberTransactionFiles.MemberTransactionMap.entrySet()) {
            Integer memberNumber = entry.getKey();
            List<MemberTransaction> transactions = entry.getValue();
            Properties prop = new Properties();
            String fileName = String.valueOf(memberNumber) + ".xml"; 
            File file = new File(directory, fileName);
        
            prop.setProperty("MemberNumber", String.valueOf(memberNumber));
            prop.setProperty("MemberName", MemberFiles.searchMember(memberNumber).getName());
            prop.setProperty("MemberAddress", MemberFiles.searchMember(memberNumber).getAddress());
            prop.setProperty("MemberCity", MemberFiles.searchMember(memberNumber).getCity());
            prop.setProperty("MemberState", MemberFiles.searchMember(memberNumber).getState());
            prop.setProperty("MemberZipCode", String.valueOf(MemberFiles.searchMember(memberNumber).getZip()));
            prop.setProperty("MemberZipCode", String.valueOf(MemberFiles.searchMember(memberNumber).getZip()));
            
            for (MemberTransaction transaction : transactions) {
                prop.setProperty("ServiceDate", transaction.getServiceDate());
                prop.setProperty("ProviderName", transaction.getProviderName());
                prop.setProperty("ServiceName", transaction.getServiceName());
            }
            System.out.println("hi   ");
            try {
                FileOutputStream fileOut = new FileOutputStream(file);
                prop.storeToXML(fileOut, "Member Report");
                fileOut.close();
                System.out.println("Saved successfully.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
	}
}
