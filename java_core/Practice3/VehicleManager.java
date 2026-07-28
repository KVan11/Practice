package java_core.Practice3;

import java.util.HashMap;
import java.util.Map;

public class VehicleManager {
    private Vehicle[] vehicles;
    private int size;

    public VehicleManager(int capacity) {
        this.vehicles = new Vehicle[Math.max(4, capacity)];
        this.size = 0;
    }

    public boolean addVehicle(Vehicle v) {
        if (v == null) return false;
        // check duplicate vehicleNumber
        for (int i = 0; i < size; i++) {
            if (vehicles[i].getVehicleNumber().equals(v.getVehicleNumber())) return false;
        }
        if (size >= vehicles.length) {
            // expand
            Vehicle[] tmp = new Vehicle[vehicles.length * 2];
            System.arraycopy(vehicles, 0, tmp, 0, vehicles.length);
            vehicles = tmp;
        }
        vehicles[size++] = v;
        return true;
    }

    // internal finder (returns Vehicle)
    public Vehicle findVehicleByNumber(String number) {
        if (number == null) return null;
        for (int i = 0; i < size; i++) {
            if (vehicles[i].getVehicleNumber().equals(number)) return vehicles[i];
        }
        return null;
    }

    // API: print vehicle by number (matches assignment usage)
    public void findByVehicleNumber(String number) {
        Vehicle v = findVehicleByNumber(number);
        if (v != null) v.displayInfo();
        else System.out.println("Vehicle not found: " + number);
    }

    public void findByOwnerId(String id) {
        if (id == null) return;
        for (int i = 0; i < size; i++) {
            Owner o = vehicles[i].getOwner();
            if (o != null && id.equals(o.getIdNumber())) {
                vehicles[i].displayInfo();
            }
        }
    }

    public void deleteByManufacturer(String manu) {
        if (manu == null) return;
        int write = 0;
        for (int read = 0; read < size; read++) {
            if (!vehicles[read].getManufacturer().equals(manu)) {
                vehicles[write++] = vehicles[read];
            }
        }
        // null out remaining
        for (int i = write; i < size; i++) vehicles[i] = null;
        size = write;
    }

    public String manufacturerWithMostVehicles() {
        if (size == 0) return null;
        Map<String, Integer> counts = new HashMap<>();
        for (int i = 0; i < size; i++) {
            String m = vehicles[i].getManufacturer();
            counts.put(m, counts.getOrDefault(m, 0) + 1);
        }
        String best = null;
        int bestCnt = -1;
        for (Map.Entry<String, Integer> e : counts.entrySet()) {
            if (e.getValue() > bestCnt) { best = e.getKey(); bestCnt = e.getValue(); }
        }
        return best;
    }

    // wrapper with naming from assignment
    public String getManufacturerMostVehicles() { return manufacturerWithMostVehicles(); }

    public void sortByManufacturerCountDesc() {
        // Count per manufacturer
        Map<String, Integer> counts = new HashMap<>();
        for (int i = 0; i < size; i++) counts.put(vehicles[i].getManufacturer(), counts.getOrDefault(vehicles[i].getManufacturer(), 0) + 1);
        // simple bubble-like stable partition by manufacturer counts: we will sort vehicles array by counts desc using simple selection sort
        for (int i = 0; i < size - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < size; j++) {
                int cmax = counts.get(vehicles[maxIdx].getManufacturer());
                int cj = counts.get(vehicles[j].getManufacturer());
                if (cj > cmax) maxIdx = j;
            }
            if (maxIdx != i) {
                Vehicle tmp = vehicles[i]; vehicles[i] = vehicles[maxIdx]; vehicles[maxIdx] = tmp;
            }
        }
    }

    // wrapper
    public void sortByManufacturerCount() { sortByManufacturerCountDesc(); }

    public Map<String, Integer> statsByType() {
        Map<String, Integer> stats = new HashMap<>();
        int cars = 0, bikes = 0, trucks = 0;
        for (int i = 0; i < size; i++) {
            if (vehicles[i] instanceof Car) cars++;
            else if (vehicles[i] instanceof Motorbike) bikes++;
            else if (vehicles[i] instanceof Truck) trucks++;
        }
        stats.put("Car", cars);
        stats.put("Motorbike", bikes);
        stats.put("Truck", trucks);
        return stats;
    }

    // wrapper name from assignment
    public Map<String, Integer> statistics() { return statsByType(); }

    // helper: list all
    public Vehicle[] listAll() {
        Vehicle[] out = new Vehicle[size];
        System.arraycopy(vehicles, 0, out, 0, size);
        return out;
    }

    // prints all vehicles
    public void displayAll() {
        for (int i = 0; i < size; i++) {
            vehicles[i].displayInfo();
        }
    }
}
