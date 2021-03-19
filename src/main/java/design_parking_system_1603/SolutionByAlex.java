package design_parking_system_1603;

public class SolutionByAlex {

    private static int bigPool;
    private static   int mediumPool;
    private static int smallPool;
    public SolutionByAlex(int big, int medium, int small) {
        //test11112
        this.bigPool = big;
        this.mediumPool = medium;
        this.smallPool = small;

    }

    public boolean addCar(int carType) {
        switch (carType){
            case 3:
                if(smallPool > 0){
                    smallPool --;
                    return true;
                }
                break;
            case 2:
                if(mediumPool > 0){
                    mediumPool --;
                    return true;
                }
                break;
            case 1:
                if(bigPool > 0){
                    bigPool --;
                    return true;
                }
                break;
            default:
                return false;
        }
        return false;
    }

}
