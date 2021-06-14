package attractions;

import behaviours.ITicketed;
import people.Visitor;

public class Dodgems extends Attraction implements ITicketed {

    public Dodgems(String name, int rating) {
        super(name, rating);
    }

    @Override
    public double defaultPRice() {
        return 4.50;
    }

    @Override
    public double priceFor(Visitor visitor) {
        if (visitor.getAge() < 12) {
            return defaultPRice() / 2.00;
        } else {
            return defaultPRice();
        }
    }
}
