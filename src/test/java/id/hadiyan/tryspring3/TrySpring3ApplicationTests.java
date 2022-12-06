package id.hadiyan.tryspring3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class TrySpring3ApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void test(){
        Integer a = 1;
        Integer b = a;

        b = b + 5;
        Assertions.assertNotEquals(a,b);
    }

}
