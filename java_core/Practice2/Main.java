package java_core.Practice2;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args){
        GoodsManager mgr = new GoodsManager(8);
        mgr.addGoods(new Food("F001", "Milk", 10, 2.5, LocalDate.now().minusDays(20), LocalDate.now().minusDays(1), "DairyCo"));
        mgr.addGoods(new Food("F002", "Bread", 5, 1.2, LocalDate.now().minusDays(2), LocalDate.now().plusDays(3), "BakeLtd"));
        mgr.addGoods(new Electronics("E001", "Blender", 2, 40.0, 12, 0.5));
        mgr.addGoods(new Crockery("C001", "Plate", 60, 3.0, "Porcelan", LocalDate.now().minusDays(20)));

        java.util.Scanner sc = new java.util.Scanner(System.in);
        while (true) {
            System.out.println("\n--- Quan ly kho (Chon) ---");
            System.out.println("1. Them hang");
            System.out.println("2. Hien thi tat ca");
            System.out.println("3. Hien thi danh gia");
            System.out.println("4. Hien thi tong theo loai");
            System.out.println("0. Thoat");
            System.out.print("Lua chon: ");
            String opt = sc.nextLine().trim();
            if (opt.equals("0")) break;
            switch (opt) {
                case "1":
                    addGoodsInteractive(mgr, sc);
                    break;
                case "2":
                    mgr.displayAll();
                    break;
                case "3":
                    for (Goods g : mgr.listAll()) System.out.println(g.getProductCode() + ": " + g.evaluate());
                    break;
                case "4":
                    System.out.println("Thực phẩm SL=" + mgr.totalQuantityByType(Food.class) + " VAT=" + mgr.totalVATByType(Food.class));
                    System.out.println("Điện tử SL=" + mgr.totalQuantityByType(Electronics.class) + " VAT=" + mgr.totalVATByType(Electronics.class));
                    System.out.println("Đồ dùng SL=" + mgr.totalQuantityByType(Crockery.class) + " VAT=" + mgr.totalVATByType(Crockery.class));
                    break;
                default:
                    System.out.println("Lua chon khong hop le");
            }
        }
        sc.close();
        System.out.println("Ket thuc chuong trinh.");
    }

    private static void addGoodsInteractive(GoodsManager mgr, java.util.Scanner sc){
        System.out.println("Chon loai hang can them: 1-Thuc pham 2-Dien tu 3-Do dung");
        System.out.print("Loai: ");
        String t = sc.nextLine().trim();
        try {
            System.out.print("Ma san pham: ");
            String code = sc.nextLine().trim();
            System.out.print("Ten: ");
            String name = sc.nextLine().trim();
            System.out.print("So luong: ");
            int qty = Integer.parseInt(sc.nextLine().trim());
            System.out.print("Gia don vi: ");
            double price = Double.parseDouble(sc.nextLine().trim());

            Goods g = null;
            if (t.equals("1")){
                System.out.print("NSX (yyyy-MM-dd): ");
                java.time.LocalDate mfg = java.time.LocalDate.parse(sc.nextLine().trim());
                System.out.print("HSD (yyyy-MM-dd): ");
                java.time.LocalDate exp = java.time.LocalDate.parse(sc.nextLine().trim());
                System.out.print("Nha cung cap: ");
                String sup = sc.nextLine().trim();
                g = new Food(code, name, qty, price, mfg, exp, sup);
            } else if (t.equals("2")){
                System.out.print("Bao hanh (thang): ");
                int w = Integer.parseInt(sc.nextLine().trim());
                System.out.print("Cong suat (kW): ");
                double p = Double.parseDouble(sc.nextLine().trim());
                g = new Electronics(code, name, qty, price, w, p);
            } else if (t.equals("3")){
                System.out.print("Nha san xuat: ");
                String manu = sc.nextLine().trim();
                System.out.print("Ngay ve (yyyy-MM-dd): ");
                java.time.LocalDate arr = java.time.LocalDate.parse(sc.nextLine().trim());
                g = new Crockery(code, name, qty, price, manu, arr);
            } else {
                System.out.println("Loai khong hop le");
                return;
            }
            boolean ok = mgr.addGoods(g);
            System.out.println(ok ? "Them thanh cong" : "Them that bai (ma trung)");
        } catch (Exception ex){
            System.out.println("Loi nhap: " + ex.getMessage());
        }
    }
}
