import com.chan.spring.aop.MathCalculator;
import com.chan.spring.config.MainConfigAOP;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * BeanTest
 *
 * @author Chan
 * @since 2020/3/23
 */
public class IocAopTest {
    private final static ApplicationContext application = new AnnotationConfigApplicationContext(MainConfigAOP.class);

    @Test
    public void testBeanDefinedNames() {
        String[] beanNames = application.getBeanDefinitionNames();
        for (String s : beanNames) {
            System.out.println(s);
        }
    }

    @Test
    public void testMathCalculator() {
        MathCalculator calculator = application.getBean(MathCalculator.class);
        calculator.div(1, 1);
    }
}
