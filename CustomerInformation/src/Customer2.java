
public class Customer2 {
	
		private StringBuilder lastName= new StringBuilder();
		private StringBuilder firstName= new StringBuilder();
		
		
		
		public String getName() {
			
		 if(lastName.length() != 0 && firstName.length() != 0)
				   return lastName + ", " + firstName;
		 else if(lastName.length() != 0)
				   return lastName.toString();
		 else
				   return "";
		}
		public void setName(String name){
			
			lastName.setLength(0);
			firstName.setLength(0);  
			if( name != null && name.length() > 0 ) {
				       name = name.trim();
			lastName.insert(0, name.substring(0, name.indexOf(',')));
		    firstName.insert(0, name.substring(lastName.length()+2));
			     	
			 }
			
			
			 
		}
	}

