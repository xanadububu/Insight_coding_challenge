import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;


public class FriendMap {
   
	private HashMap<String,HashSet<String>> friendMap;
	
	public FriendMap(){
		this.friendMap = new HashMap<String,HashSet<String>>();
	}

	//Generating friend relation map from payment history
	//Only saved direct (1st-degree) friends
	public HashMap<String,HashSet<String>> buildFriendMap(String inputFile){
		String paymentRecord = inputFile;

		try{
			FileInputStream prStream = new FileInputStream(paymentRecord);
			Scanner prScanner = new Scanner(prStream);
			while(prScanner.hasNextLine()){
		    	
		        String line = prScanner.nextLine();
		        System.out.println(line);
		        String[] columns = line.split(",");
		           if(columns.length<3){
		              continue;
		           }
		    	String sender = columns[1];
		        String receiver = columns[2];
		        
		        if(!(sender.equals(" id1")) && !(receiver.equals(" id2"))){
		        	if(friendMap.containsKey(sender)==false){
		        		friendMap.put(sender,new HashSet<String>());
		        	}
		        	friendMap.get(sender).add(receiver);
		
		        	if(friendMap.containsKey(receiver) ==false){
		        		friendMap.put(receiver,new HashSet<String>());
		        	}
		        	friendMap.get(receiver).add(sender);
		        		
		        }
		    }
			prScanner.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return friendMap;
	}
}
