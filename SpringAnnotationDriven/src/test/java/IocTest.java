import com.chan.spring.config.MainConfig;
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
public class IocTest {
    private final static ApplicationContext application = new AnnotationConfigApplicationContext(MainConfig.class);

    @Test
    public void testBeanDefinedNames() {
        String[] beanNames = application.getBeanDefinitionNames();
        for (String s : beanNames) {
            System.out.println(s);
        }
    }

    @Test
    public void testBeanAnnotation() {
        Person person = (Person) application.getBean("bob");
        System.out.println(person);
    }

    @Test
    public void testBeanFactory() {
        Object bean1 = application.getBean("colorBeanFactory");
        Object bean2 = application.getBean("&colorBeanFactory");
        System.out.println(bean1.getClass());
        System.out.println(bean2.getClass());
    }
}
