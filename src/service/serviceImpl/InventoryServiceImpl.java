package service.serviceImpl;

import builder.SearchRequest;
import exceptions.InvalidInputException;
import exceptions.ItemNotFoundException;
import com.sun.jdi.request.DuplicateRequestException;
import strategy.ItemFilterStrategy;
import registry.filterRegistry.FilterRegistry;
import pojo.Item;
import repository.InventoryRepo;
import service.InventoryService;
import registry.sortingRegistry.SortStrategyRegistry;

public class InventoryServiceImpl implements InventoryService {
    private final InventoryRepo inventoryRepo=new InventoryRepo();
    @Override
   public void addItem(String category,String brand ,int price ){
        if(brand==null || brand.isBlank()){
            throw  new InvalidInputException("Brand Cant be Empty");
        }
        if(category==null || category.isBlank()){
            throw  new InvalidInputException("Category cant be emtpty");

        }
        if(price<=0){
            throw new InvalidInputException("price cant be negative");
        }
        inventoryRepo.getItem(category.trim().toLowerCase(),brand.trim().toLowerCase()).ifPresent(item->{
            throw new DuplicateRequestException("Item already exist"+ brand+ ","+ category);
        });
        inventoryRepo.addItem(new Item(category.trim().toLowerCase(),brand.trim().toLowerCase(),price));
    }
   public void addInventory(String category,String brand,int quantity){
        if(quantity<=0){
            throw new InvalidInputException("Quantity must be positive");
        }
        Item item=inventoryRepo.getItem(category.trim().toLowerCase(),brand.trim().toLowerCase()).orElseThrow(()-> new ItemNotFoundException("Item not found" + brand +","+category));
        item.addQuantity(quantity);
    }
   public void search(SearchRequest searchRequest){
        inventoryRepo.getAllItems().stream()
                .filter(item->{
                    for(var entry: searchRequest.getFilters().entrySet()){
                        ItemFilterStrategy filter= FilterRegistry.getFilter(entry.getKey());
                        if(filter==null){
                            throw new InvalidInputException("invalid filter"+ entry.getKey());
                        }
                        if(!filter.apply(item,entry.getValue()))
                            return false;
                    }
                    return true;
                }).sorted(SortStrategyRegistry.get(searchRequest.getOrderBy(),searchRequest.isAsc()))
                .forEach(System.out::println);
    }

    public void printInventory() {

        System.out.println("Inventory :");

        for (Item item : inventoryRepo.getAllItems()) {
            System.out.println(
                    item.getBrand() + " -> " +
                            item.getCategory() + " -> " +
                            item.getQuantity()
            );
        }
    }


}
