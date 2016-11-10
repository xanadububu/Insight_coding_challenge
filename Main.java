import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * For Insight coding challenge - digital wallet
 * 
 * @author Zhiwei Xiao
 *
 */


public class Main {

	public static void main(String[] args) throws FileNotFoundException  {

		//Input and output files
		String paymentHistory = args[0];
		String paymentStream = args[1];
		String feature1Output = args[2];
		String feature2Output = args[3];
		String feature3Output = args[4];
		
		//Generate friend relation map from payment history
		FriendMap fMap = new FriendMap();
		HashMap<String,HashSet<String>> friendMap = new HashMap<String,HashSet<String>>();
		friendMap = fMap.buildFriendMap(paymentHistory);
		
		//Anti-fraud check
		FileInputStream inputStream = new FileInputStream(paymentStream);
		FileOutputStream outputFile1 = new FileOutputStream(feature1Output);
		FileOutputStream outputFile2 = new FileOutputStream(feature2Output);
		FileOutputStream outputFile3 = new FileOutputStream(feature3Output);
		Scanner inputScanner = new Scanner(inputStream);
		PrintStream outputStream1 = new PrintStream(outputFile1);
		PrintStream outputStream2 = new PrintStream(outputFile2);
		PrintStream outputStream3 = new PrintStream(outputFile3);
		checkFraud ckFraud = new checkFraud(friendMap);
		
		while(inputScanner.hasNext()){
            String line = inputScanner.nextLine();
            System.out.println(line);
            String[] columns = line.split(",");
            if(columns.length<3){
               continue;
            }
        	String id1 = columns[1];
            String id2 = columns[2];
            if(!(id1.equals(" id1")) && !(id2.equals(" id2"))){
	            //Feature1 direct friend check
            	String fraudFlag1 = ckFraud.isFriend(id1, id2);
	            outputStream1.println(fraudFlag1);
	            //Feature2 2nd-degree friend check
	            String fraudFlag2 = ckFraud.is2ndDegreeFriend(id1, id2);
	            outputStream2.println(fraudFlag2);
	            //Feature4 4th-degree friend check
	            String fraudFlag3 = ckFraud.is4thDegreeFriend(id1, id2);
	            outputStream3.println(fraudFlag3);
            }
		}
	
		inputScanner.close();
        outputStream1.close();
        outputStream2.close();
        outputStream3.close();
        
       
        }

}
