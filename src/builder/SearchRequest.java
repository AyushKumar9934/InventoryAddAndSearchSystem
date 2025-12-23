package builder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchRequest {
    private final Map<String, List<String>> filters;
    private  final String orderBy;
    private  final boolean asc;
   public SearchRequest(Builder builder){
        this.filters=builder.filters;
        this.orderBy=builder.orderBy;
        this.asc=builder.asc;
    }

    public Map<String, List<String>> getFilters() {
        return filters;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public boolean isAsc() {
        return asc;
    }

    public static class  Builder{
        private final Map<String,List<String>>filters=new HashMap<>();
        private  String orderBy="price";
        private boolean asc=true;
        public Builder addFilter(String key,List<String>values){
            filters.put(key,values);
            return this;
        }
        public  Builder sortBy(String orderBy, boolean asc){
            this.orderBy=orderBy;
            this.asc=asc;
            return this;
        }
        public SearchRequest build(){
            return new SearchRequest(this);
        }
    }
}
