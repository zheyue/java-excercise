
public class TrySplit {
	
		
		private StringBuilder lastName= new StringBuilder();
		private StringBuilder firstName= new StringBuilder();
	
		public void setName(String name){
	    
		String[] tokens;
		if( lastName.length() != 0 && firstName.length() != 0 ) {
			       name = name.trim();
			 if(name.contains(", ")) {
				tokens = name.split(" ,");
			if(tokens.length >= 0)	
				lastName = tokens[0];
			else 
				lastName = "";
			if(tokens.length >=1)
				firstName = tokens[1];
			else
				firstName ="";
				
			 }
		lastName.insert(0, name.substring(0, name.indexOf(',')));
	    firstName.insert(0, name.substring(lastName.length()+2));
		     	
		 }
	}
}
