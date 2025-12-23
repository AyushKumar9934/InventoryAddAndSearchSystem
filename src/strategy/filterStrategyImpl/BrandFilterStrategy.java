package strategy.filterStrategyImpl;

import strategy.ItemFilterStrategy;
import pojo.Item;

import java.util.List;

public class BrandFilterStrategy implements ItemFilterStrategy {
    public boolean apply(Item item, List<String> values){
        return values.stream().map(String::toLowerCase).anyMatch(v->v.equals(item.getBrand()));
//        return values.contains(item.getBrand());
    }
}
