package site.metacoding.firstapp.domain.product;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private Integer productId;
    private String productName;
    private String productPrice;
    private Integer productQty;
    private Timestamp createdAt;

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    private Product() { // MyBatis에게 필요한 것
    }

    public Product(String productName, String productPrice, Integer productQty) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQty = productQty;
    } // 생성자 초기화

    public void update(Product product) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQty = productQty;
    }// 업데이트할 때 사용

}
