import com.chan.spring.config.MainConfigOfLifeCycle;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * BeanTest
 *
 * @author Chan
 * @since 2020/3/23
 */
public class IocLifeCycleTest {
    private final static ApplicationContext application = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);

    @Test
    public void testBeanDefinedNames() {
        String[] beanNames = application.getBeanDefinitionNames();
        for (String s : beanNames) {
            System.out.println(s);
        }
    }

    @Test
    public void testBeanLifeCycle() {
        /*
        Person person = (Person) application.getBean("tom");
        Person tom = (Person) application.getBean("tom");
        System.out.println(person);*/
        ((AnnotationConfigApplicationContext) application).close();
    }
}
