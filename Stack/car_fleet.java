import java.util.Arrays;
import java.util.HashMap;

public class car_fleet {
    public static int carFleet(int target, int[] position, int[] speed) {
        int fleets = 0;
        double time = 0, dest_time = 0; // to store the current time and the destination time

        HashMap<Integer, Integer> map = new HashMap<>(); // use a hashmap to store the position and its speed

        for (int i = 0; i < position.length; i++) { // add to hashmap
            map.put(position[i], speed[i]);
        }

        Arrays.sort(position); // sort the position array so know what cars are ahead and which is last

        for (int i = position.length - 1; i >= 0; i--) { // go through the array in reverse because we start from the car closest to target
            // we are using double because integer rounds decimals down but we need the exact value
            dest_time = ((double) target - position[i]) / map.get(position[i]); // calculate destination time using formula: (target - position) / speed
            if (time < dest_time) { // if the current time is less than the destination time
                fleets++; // increment to indicate new fleet
                time = dest_time; // update current time
            }
        }
        
        return fleets;        
    }
    public static void main(String[] args) {
        int[] position = {1,4}, speed = {3,2}, position2 = {4,1,0,7}, speed2 = {2,2,1,1};
        int target = 10;

        System.out.println(carFleet(target, position, speed));
        System.out.println(carFleet(target, position2, speed2));

        // time complexity will be O(nlogn) since we are sorting the positions array and the space complexity will be O(n) for the hashmap which will be of n elements
    }
}