package strategy.filterStrategyImpl;

import strategy.ItemFilterStrategy;
import pojo.Item;

import java.util.List;

public class PriceFilterStrategy implements ItemFilterStrategy {
    public  boolean apply(Item item, List<String>values){
        int from=Integer.parseInt(values.get(0));
        int to=Integer.parseInt((values.get(1)));
        return item.getPrice()>=from && item.getPrice()<=to;
    }
}
