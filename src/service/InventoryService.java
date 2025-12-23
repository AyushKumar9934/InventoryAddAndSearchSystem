package service;

import builder.SearchRequest;

public interface InventoryService {
    void addItem(String category,String brand ,int Price );
    void addInventory(String category,String brand,int quantity);
    void search(SearchRequest searchRequest);
    void printInventory();


}
