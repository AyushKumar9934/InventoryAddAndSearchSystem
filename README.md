##  Problem Statement

Flipkart wants to build a system to:
- Maintain inventory for daily essentials
- Allow users to **search items** using filters
- Support **sorting**
- Be **extensible** for future filters and sort options
- Use **in-memory data structures** (no DB)

---

##  Features Implemented

### Inventory Management
- Add items with **brand, category, price**
- Add inventory quantity (incremental)
- Case-insensitive brand & category handling

### Search Capabilities
- Search by **brand**
- Search by **category**
- Search by **price range**
- Search using **multiple filters together**

### Sorting
- Default: **Price ascending**
- Price descending
- Quantity based sorting (extensible)

### Design & Quality
- Clean separation of concerns
- Extensible architecture
- Proper exception handling
- Fully testable using Driver class

---

##  Design Patterns Used

| Pattern | Usage |
|------|------|
| **POJO** | Item model |
| **Repository** | In-memory inventory storage |
| **Strategy** | Filters & sorting logic |
| **Builder** | Search request construction |
| **Registry** | Strategy lookup |
| **Service Layer** | Business logic |
| **Custom Exceptions** | Error handling |


---


---


 Test Cases Covered (All Working)
1. Add Item

2. Add Inventory

3. Search by Brand

4. Search by Category

5. Search by Price Range

6. Search with Multiple Filters

7. Sort by Price (asc/desc)

8. Inventory Summary Print



##  Application Flow
```java
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


//7   searchImem ("price"=[70,100])
        SearchRequest searchByPriceRange=new SearchRequest.Builder()
                .addFilter("price",List.of("70","100")).build();
        service.search(searchByPriceRange);

//8 search Items(all filter)
        SearchRequest searchItems=new SearchRequest.Builder()
                .addFilter("price",List.of("50","200"))
                .addFilter("category",List.of("milk"))
                .addFilter("brand",List.of("amul")).build();
        service.search(searchItems);
```
//output
<img width="1920" height="1008" alt="image" src="https://github.com/user-attachments/assets/ead459c2-a9c3-44a5-99ef-f8e22b8165f2" />




