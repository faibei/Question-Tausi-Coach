import java.text.SimpleDateFormat;
import java.util.Date;

public class TausiCoachJourney {

    public static void main(String[] args) {
        // Constants
        int totalDistance = 10000; // distance in kilometers
        int offloadLoadInterval = 150; // distance interval for offloading/loading in km
        int refuelInterval = 200; // distance interval for refueling in km
        int speedKmPerHr = 250; // speed in Km/hr
        int stopTimeMinutes = 5; // time taken at each stop in minutes
        double secondCoachSpeedMPerS = 225.5; // speed of the second coach in m/s
        
        // (i) Calculate number of stops
        int offloadLoadStops = totalDistance / offloadLoadInterval;
        int refuelStops = totalDistance / refuelInterval;
        int totalStops = offloadLoadStops + refuelStops;

        System.out.println("Number of offloading/loading stops: " + offloadLoadStops);
        System.out.println("Number of refueling stops: " + refuelStops);
        System.out.println("Total number of stops: " + totalStops);

        // (ii) Calculate total time including stops
        double travelTimeHours = (double) totalDistance / speedKmPerHr;
        double stopTimeHours = (totalStops * stopTimeMinutes) / 60.0;
        double totalTimeHours = travelTimeHours + stopTimeHours;

        System.out.println("Total time taken including stops: " + totalTimeHours + " hours");

        // (iii) Calculate time for the return journey with refueling stops only
        int refuelStopsReturn = totalDistance / refuelInterval;
        double totalStopTimeReturnHours = (refuelStopsReturn * stopTimeMinutes) / 60.0;
        double travelTimeReturnHours = (double) totalDistance / speedKmPerHr;
        double totalTimeReturnHours = travelTimeReturnHours + totalStopTimeReturnHours;

        System.out.println("Total time for the return journey including refueling stops: " + totalTimeReturnHours + " hours");

        // (iv) Calculate arrival time for the second coach
        double totalDistanceMeters = totalDistance * 1000; // convert distance to meters
        double travelTimeSeconds = totalDistanceMeters / secondCoachSpeedMPerS;
        double travelTimeHoursSecondCoach = travelTimeSeconds / 3600;

        String startTimeStr = "09:00:00";
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Date startTime = null;
        try {
            startTime = sdf.parse(startTimeStr);
        } catch (Exception e) {
            e.printStackTrace();
        }

        long arrivalTimeMillis = startTime.getTime() + (long) (travelTimeSeconds * 1000);
        Date arrivalTime = new Date(arrivalTimeMillis);

        System.out.println("Arrival time for the second coach: " + sdf.format(arrivalTime));
    }
}
