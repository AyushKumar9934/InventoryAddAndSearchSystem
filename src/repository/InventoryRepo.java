package repository;

import pojo.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class InventoryRepo {
    private final Map<String, Item>inventory=new ConcurrentHashMap<>();
    private String key(String category,String brand){
        return category.toLowerCase()+"#"+brand.toLowerCase();
    }
    public void addItem(Item item){
        String identifier=key(item.getCategory(),item.getBrand());
        inventory.put(identifier,item);

    }
    public Optional<Item> getItem(String category,String brand){
        return Optional.ofNullable(inventory.get(key(category,brand)));
    }
    public List<Item> getAllItems(){
        return new ArrayList<>(inventory.values());
    }
}
