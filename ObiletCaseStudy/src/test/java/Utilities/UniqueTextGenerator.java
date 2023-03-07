package Utilities;

import java.util.UUID;

public class UniqueTextGenerator {
	
	 public static String getUniqueId() {
         return String.format("%s_%s", UUID.randomUUID().toString().substring(0, 5), "test");
     }
	 
	 public static String generateRandomEmail() {
	        return String.format("%s@%s", getUniqueId(), "gmail.com");
	    }

}
