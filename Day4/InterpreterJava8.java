package aPatternsCode;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

class ProductFinder1 {
	List<Product> all = new LinkedList<Product>();
	List<Product> selectBy(Predicate<Product> condition) {
		return all.stream().filter(condition).toList();
	}
}

public class InterpreterJava8 {
	private static void printAllProducts(final List<Product> ps) {
		int i = 0;
		for (Product p : ps)
			System.out.printf("%d %s%n", ++i, p);
	}
	public static void main(final String[] args) {
		var pf = new ProductFinder1();
		pf.all.add(new Product(10, 100, 3));
		pf.all.add(new Product(11, 500, 3));
		pf.all.add(new Product(12, 400, 3));
		//printAllProducts(pf.belowPriceAvoidingAColor(450, 12));
		Predicate<Product> colorSpec = p -> p.color == 12;
		Predicate<Product> belowPrice = p -> p.price < 450;
		printAllProducts(pf.selectBy(belowPrice.and(colorSpec.negate())));
	}
}
