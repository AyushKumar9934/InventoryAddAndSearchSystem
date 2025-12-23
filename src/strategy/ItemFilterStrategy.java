package strategy;

import pojo.Item;

import java.util.List;

public interface ItemFilterStrategy {
    boolean apply(Item item, List<String>values);
}
