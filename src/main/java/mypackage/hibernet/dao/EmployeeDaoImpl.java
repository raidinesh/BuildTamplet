package mypackage.hibernet.dao;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SQLQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import mypackage.hibernet.Employee;

@Transactional
public class EmployeeDaoImpl implements EmployeeDea {
	@Autowired
	private HibernateTemplate  hibernateTemplate;
	@Override
	public void saveEmployee() {
		Employee ep=new Employee();
		ep.setId(10);
		ep.setName("Mohan");
		ep.setSalary(5000);
		hibernateTemplate.save(ep);
	}
	@Override
	public void upateEmployee()
	{
		Employee ep=new Employee();
		ep.setId(2);
		ep.setName("Rohan");
		ep.setSalary(5000);
		hibernateTemplate.update(ep);
	}
	@Override
	public void deleteEmployee()
	{
		Employee ep=new Employee();
		ep.setId(2);
		ep.setName("Rohan");
		ep.setSalary(5000);
		hibernateTemplate.delete(ep);
	}
	
	@Override
	public void readEmployee()
	{
		//Employee ep=new Employee();
		String sql = "select * FROM EMPLOYEE";
		SQLQuery query =hibernateTemplate.getSessionFactory().getCurrentSession().createSQLQuery(sql);
		query.addEntity(Employee.class);
		@SuppressWarnings("rawtypes")
		List results = query.list();
		System.out.println("Result is : "+results.toString());
	}

}
