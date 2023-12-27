package logic;
import java.util.Map;

public class CartRequest {
    private int store;
    private int isClub;
    private String supplyAt;
    private Map<String, String> items;
    private Object meta;

    public CartRequest(int store, int isClub, String supplyAt, Map<String, String> items, Object meta) {
        this.store = store;
        this.isClub = isClub;
        this.supplyAt = supplyAt;
        this.items = items;
        this.meta = meta;
    }
}
