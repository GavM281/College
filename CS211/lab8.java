import java.util.*;
import java.math.*;

public class lab8 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        // Point a
        double lat1 = scan.nextDouble();
        double lon1 = scan.nextDouble();
        // Point b
        double lat2 = scan.nextDouble();
        double lon2 = scan.nextDouble();


        double latDist = Math.toRadians(lat2 - lat1);
        double lonDist = Math.toRadians(lon2 - lon1);

        double d = Math.sin(latDist/2) * Math.sin(latDist/2)
                + Math.cos(Math.toRadians(lat1))
                * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDist/2) * Math.sin(lonDist/2);

        double distance = 2 * 6371 * Math.asin(Math.sqrt(d));

        int answer = (int)(Math.round(distance/ 100.0) * 100);

        System.out.println(answer);
    }
}
