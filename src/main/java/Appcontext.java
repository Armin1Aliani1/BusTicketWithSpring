import configuration.MyBeans;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Appcontext {
    public static final ApplicationContext context = new AnnotationConfigApplicationContext(MyBeans.class);
//    public static final ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
}
