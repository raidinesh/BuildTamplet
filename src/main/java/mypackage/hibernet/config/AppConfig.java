package mypackage.hibernet.config;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import mypackage.hibernet.dao.EmployeeDea;
import mypackage.hibernet.dao.EmployeeDaoImpl;
import mypackage.hibernet.Employee;
@Configuration 
@EnableTransactionManagement

public class AppConfig {
@Bean  
    public EmployeeDea EmployeeDaoImpl() {  
       return new EmployeeDaoImpl();  
    }
@Bean
public HibernateTemplate hibernateTemplate() {
	return new HibernateTemplate(sessionFactory());
}
@Bean
public SessionFactory sessionFactory() {
	return new LocalSessionFactoryBuilder(getDataSource())
	   .addAnnotatedClasses(Employee.class)
	   .buildSessionFactory();
}
@Bean
public DataSource getDataSource() {
    BasicDataSource dataSource = new BasicDataSource();
    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
    dataSource.setUrl("jdbc:mysql://localhost:3306/demo");
    dataSource.setUsername("root");
    dataSource.setPassword("root");
 
    return dataSource;
}
@Bean
public HibernateTransactionManager hibTransMan(){
	return new HibernateTransactionManager(sessionFactory());
}
}
