package registry.filterRegistry;

import strategy.ItemFilterStrategy;
import strategy.filterStrategyImpl.BrandFilterStrategy;
import strategy.filterStrategyImpl.CategoryFilterStrategy;
import strategy.filterStrategyImpl.PriceFilterStrategy;

import java.util.HashMap;
import java.util.Map;

public class FilterRegistry {
    private  static final Map<String, ItemFilterStrategy>filters=new HashMap<>();
    static {
        filters.put("brand",new BrandFilterStrategy());
        filters.put("category",new CategoryFilterStrategy());
        filters.put("price",new PriceFilterStrategy());
    }
    public static ItemFilterStrategy getFilter(String key){
        return filters.get(key);
    }

}
