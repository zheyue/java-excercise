import java.util.*;

public class Exercise11_1 {
	public static void main (String[] args) {
		
		HashMap<Integer, String> map = new HashMap<>();
		
		map.put(Integer.decode("0XFF0000"), "RED");
		map.put(Integer.decode("0X008000"), "GREEN");
		map.put(Integer.decode("0X0000FF"), "BLUE");
		map.put(Integer.decode("0X000000"), "BLACK");
		map.put(Integer.decode("0XFFFFFF"), "WHITE");
		map.put(Integer.decode("0X800080"), "PURPLE");
		
		Set <Map.Entry<Integer,String>> set = map.entrySet();
		Iterator <Map.Entry<Integer, String>> it = set.iterator();
		
		while(it.hasNext()) {
			Map.Entry<Integer, String> a = it.next();
			System.out.printf("Key: %-10d Value: %s%n", a.getKey(),a.getValue());
			
			
			
			
		}
		
	}
}
