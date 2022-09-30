package site.metacoding.firstapp.domain.product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Import;

import site.metacoding.firstapp.config.MyBatisConfig;

@Import(MyBatisConfig.class) // MyBatisTest가 MyBatisConfig를 못읽음
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // 실DB사용
@MybatisTest
public class ProductDaoTest {

    @Autowired
    private ProductDao productDao;

    @Test
    public void findById_test() {
        // given
        Integer productId = 1; // Int써도 상관없음

        // when
        Product productPS = productDao.findById(productId); // 영속화된 데이터이기때문에 PS붙이면 좋다

        // then
        assertEquals("바나나", productPS.getProductName());
    }

    @Test
    public void findAll_test() {
        // given

        // when
        List<Product> productListPS = productDao.findAll();

        // then
        assertEquals(2, productListPS.size());
    }

    // JUnit은 메서드 실행 직전에 트랜잭션이 걸리고 메서드 실행이 끝나면 롤백된다
    // MyBatis는 ResultSet을 자바 Entity로 변경할 때 빈생성자만 호출하고 setter가 없어도 값을 매핑해준다.
    @Test
    public void insert_test() {
        // given
        Product product = new Product("수박", "1000", 100);

        // when
        productDao.insert(product);

        // then
        // assertEquals(1, result);
    } // rollback

    @Test
    public void update_test() {
        // given (값을 주고)
        Integer productId = 1;
        String productName = "수박";
        String productPrice = "1000";
        Integer productQty = 100;

        Product product = new Product(productName, productPrice, productQty);
        product.setProductId(productId);

        // verify
        Product productPs = productDao.findById(product.getProductId());
        assertTrue(productPs == null ? false : true);

        // when (테스트)
        // product [id =1, productName = "수박", productPrice = 1000, productQty = 100]
        // productPs [id=1, productName = "바나나", productPrice = 3000, productQty = 98,
        // createdAt = 2022-09-29]
        productPs.update(product);
        int result = productDao.update(productPs);
        // then (검증)
        assertEquals(1, result);
    }

    @Test
    public void delete_test() {
        // given
        Integer productId = 3;
        // verify
        Product productPs = productDao.findById(productId);
        assertTrue(productPs == null ? false : true);

        // when
        int result = productDao.deleteById(productId);

        // then
        assertEquals(1, result);
    }
}