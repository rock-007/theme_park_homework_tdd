package attractions;

import behaviours.IReviewed;
import behaviours.ITicketed;
import people.Visitor;

public class Dodgems extends Attraction implements ITicketed, IReviewed {

    public Dodgems(String name, int rating) {
        super(name, rating);
    }

    @Override
    public double defaultPRice() {
        return 4.50;
    }

    @Override
    public double priceFor(Visitor visitor) {

        return visitor.getAge() < 12 ? defaultPRice() / 2.00 : defaultPRice();

    }
}
