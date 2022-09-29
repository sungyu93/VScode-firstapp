package site.metacoding.firstapp.domain.product;

import java.security.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Settet
public class Product {
    private Integer productId;
    private String productName;
    private Integer productPrice;
    private Integer productQty;
    private Timestamp createdAt;

}
