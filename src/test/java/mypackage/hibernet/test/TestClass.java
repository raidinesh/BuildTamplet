package mypackage.hibernet.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import mypackage.hibernet.config.AppConfig;
import mypackage.hibernet.dao.EmployeeDea;

public class TestClass {
	public static void main(String[] args) {
		  AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
	  	  ctx.register(AppConfig.class);
		  ctx.refresh();
		  EmployeeDea pdao = ctx.getBean(EmployeeDea.class);
		  pdao.saveEmployee();
		  pdao.upateEmployee();
		  pdao.deleteEmployee();
		  pdao.readEmployee();
		  System.out.println("Done");
		  ctx.close();

}
}
