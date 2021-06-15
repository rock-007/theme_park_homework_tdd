import attractions.*;
import behaviours.IReviewed;
import behaviours.ISecurity;
import people.Visitor;
import stalls.CandyflossStall;
import stalls.IceCreamStall;
import stalls.Stall;
import stalls.TobaccoStall;

import java.util.ArrayList;
import java.util.HashMap;

public class ThemePark {

    private String themeParkName;
    public ArrayList<Attraction> allAttractions;
    public ArrayList<Stall> allStalls;


    public ThemePark(String themeParkName) {
        this.themeParkName = themeParkName;
        this.allAttractions = new ArrayList<>();
        this.allStalls = new ArrayList<>();
    }


    public HashMap<String, Integer> allReviews() {
        HashMap<String, Integer> allReviews = new HashMap<>();
        if (this.allAttractions != null) {
            String key;
            Integer value;


            for (Attraction eachAttraction : this.allAttractions) {
                if (eachAttraction instanceof IReviewed) {
                    key = eachAttraction.getName();
                    value = ((IReviewed) eachAttraction).getRating();
                    allReviews.put(key, value);
                }
            }
            for (Stall eachStall : this.allStalls) {
                if (eachStall instanceof IReviewed) {
                    key = eachStall.getName();
                    value = ((IReviewed) eachStall).getRating();
                    allReviews.put(key, value);
                }
            }
        }
        return allReviews;
    }

    public ArrayList<IReviewed> getAllAllowedFor(Visitor visitor){
        ArrayList<IReviewed> allAvailableReviews = getAllReviewed();
        ArrayList<IReviewed> allAllowedReviews = getAllReviewed();
        for (IReviewed eachAvaialableReviewd : allAvailableReviews){
            if(eachAvaialableReviewd instanceof ISecurity && !((ISecurity) eachAvaialableReviewd).isAllowedTo(visitor)){
                allAllowedReviews.remove(eachAvaialableReviewd);
            }

        }
    return allAllowedReviews;
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
