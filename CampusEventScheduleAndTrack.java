/*
   IT-106 Group Project #1 Team 05 Members Alamzeb Aurangzeb, Emanuel Sosa, Husnain Azam, Abdurrahman Sahgir
   This is the Campus Event Scheduler & Energy Tracker Program
   The goal of this program is to showcase the total time consumed by the events, How long it takes to get to each event, how many calories were burned in the process
   and the remaining time left in the rest of a 16 hour day.
      
 */
import javax.swing.JOptionPane;   
   
    
    public class CampusEventScheduleAndTrack {
    
      static int events;
        /*
         NumEvents() was worked on by Alamzeb Aurangzeb
         this method is used to assign the number of events which it limited between 1 to 3 based on project specifcations
        */
        public static int numEvents() {
        
           while(true){
           String inputEvents = JOptionPane.showInputDialog("Please enter the number of events you plan to do today. (Max Events that can be done in a day are 3)");
           int numEvents = Integer.parseInt(inputEvents);
           events = numEvents;
           if(numEvents == 1 || numEvents == 2 || numEvents == 3){
           return numEvents;
           }
           if(numEvents < 1){
                JOptionPane.showMessageDialog(null,"Events cannot be Zero or below.");
            }
            else if(numEvents > 3){
                JOptionPane.showMessageDialog(null,"Events cannot be greater than three.");
           
         }
         }
         }
         /*
         eventDistance() was worked on by Emanuel Sosa. 
         This method is used to assign the distance of the events which is assumes the inputs is in meters.
         */
         public static double eventDistance() {
           final double metersPerSecond = 0.01667;
           double eventDistance = 0;
           double totalDistance = 0;
          
          for (int i = 0; i < events; i++){
           String eventDistanceInput = JOptionPane.showInputDialog("Please enter the distance #" + (i + 1) + " between the events you are attending in meters.");
           eventDistance = Double.parseDouble(eventDistanceInput);
           totalDistance = totalDistance + eventDistance;
         }
           return totalDistance;
         }
         /*
         eventLength() was worked on by Husnain Azam.
         this method is used to assign how long it took to get to the events. The inputs are accepted via minutes and
         cannot be below 0 and cannot go above 16 hours (960 minutes)
         */
         public static double eventLength(int numEvents) {
           int eventlength1 = 0;
           int eventlength2 = 0;
           int eventlength3 = 0;
           int totallength = 0;
           while(eventlength1 <=0 || eventlength1 > 960){
         if(events >= 1){
         String eventlength1Input = JOptionPane.showInputDialog("Please enter the length of event 1.");
         eventlength1 = Integer.parseInt(eventlength1Input);
         }
         if (eventlength1 <= 0){
               JOptionPane.showMessageDialog(null,"Error - Event length cannot be 0 or below");
         }else if (eventlength1 > 960) {
               JOptionPane.showMessageDialog(null,"Event length shall not be greater than 960 minutes");
         }else{
         totallength = totallength + eventlength1;
         }
         }
         
          while((numEvents > 1) && (eventlength2 <=0 || eventlength1 > 960)){
         if(events >= 2){
         String eventlength2Input = JOptionPane.showInputDialog("Please enter the length of event 2.");
         eventlength2 = Integer.parseInt(eventlength2Input);
         }
         if (eventlength2 <= 0){
             JOptionPane.showMessageDialog(null,"Error - Event length cannot be 0 or below");
          } else if (eventlength2 > 960) {
             JOptionPane.showMessageDialog(null,"Event length shall not be greater than 960 minutes");
         }  else {
         totallength = totallength + eventlength2;
         }
         }
          while((numEvents > 2) && (eventlength3 <=0 || eventlength3 > 960)){
         if(events == 3){
         String eventlength3Input = JOptionPane.showInputDialog("Please enter the length of event 3.");
         eventlength3 = Integer.parseInt(eventlength3Input);
         }
         if (eventlength3 <= 0){
               JOptionPane.showMessageDialog(null,"Error - Event length cannot be 0 or below");
          } else if (eventlength3 > 960) {
             JOptionPane.showMessageDialog(null,"Event length shall not be greater than 960 minutes");
            }else{
            totallength = totallength + eventlength3;
         }
         }
         
          return totallength;
         }
         
        /*
        calcTotalEventTime was worked on by Abdurrahman Sahgir
        this method is used to calculate the total time of all the events.
        */
        public static double calcTotalEventTime(double eventLength) {
            double totalEventTime = eventLength;

            return totalEventTime;
        }
         /*
         calcTravelTime was worked on by Abdurrahman Sahgir
         This method is used the calculate the total time it took to get to each event.
         */
        public static double calcTravelTime(double eventDistance) {
            final double metersPerSecond = 1.5;
            double totalDistance = eventDistance;

            totalDistance = totalDistance / metersPerSecond;
            totalDistance = totalDistance / 60;
            
            return totalDistance;
        }
        /*
        calcCaloriesBurned was worked on by Abdurrahman Sahgir
        this method is used to calculate the total amount of calories burned based on the total distance travelled.
        */
        public static double calcCaloriesBurned(double eventDistance) {
            final double caloriePerMeter = 0.05;
            double caloriesBurned = eventDistance * caloriePerMeter;

            return caloriesBurned;
        }
        /*
        calcFreeTime was worked on by Abdurrahman Sahgir
        this method is used the calculate the amount of free time left after traveling and completing all the events.
        */
        public static double calcFreeTime(double totalEventTime, double travelTime) {
            return 960 - totalEventTime - travelTime;
        }
        /*
        this is the main method that runs the program and uses all the methods that were created
        */
        public static void main(String[] args) {
           
            int numEvents = numEvents();

            double lengths = eventLength(numEvents);
            double distances = eventDistance();

            double totalEventTime = calcTotalEventTime(lengths);
            double travelTime = calcTravelTime(distances);
            double caloriesBurned = calcCaloriesBurned(distances);
            double freeTime = calcFreeTime(totalEventTime, travelTime);

            JOptionPane.showMessageDialog(null, String.format("Total Event Time: %.1f minutes\n" + "Travel Time: %.1f minutes\n" + "Calories Burned: %.1f calories\n" + "Free Time: %.1f minutes\n", totalEventTime, travelTime, caloriesBurned, freeTime));
        }
    }
