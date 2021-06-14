package behaviours;

import people.Visitor;

public interface ITicketed {


    public double defaultPRice();

    public double priceFor(Visitor visitor);
}
