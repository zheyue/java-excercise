import java.util.Comparator;

public class TreeMapCompartor implements Comparator<String>{
	@Override
	public int compare(String left, String right) {
		return left.compareToIgnoreCase(right);
	}
}
