package recursion;

public class TowerOfHanoi {

    public static void main(String[] args) {
        int numberOfPlates=3;
        int sourcePlateNumber=1;
        int helperPlateNumber=2;
        int destinationPlateNumber=3;
        solve(sourcePlateNumber,destinationPlateNumber,helperPlateNumber,numberOfPlates);

        int numberOfMoves=solveStepCount(sourcePlateNumber,destinationPlateNumber,helperPlateNumber,numberOfPlates);

        System.out.println("Total steps required: "+numberOfMoves);
    }

    private static void solve(int sourcePlateNumber, int destinationPlateNumber, int helperPlateNumber, int numberOfPlates) {


        if(numberOfPlates==1){
            System.out.println("moving plate"+numberOfPlates+" from "+ sourcePlateNumber+" "+destinationPlateNumber);
            return;
        }
        solve(sourcePlateNumber,helperPlateNumber,destinationPlateNumber,(numberOfPlates-1));

        System.out.println("moving plate"+numberOfPlates+" from "+ sourcePlateNumber+" "+destinationPlateNumber);

        solve(helperPlateNumber,destinationPlateNumber,sourcePlateNumber,(numberOfPlates-1));

        return;
    }

    private static int solveStepCount(int sourcePlateNumber, int destinationPlateNumber, int helperPlateNumber, int numberOfPlates) {

        if(numberOfPlates==1){
            return 1;
        }
        int count = 1+ solveStepCount(sourcePlateNumber,helperPlateNumber,destinationPlateNumber,(numberOfPlates-1));

        count+=solveStepCount(helperPlateNumber,destinationPlateNumber,sourcePlateNumber,(numberOfPlates-1));

        return count;
    }
}
