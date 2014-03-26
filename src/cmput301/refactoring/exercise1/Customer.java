package cmput301.refactoring.exercise1;
import java.util.Vector;

public class Customer {
	/**
	 * @uml.property  name="_name"
	 */
	public String _name;
	/**
	 * @uml.property  name="_rentals"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="Rental"
	 */
	public Vector _rentals;

	public Customer (String name) {
		_name = name;
	}

	public void addRental(Rental arg) {
		_rentals.addElement(arg);
	}

	public String getName() {
		return _name;
	}
}
