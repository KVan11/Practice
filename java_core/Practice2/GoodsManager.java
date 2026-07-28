package java_core.Practice2;

import java.util.Arrays;

public class GoodsManager {
    private Goods[] items;
    private int size;

    public GoodsManager(int capacity){
        this.items = new Goods[Math.max(4, capacity)];
        this.size = 0;
    }

    public boolean addGoods(Goods g){
        if (g == null) return false;
        
        for (int i=0;i<size;i++){
            if (items[i].getProductCode().equals(g.getProductCode())) return false;
        }
        
        if (size >= items.length) {
            items = Arrays.copyOf(items, items.length * 2);
        }
        
        items[size++] = g;
        return true;
    }

    public Goods[] listAll(){
        return Arrays.copyOf(items, size);
    }

    public int totalQuantityByType(Class<?> cls){
        int sum=0;
        for (int i=0;i<size;i++){
            if (cls.isInstance(items[i])) sum += items[i].getQuantity();
        }
        return sum;
    }

    public double totalVATByType(Class<?> cls){
        double sum=0.0;
        for (int i=0;i<size;i++){
            if (cls.isInstance(items[i])) sum += items[i].getVATAmount();
        }
        return sum;
    }

    public void displayAll(){
        for (int i=0;i<size;i++) items[i].displayInfo();
    }
}
