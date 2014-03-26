package cmput301.refactoring.exercise1;

import java.util.Enumeration;
import java.util.Vector;

public class RentalCharge {

	public String statement(Customer theCustomer, Vector theRentals) {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Enumeration rentals = theRentals.elements();
		String result = "Rental Record for " + theCustomer.getName() + "\n";
		while(rentals.hasMoreElements()) {
			Rental each = (Rental)rentals.nextElement();

			//determine amounts for each line
			double thisAmount = amountFor(each);

			//add frequent renter points
			if(each.getMovie().getPriceCode() == Movie.NEW_RELEASE && each.getDaysRented() > 1)
				frequentRenterPoints += 2;
			else
				frequentRenterPoints++;

			//show figures for this rental
			result += "\t" + each.getMovie().getTitle() + "\t" +
			String.valueOf(thisAmount) + "\n";
			totalAmount += thisAmount;
		}

		//add footer lines
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints) +
		" frequent renter points";
		return result;
	}

    private double amountFor(Rental aRental) {
        return getCharge(aRental);
    }

    public double getCharge(Rental aRental) {
        double result = 0;
        switch(aRental.getMovie().getPriceCode()) {
            case Movie.REGULAR:
               result += 2;
               if (aRental.getDaysRented() > 2)
                  result += (aRental.getDaysRented() - 2) * 1.5;
                  break;
            case Movie.NEW_RELEASE:
                result += aRental.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                result += 1.5;
                if (aRental.getDaysRented() > 3)
                    result += (aRental.getDaysRented() - 3) * 1.5;
                break;
            }
        return result;
    }
}