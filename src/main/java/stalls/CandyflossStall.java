package stalls;

import behaviours.IReviewed;

public class CandyflossStall extends Stall implements IReviewed {

    public CandyflossStall(String name, String ownerName, ParkingSpot parkingSpot) {
        super(name, ownerName, parkingSpot);
    }


    @Override
    public int getRating() {
        return 0;
    }
//    public String getName(){
//        return super.getName();
//    }
}
