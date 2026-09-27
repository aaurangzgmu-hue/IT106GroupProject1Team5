import java.util.Scanner;   
    
    public class CampusEventScheduleAndTrack {
    
      static int events;
    
        public static int numEvents() {
         
           Scanner scnr = new Scanner(System.in);
           while(true){
           System.out.println("Please enter the number of events you plan to do today. (Max Events that can be done in a day are 3)");
           int numEvents = scnr.nextInt(); 
           events = numEvents;
           if(numEvents == 1 || numEvents == 2 || numEvents == 3){
           return numEvents;
           }
           if(numEvents < 1){
                System.out.println("Events cannot be Zero or below.");
            }
            else if(numEvents > 3){
                System.out.println("Events cannot be greater than three.");
           
         }
         }
         }
         
         public static double[] eventDistance() {
           Scanner scnr = new Scanner(System.in);
           final double metersPerSecond = 0.01667;
           double[] eventDistance = new double[3];
          
          for (int i = 0; i < events; i++){
           System.out.println("Please enter the distance #" + (i + 1) + " between the events you are attending in meters.");
           eventDistance[i] = scnr.nextInt();
         }
           return eventDistance;
         }
         
         public static double[] eventLength() {
           Scanner scnr = new Scanner(System.in);
           int eventlength1 = 0;
           int eventlength2 = 0;
           int eventlength3 = 0;
         
         if(events >= 1){
         System.out.println("Please enter the length of event 1.");
         eventlength1 = scnr.nextInt();
         }
         if (eventlength1 <= 0){
               System.out.println("Error - Event length cannot be 0 or below");
         } else if (eventlength1 > 960) {
               System.out.println("Event length shall not be greater than 960 minutes");

         }
         
         if(events >= 2){
         System.out.println("Please enter the length of event 2.");
         eventlength2 = scnr.nextInt();
         }
         if (eventlength2 <= 0){
             System.out.println("Error - Event length cannot be 0 or below");
          } else if (eventlength2 > 960) {
               System.out.println("Event length shall not be greater than 960 minutes");

         }

         if(events == 3){
         System.out.println("Please enter the length of event 3.");
         eventlength3 = scnr.nextInt();
         }
         if (eventlength3 <= 0){
               System.out.println("Error - Event length cannot be 0 or below");
          } else if (eventlength3 > 960) {
             System.out.println("Event length shall not be greater than 960 minutes");

            }
         
          return new double[]{eventlength1,eventlength2,eventlength3};
         }
         

        public static double calcTotalEventTime(double[] eventLength) {
            double x = eventLength[0];
            double y = eventLength[1];
            double z = eventLength[2];
            double totalEventTime = x + y + z;

            return totalEventTime;
        }

        public static double calcTravelTime(double[] eventDistance) {
            final double metersPerSecond = 1.5;
            double x = eventDistance[0];
            double y = eventDistance[1];
            double z = eventDistance[2];
            double totalDistance = x + y + z;

            totalDistance = totalDistance / metersPerSecond;
            totalDistance = totalDistance / 60;
            
            return totalDistance;
        }

        public static double calcCaloriesBurned(double[] eventDistance) {
            final double caloriePerMeter = 0.05;
            double x = eventDistance[0];
            double y = eventDistance[1];
            double z = eventDistance[2];
            double caloriesBurned = (x + y + z) * caloriePerMeter;

            return caloriesBurned;
        }

        public static double calcFreeTime(double totalEventTime, double travelTime) {
            return 960 - totalEventTime - travelTime;
        }

        public static void main(String[] args) {
           
            int numEvents = numEvents();

            double[] lengths = eventLength();
            double[] distances = eventDistance();

            double totalEventTime = calcTotalEventTime(lengths);
            double travelTime = calcTravelTime(distances);
            double caloriesBurned = calcCaloriesBurned(distances);
            double freeTime = calcFreeTime(totalEventTime, travelTime);

             System.out.printf("Total Event Time: %.1f minutes%n", totalEventTime);
             System.out.printf("Travel Time: %.1f minutes%n", travelTime);
             System.out.printf("Calories Burned: %.1f calories%n", caloriesBurned);
             System.out.printf("Free Time: %.1f minutes%n", freeTime);
        }
    }
