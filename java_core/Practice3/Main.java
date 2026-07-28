package java_core.Practice3;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        VehicleManager manager = new VehicleManager(20);

        // pre-populate sample data
        Owner o1 = new Owner("012345678901", "Alice", "alice@example.com");
        Owner o2 = new Owner("123456789012", "Bob", "bob@example.com");
        Owner o3 = new Owner("234567890123", "Charlie", "charlie@example.com");

        try {
            manager.addVehicle(new Car("H0001", "Honda", 2020, "Red", o1, 4, "V4"));
            manager.addVehicle(new Car("H0002", "Honda", 2021, "Blue", o2, 5, "V6"));
            manager.addVehicle(new Car("T0001", "Toyota", 2019, "White", o3, 5, "V6"));
            manager.addVehicle(new Car("T0002", "Toyota", 2022, "Gray", o1, 4, "V4"));
            manager.addVehicle(new Motorbike("Y0001", "Yamaha", 2021, "Black", o2, 150.0));
            manager.addVehicle(new Truck("S0001", "Suzuki", 2018, "White", o3, 2.5));
            manager.addVehicle(new Car("H0003", "Honda", 2019, "Green", o2, 4, "V4"));
        } catch (Exception e) {
            System.out.println("Init data error: " + e.getMessage());
        }

        while (true) {
            System.out.println("\n=== Vehicle Manager ===");
            System.out.println("1. Them phuong tien");
            System.out.println("2. Tim theo bien so");
            System.out.println("3. Tim theo CMND chu xe");
            System.out.println("4. Xoa theo hang sx");
            System.out.println("5. Hang co nhieu xe nhat");
            System.out.println("6. Sap xep theo so luong hang");
            System.out.println("7. Thong ke theo loai");
            System.out.println("8. Hien thi tat ca");
            System.out.println("9. Thoat");
            System.out.print("Lua chon: ");
            String line = sc.nextLine().trim();
            int choice = -1;
            try { choice = Integer.parseInt(line); } catch (Exception ex) { System.out.println("Lua chon khong hop le."); continue; }

            switch (choice) {
                case 1:
                    System.out.println("Chon loai: 1=Car 2=Motorbike 3=Truck");
                    String t = sc.nextLine().trim();
                    try {
                        if (t.equals("1")) {
                            System.out.print("Bien so (5 ky tu): "); String bn = sc.nextLine().trim();
                            System.out.print("Hang (Honda/Toyota/Suzuki/Yamaha): "); String manu = sc.nextLine().trim();
                            System.out.print("Nam san xuat: "); int y = Integer.parseInt(sc.nextLine().trim());
                            System.out.print("Mau: "); String color = sc.nextLine().trim();
                            System.out.print("So ghe: "); int seats = Integer.parseInt(sc.nextLine().trim());
                            System.out.print("Engine type: "); String eng = sc.nextLine().trim();
                            System.out.print("Owner id (12 digits): "); String oid = sc.nextLine().trim();
                            System.out.print("Owner name: "); String oname = sc.nextLine().trim();
                            System.out.print("Owner email: "); String oemail = sc.nextLine().trim();
                            Owner o = new Owner(oid, oname, oemail);
                            boolean added = manager.addVehicle(new Car(bn, manu, y, color, o, seats, eng));
                            System.out.println("Added: " + added);
                        } else if (t.equals("2")) {
                            System.out.print("Bien so (5 ky tu): "); String bn = sc.nextLine().trim();
                            System.out.print("Hang (Honda/Toyota/Suzuki/Yamaha): "); String manu = sc.nextLine().trim();
                            System.out.print("Nam san xuat: "); int y = Integer.parseInt(sc.nextLine().trim());
                            System.out.print("Mau: "); String color = sc.nextLine().trim();
                            System.out.print("Dung tich: "); double cap = Double.parseDouble(sc.nextLine().trim());
                            System.out.print("Owner id (12 digits): "); String oid = sc.nextLine().trim();
                            System.out.print("Owner name: "); String oname = sc.nextLine().trim();
                            System.out.print("Owner email: "); String oemail = sc.nextLine().trim();
                            Owner o = new Owner(oid, oname, oemail);
                            boolean added = manager.addVehicle(new Motorbike(bn, manu, y, color, o, cap));
                            System.out.println("Added: " + added);
                        } else if (t.equals("3")) {
                            System.out.print("Bien so (5 ky tu): "); String bn = sc.nextLine().trim();
                            System.out.print("Hang (Honda/Toyota/Suzuki/Yamaha): "); String manu = sc.nextLine().trim();
                            System.out.print("Nam san xuat: "); int y = Integer.parseInt(sc.nextLine().trim());
                            System.out.print("Mau: "); String color = sc.nextLine().trim();
                            System.out.print("Tonnage: "); double ton = Double.parseDouble(sc.nextLine().trim());
                            System.out.print("Owner id (12 digits): "); String oid = sc.nextLine().trim();
                            System.out.print("Owner name: "); String oname = sc.nextLine().trim();
                            System.out.print("Owner email: "); String oemail = sc.nextLine().trim();
                            Owner o = new Owner(oid, oname, oemail);
                            boolean added = manager.addVehicle(new Truck(bn, manu, y, color, o, ton));
                            System.out.println("Added: " + added);
                        } else {
                            System.out.println("Loai khong hop le.");
                        }
                    } catch (Exception e) {
                        System.out.println("Loi nhap: " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.print("Nhap bien so: ");
                    manager.findByVehicleNumber(sc.nextLine().trim());
                    break;
                case 3:
                    System.out.print("Nhap CMND chu xe (12 chu so): ");
                    manager.findByOwnerId(sc.nextLine().trim());
                    break;
                case 4:
                    System.out.print("Nhap ten hang de xoa: ");
                    manager.deleteByManufacturer(sc.nextLine().trim());
                    break;
                case 5:
                    System.out.println("Hang co nhieu xe nhat: " + manager.getManufacturerMostVehicles());
                    break;
                case 6:
                    manager.sortByManufacturerCount();
                    System.out.println("Da sap xep.");
                    break;
                case 7:
                    System.out.println(manager.statistics());
                    break;
                case 8:
                    manager.displayAll();
                    break;
                case 9:
                    System.out.println("Thoat.");
                    sc.close();
                    return;
                default:
                    System.out.println("Lua chon khong hop le.");
            }
        }
    }
}
