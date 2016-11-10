import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class checkFraud {
	
	private HashMap<String,HashSet<String>> friendMap;
	
	public checkFraud(HashMap<String,HashSet<String>> map){
		this.friendMap = map;
	}
	//Feature1: check direct friend relation
	public String isFriend (String id1, String id2) {
		
		String sender = id1;
		String receiver = id2;
		String fraudFlag = "Unverified";
		
        if(!(sender.equals(" id1")) && !(receiver.equals(" id2"))){
            
        	if(friendMap.containsKey(sender)==true){
            	if(friendMap.get(sender).contains(receiver)==true){
            		fraudFlag = "Trusted";
            	}     	
            }
        }

        return fraudFlag;
	}
	
	
	//Feature2: check 2nd-degree friend relation
	public String is2ndDegreeFriend (String id1, String id2) {
              
		String sender = id1;
		String receiver = id2;
		String fraudFlag = "Unverified";
      
		if(!(sender.equals(" id1")) && !(receiver.equals(" id2"))){
	            if(friendMap.containsKey(sender)==true){
	                if(friendMap.get(sender).contains(receiver)==true){
	                	fraudFlag = "Trusted";
	                }else if(friendMap.get(sender).contains(receiver)==false){
	                	Iterator index = friendMap.get(sender).iterator();
	                	while (index.hasNext()){
	                		Object idx = index.next();
	                		if(friendMap.get(idx).contains(receiver)==true){
	                			fraudFlag = "Trusted";
	                		}
	                	}
	                }
	                	
	            }
		}

		return fraudFlag;
	           
	}     
	
	//Feature3: check 4th-degree friend relation
	public String is4thDegreeFriend (String id1, String id2) {
		
		String sender = id1;
		String receiver = id2;
		String fraudFlag = "Unverified";
      
		if(!(sender.equals(" id1")) && !(receiver.equals(" id2"))){
            if(friendMap.containsKey(sender)==true){
                if(friendMap.get(sender).contains(receiver)==true){
                	fraudFlag = "Trusted";
                }else if(friendMap.get(sender).contains(receiver)==false){
                	Iterator index2nd = friendMap.get(sender).iterator();
                	while (index2nd.hasNext()){
                		Object idx2nd = index2nd.next();
                		if(friendMap.get(idx2nd).contains(receiver)==true){
                			fraudFlag = "Trusted";
                		}else if(friendMap.get(idx2nd).contains(receiver)==false){
    	                	Iterator index3rd = friendMap.get(idx2nd).iterator();
    	                	while (index3rd.hasNext()){
    	                		Object idx3rd = index3rd.next();
    	                		if(friendMap.get(idx3rd).contains(receiver)==true){
    	                			fraudFlag = "Trusted";
    	                		}else if(friendMap.get(idx3rd).contains(receiver)==false){
    	    	                	Iterator index4th = friendMap.get(idx3rd).iterator();
    	    	                	while (index4th.hasNext()){
    	    	                		Object idx4th = index4th.next();
    	    	                		if(friendMap.get(idx4th).contains(receiver)==true){
    	    	                			fraudFlag = "Trusted";
    	    	                		}
    	    	                	}
    	    	                }
    	                	}
    	                }
                	}
                }
                	
            }
		}

		return fraudFlag;
		

	}   

}
