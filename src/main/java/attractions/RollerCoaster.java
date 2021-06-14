package attractions;

import behaviours.ISecurity;
import behaviours.ITicketed;
import people.Visitor;

public class RollerCoaster extends Attraction implements ITicketed, ISecurity {

    public RollerCoaster(String name, int rating) {
        super(name, rating);
    }

    @Override
    public double defaultPRice() {
        return 8.40;
    }

    @Override
    public double priceFor(Visitor visitor) {

        if (visitor.getHeight() > 200) {
            return defaultPRice() * 2.00;
        } else {
            return defaultPRice();
        }
    }

    @Override
    public boolean isAllowedTo(Visitor visitor) {
        return visitor.getAge() > 12 && visitor.getHeight() > 145;
    }
}
