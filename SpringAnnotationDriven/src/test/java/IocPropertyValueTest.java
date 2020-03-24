import com.chan.spring.config.MainConfigPropertyValue;
import com.chan.spring.controller.PersonController;
import com.chan.spring.pojo.JDBC;
import com.chan.spring.service.PersonService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * BeanTest
 *
 * @author Chan
 * @since 2020/3/23
 */
public class IocPropertyValueTest {
    private final static ApplicationContext application = new AnnotationConfigApplicationContext(MainConfigPropertyValue.class);

    @Test
    public void testBeanDefinedNames() {
        String[] beanNames = application.getBeanDefinitionNames();
        for (String s : beanNames) {
            System.out.println(s);
        }
    }

    @Test
    public void testValue() {
        JDBC jdbc = (JDBC) application.getBean("jdbc");
        System.out.println(jdbc);
    }


    @Test
    public void testAutoWired() {
        PersonService personService1 = (PersonService) application.getBean("personService");
        PersonService personService2 = application.getBean(PersonController.class).getPersonService();
        System.out.println("getBean--->" + personService1);
        System.out.println("Controller AutoWired--->" + personService2);
    }


    @Test
    public void testAutoWired2() {
        PersonService personService = application.getBean(PersonController.class).getPersonService();
        System.out.println(personService);
        System.out.println("Controller AutoWired--->" + personService);
        testBeanDefinedNames();
    }
}
