package site.metacoding.firstapp.domain.product;

import java.util.List;

public interface ProductDao {
    public Product findById(Integer productId);

    public List<Product> findAll();

    public void insert(Product product);

    public int update(Product product);

    public int deleteById(Integer productId);
}
