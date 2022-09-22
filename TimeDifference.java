import java.util.Scanner;

public class TimeDifference
{
    
    /**
     * Constructor for objects of class timeDifference
     */
    public TimeDifference()
    {
    }

    /**
     * a public static function that takes two Strings as two times in military format (hhmm) and
prints the number of hours and minutes between the two times. If the first time is later than the
second time, assume the second time is the next day (i.e., add 24 hours to the second time).
     */
    public static void printTimeDifference()
    {
        System.out.println("Please put in first time: ");
        Scanner scanTime1 = new Scanner(System.in);
        String input1 = scanTime1.nextLine();
        System.out.println("Please enter a second time: ");
        Scanner scanTime2 = new Scanner(System.in);
        String input2 = scanTime2.nextLine();

        try{
            int timeOneHours = Integer.parseInt(input1.substring(0,2));
            if(timeOneHours < 0 || timeOneHours > 23){
                scanTime1.close();
                scanTime2.close();
                throw new IllegalArgumentException("enter hours between 0 and 24!");
            }
            int timeOneMinutes = Integer.parseInt(input1.substring(2, 4));
            if(timeOneMinutes < 0 || timeOneMinutes > 59){
                scanTime1.close();
                scanTime2.close();
                throw new IllegalArgumentException("enter minutes between 0 and 60!");
            }
            int timeTwoHours = Integer.parseInt(input2.substring(0, 2));
            if(timeTwoHours < 0 || timeTwoHours > 23){
                scanTime1.close();
                scanTime2.close();
                throw new IllegalArgumentException("enter hours between 0 and 24!");
            }
            int timeTwoMinutes = Integer.parseInt(input2.substring(2, 4));
            if(timeTwoMinutes < 0 || timeTwoMinutes > 59){
                scanTime1.close();
                scanTime2.close();
                throw new IllegalArgumentException("enter minutes between 0 and 60!");
            }
            String differenceInHours = "";
            String differenceInMinutes = "";
            double totalTime1 = timeOneHours + ((double) timeOneMinutes / 60);
            double totalTime2 = timeTwoHours + ((double) timeTwoMinutes / 60);

            if (totalTime1 > totalTime2){
                timeTwoHours += 24;
                differenceInHours = Integer.toString(timeTwoHours - timeOneHours);
                if (timeTwoMinutes >= timeOneMinutes){
                    differenceInMinutes = Integer.toString(timeTwoMinutes - timeOneMinutes);
                }
                else{
                    differenceInHours = Integer.toString(timeTwoHours - (timeOneHours + 1));
                    differenceInMinutes = Integer.toString((timeTwoMinutes + 60) - timeOneMinutes);
                }
            }

            if(totalTime2 > totalTime1){
                differenceInHours = Integer.toString(timeTwoHours - timeOneHours);
                if (timeTwoMinutes >= timeOneMinutes){
                    differenceInMinutes = Integer.toString(timeTwoMinutes - timeOneMinutes);
                }
                else{
                    differenceInHours = Integer.toString(timeTwoHours - (timeOneHours + 1));
                    differenceInMinutes = Integer.toString((timeTwoMinutes + 60) - timeOneMinutes);
                }
            }

            if(timeOneHours == timeTwoHours && timeOneMinutes == timeTwoMinutes){
                differenceInHours = Integer.toString(timeTwoHours - timeOneHours);
                differenceInMinutes = Integer.toString(timeTwoMinutes - timeOneMinutes);
            }

            System.out.println(differenceInHours + " hour(s) " + differenceInMinutes + " minute(s)" );
        scanTime1.close();
        scanTime2.close();
        
        }
        
         catch (NumberFormatException bad_input){
            System.out.println("please type a valid integer!");
            
        }

        catch (IllegalArgumentException bad_input2){
            System.out.println("please type hours and times that are in the valid hour and minute intervals. You can read time right?");
            
        }
    }

    public static void main(String args[])  {
        TimeDifference.printTimeDifference();
    }
}