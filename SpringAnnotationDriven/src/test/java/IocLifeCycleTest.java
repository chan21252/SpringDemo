import com.chan.spring.config.MainConfigOfLifeCycle;
import com.chan.spring.pojo.Person;
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
        Person tom1 = (Person) application.getBean("tom");
        Person tom2 = (Person) application.getBean("tom");
        System.out.println(tom1 == tom2);
        ((AnnotationConfigApplicationContext) application).close();
    }


    @Test
    public void testBeanInitAndDestroy() {
        Object didi = application.getBean("didi");
        System.out.println(didi);
        ((AnnotationConfigApplicationContext) application).close();
    }


}
