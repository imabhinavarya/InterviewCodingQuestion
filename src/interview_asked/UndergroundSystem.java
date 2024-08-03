package interview_asked;

import java.util.HashMap;
import java.util.Map;

public class UndergroundSystem {
    private Map<Integer, CheckInData> checkInMap;
    private Map<String, TravelData> travelMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        travelMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CheckInData(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckInData checkInData = checkInMap.get(id);
        String startStation = checkInData.getStationName();
        int startTime = checkInData.getTime();
        int travelTime = t - startTime;

        String routeKey = startStation + "-" + stationName;
        TravelData travelData = travelMap.getOrDefault(routeKey, new TravelData(0, 0));
        travelData.addTrip(travelTime);
        travelMap.put(routeKey, travelData);

        checkInMap.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        String routeKey = startStation + "-" + endStation;
        TravelData travelData = travelMap.get(routeKey);
        return travelData.getAverageTime();
    }
}

class CheckInData {
    String stationName;
    int time;

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    CheckInData(String stationName, int time) {
        this.stationName = stationName;
        this.time = time;
    }
}

class TravelData {
    int totalTime;
    int tripCount;

    TravelData(int totalTime, int tripCount) {
        this.totalTime = totalTime;
        this.tripCount = tripCount;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    public int getTripCount() {
        return tripCount;
    }

    public void setTripCount(int tripCount) {
        this.tripCount = tripCount;
    }

    void addTrip(int tripTime) {
        this.totalTime += tripTime;
        this.tripCount++;
    }

    double getAverageTime() {
        return totalTime *(1d) / tripCount;
    }

    public static void main(String[] args) {
        UndergroundSystem station = new UndergroundSystem();
        station.checkIn(1, "Delhi", 3);
        station.checkOut(1, "Mumbai", 15);
        station.checkIn(2, "Kolkata", 8);
        station.checkOut(2, "Bangalore", 22);
        station.checkIn(3, "Delhi", 10);
        station.checkOut(3, "Mumbai", 25);

        System.out.println(station.getAverageTime("Delhi", "Mumbai"));
        System.out.println(station.getAverageTime("Kolkata", "Bangalore"));

        }
}