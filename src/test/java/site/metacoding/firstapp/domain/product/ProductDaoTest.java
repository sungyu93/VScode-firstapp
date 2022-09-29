package site.metacoding.firstapp.domain.product;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;

@MybatisTest
public class ProductDaoTest {

    @Autowired
    private ProductDao productDao;
    // 실제 생성자 주입이 아니라 임의로 넣어주는 것이다.

    @Test
    public void findById_test() {
        // given (받아야 될 것)
        Integer productId = 1;

        // when (테스트)
        Product productPs = productDao.findById(productId);

        // then (검증)
        // then
        assertEquals("바나나", productPs.getProductName());
    }

}
