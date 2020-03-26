import com.chan.spring.config.MainConfigProfile;
import com.chan.spring.pojo.DataSource;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * BeanTest
 *
 * @author Chan
 * @since 2020/3/23
 */
public class IocProfileTest {
    private final static AnnotationConfigApplicationContext application = new AnnotationConfigApplicationContext();

    @Test
    public void testBeanDefinedNames() {
        String[] beanNames = application.getBeanNamesForType(DataSource.class);
        for (String s : beanNames) {
            System.out.println(s);
        }
    }

    @Test
    public void testDataSource() {
        application.getEnvironment().setActiveProfiles("dev", "product");
        application.register(MainConfigProfile.class);
        application.refresh();
        testBeanDefinedNames();
    }
}
