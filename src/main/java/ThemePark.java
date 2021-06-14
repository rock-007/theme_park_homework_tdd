import attractions.*;
import behaviours.IReviewed;
import people.Visitor;
import stalls.CandyflossStall;
import stalls.IceCreamStall;
import stalls.Stall;
import stalls.TobaccoStall;

import java.util.ArrayList;

public class ThemePark {

    private String themeParkName;
    //    private Playground playground;
//    private Dodgems dosgems;
//    private Park park;
//    private RollerCoaster rollerCoaster;
//    private CandyflossStall candyflossStall;
//    private IceCreamStall iceCreamStall;
//    private TobaccoStall tobaccoStall;
    public ArrayList<Attraction> allAttractions;
    public ArrayList<Stall> allStalls;


    public ThemePark(String themeParkName) {
        this.themeParkName = themeParkName;
        this.allAttractions = new ArrayList<>();
        this.allStalls = new ArrayList<>();
    }

    public ArrayList<IReviewed> getAllReviewed() {
        ArrayList<IReviewed> allReviewedObjects = new ArrayList<>();
        if (this.allAttractions != null) {


            for (Attraction eachAttraction : this.allAttractions) {
                if (eachAttraction instanceof IReviewed) {
                    System.out.println("sdsa");
                    allReviewedObjects.add((IReviewed) eachAttraction);
                }
            }
            for (Stall eachStall : this.allStalls) {
                if (eachStall instanceof IReviewed) {
                    allReviewedObjects.add((IReviewed) eachStall);
                }
            }
        }
        return allReviewedObjects;
    }


    public void visit(Visitor visitor, Attraction attraction) {

        for (Attraction eachAttraction : allAttractions) {
            if (eachAttraction.getName().equals(attraction.getName())) {
                eachAttraction.incrementVisitCount();
                visitor.setVisitedAttractions(eachAttraction);
            }
        }

    }


    public void setAttraction(Attraction attraction) {
        allAttractions.add(attraction);

    }


    public void setStall(Stall stall) {
        allStalls.add(stall);
    }

}
