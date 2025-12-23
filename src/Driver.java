import builder.SearchRequest;
import exceptions.InventoryException;
import service.InventoryService;
import service.serviceImpl.InventoryServiceImpl;


void main() {

    InventoryService service=new InventoryServiceImpl() ;
    try{

// 1. adding item
        service.addItem("Milk", "Amul", 100);
        service.addItem("Milk","Nestle",30);
        service.addItem("Curd", "Nestle", 50);
        service.addItem("meva", "Nestle", 90);

//2. add inventory
        service.addInventory("Milk", "Amul", 100);
        service.addInventory("Curd", "Nestle", 50);
        service.addInventory("milk", "Amul", 60);
        service.addInventory("Curd", "Nestle", 90);
        service.addInventory("meva", "Nestle", 56);

//3. printing inventory
        service.printInventory();
 //4. Search item (category =["Nestle"]);
 SearchRequest searchByCategory=new SearchRequest.Builder().addFilter("category",List.of("milk")).build();
        service.search((searchByCategory));

//5. search item ("brand =["Nestle"]);
        SearchRequest searchByBrand =
                new SearchRequest.Builder()
                        .addFilter("brand", List.of("Nestle"))
                        .build();

     service.search(searchByBrand);
//6 search item ("category"=["milk"],Order_By=[Price, desc])
        SearchRequest searchByCategoryDesc=new SearchRequest.Builder().addFilter("category",List.of("milk")).sortBy("price",false).build();
        service.search(searchByCategoryDesc);
 //7       searchImem ("price"=[70,100])
        SearchRequest searchByPriceRange=new SearchRequest.Builder()
                .addFilter("price",List.of("70","100")).build();
        service.search(searchByPriceRange);

//8 search Items(all filter)
        SearchRequest searchItems=new SearchRequest.Builder()
                .addFilter("price",List.of("50","200"))
                .addFilter("category",List.of("milk"))
                .addFilter("brand",List.of("amul")).build();
        service.search(searchItems);

    }catch (InventoryException ex){
        System.out.println("error "+ ex.getMessage());
    }

}
