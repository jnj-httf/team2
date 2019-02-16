package jj.ubs.domain;

import java.util.*;

import org.springframework.stereotype.Service;

import jj.ubs.domain.infra.Record;
import jj.ubs.domain.infra.UbsResponse;
import lombok.AllArgsConstructor;

/**
 * Service to retrieve Ubs information.
 */
@AllArgsConstructor
@Service
public class UbsService {

    private UbsInvoker ubsInvoker;
    private static Map<String, List<Record>> cache = new HashMap<>();

    /**
     * Retrieves the nearest UBS latitude longitude position.
     *
     * @param city The city where the UBS is located.
     * @param latitude The latitude of the position.
     * @param longitude The logitude of the position.
     * @return The nearest UBS of the position of the requested city.
     */
    public Record getNearestUbs(String city, double latitude, double longitude) {
        List<Record> allUbs = getUbsByCity(city);
        System.out.println(allUbs.size()+" Ubs read on "+city);
        Record nearestUbs = null;
        double shortestDistance = Double.MAX_VALUE;
        for (Record ubs : allUbs) {
            double ubsLat = Double.parseDouble(ubs.getVlrLatitude());
            double ubsLong = Double.parseDouble(ubs.getVlrLongitude());
            double distance = calculateDistance(ubsLat, latitude, ubsLong, longitude);
            if (distance < shortestDistance) {
                nearestUbs = ubs;
                shortestDistance = distance;
            }
        }
        return nearestUbs;
    }

    /**
     * Retrieves the list of UBSs of a city.
     *
     * @param city The city where the UBSs are located.
     * @return The list of UBSs of the requested city.
     */
    public List<Record> getUbsByCity(String city) {
        if(cache.containsKey(city)) {
            return cache.get(city);
        }
        List<Record> allUbs = new LinkedList<>();
        int page = 1;
        UbsResponse result = ubsInvoker.getUbsByCity(city, page);
        allUbs.addAll(result.getRecords());
        while (result.getMetadata().getNextPage() != null) {
            result = ubsInvoker.getUbsByCity(city, ++page);
            allUbs.addAll(result.getRecords());
        }
        cache.put(city, allUbs);
        return allUbs;
    }

    /**
     * Calculates the distance between two lat/long positions.
     *
     * @param lat1 The latitude of the first position.
     * @param lat2 The latitude of the second position.
     * @param lon1 The longitude of the first position.
     * @param lon2 The longitude of the first position.
     * @return The distance in meters between the two positions.
     */
    private double calculateDistance(double lat1, double lat2, double lon1, double lon2) {
        final int R = 6371; // Radius of the earth

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c * 1000; // convert to meters
    }
}
