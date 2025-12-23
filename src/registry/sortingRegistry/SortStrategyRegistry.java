package registry.sortingRegistry;

import pojo.Item;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SortStrategyRegistry {
    private static  final Map<String, Comparator<Item>>diffSort=new HashMap<>();
    static {
        diffSort.put("price",Comparator.comparingInt(Item::getPrice));
        diffSort.put("quantity",Comparator.comparingInt(Item::getQuantity));
    }
    public static Comparator<Item>get(String key,boolean asc){
        Comparator<Item>cmp=diffSort.getOrDefault(key,diffSort.get("price"));
        return asc?cmp:cmp.reversed();
    }
}
