import attractions.*;
import org.junit.Before;
import org.junit.Test;
import people.Visitor;
import stalls.CandyflossStall;
import stalls.IceCreamStall;
import stalls.ParkingSpot;
import stalls.TobaccoStall;

import static org.junit.Assert.assertEquals;

public class ThemeParkTest {


    Playground playground;
    Dodgems dosgems;
    Park park;
    RollerCoaster rollerCoaster;
    CandyflossStall candyflossStall;
    IceCreamStall iceCreamStall;
    TobaccoStall tobaccoStall;
    ThemePark themepark1;
    Visitor visitor1;

    @Before

    public void before() {
        playground = new Playground("Edinburgh PlayGround", 5);
        dosgems = new Dodgems("abc", 4);
        park = new Park("Edinburgh Park", 3);
        rollerCoaster = new RollerCoaster("RollerCoaster1", 3);
        candyflossStall = new CandyflossStall("CandyflossStall1", "Adam", ParkingSpot.A4);
        iceCreamStall = new IceCreamStall("IceCreamStall1", "John", ParkingSpot.B1);
        tobaccoStall = new TobaccoStall("TobaccoStall1", "Alex", ParkingSpot.B4);
        themepark1 = new ThemePark("ThemePark1");
        visitor1 = new Visitor(34, 170, 34);

    }


    @Test
    public void getAllReviews() {
        themepark1.setAttraction(dosgems);
        themepark1.setStall(tobaccoStall);
        assertEquals(2, themepark1.getAllReviewed().size());

    }

    @Test
    public void visit() {
        themepark1.setAttraction(dosgems);
        themepark1.setStall(tobaccoStall);
        themepark1.visit(visitor1, dosgems);

        assertEquals(true,visitor1.getVisitedAttractions().contains(dosgems) );

    }
}
