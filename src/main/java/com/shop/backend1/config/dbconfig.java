package com.shop.backend1.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.shop.backend1.daoimpl.*;
import com.shop.backend1.dao.*;
import com.shop.backend1.model.*;

@Configuration
@ComponentScan("com.shop")
@EnableTransactionManagement
public class dbconfig {

	@Bean(name = "datasource")
	public DataSource getDataSource() {
		System.out.println("Datasource");
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/ecommerce");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		return dataSource;
	}

	@Autowired
	@Bean
	public SessionFactory sessionFactory() {
		System.out.println("Sessionfactory");
		LocalSessionFactoryBuilder lsf = new LocalSessionFactoryBuilder(getDataSource());
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		hibernateProperties.setProperty("hibernate.show_sql", "true");
		lsf.addProperties(hibernateProperties);
		Class classes[] = new Class[] { Category.class, Cart.class, Product.class, User.class, Supplier.class, CustomerOrder.class };

		return lsf.addAnnotatedClasses(classes).buildSessionFactory();
	}

	@Autowired
	@Bean
	public HibernateTransactionManager hibTransManagement() {
		return new HibernateTransactionManager(sessionFactory());

	}

	@Autowired
	@Bean(name = "categoryImpl")
	public CategoryDAOImpl getCategoryDAOImpl(SessionFactory sessionFactory) {
		System.out.println("category creation");
		return new CategoryDAOImpl(sessionFactory);
	}

	@Autowired
	@Bean(name = "cartImpl")
	public CartDAOImpl getCartImpl(SessionFactory sessionFactory) {
		System.out.println("Cart creation");
		return new CartDAOImpl(sessionFactory);
	}

	@Autowired
	@Bean(name = "orderImpl")
	public CustomerOrder getOrderImpl(SessionFactory sessionFactory) {
		System.out.println("order creation");
		return new CustomerOrder();
	}

	@Autowired
	@Bean(name = "productImpl")
	public ProductDAOImpl getProductImpl(SessionFactory sessionFactory) {
		System.out.println("product creation");
		return new ProductDAOImpl(sessionFactory);
	}

//	@Autowired
//	@Bean(name = "roleImpl")
//	public RoleDAOImpl getRoleImpl(SessionFactory sessionFactory) {
//		System.out.println("Role creation");
//		return new RoleDAOImpl(sessionFactory);
//	}

//	@Autowired
//	@Bean(name = "ShippingAddressImpl")
//	public ShippingAddressDAOImpl getShippingImpl(SessionFactory sessionFactory) {
//		System.out.println("ShippingAddress creation");
//		return new ShippingAddressDAOImpl(sessionFactory);
//	}

	@Autowired
	@Bean(name = "SupplierImpl")
	public SupplierDAOImpl getSupplierImpl(SessionFactory sessionFactory) {
		System.out.println("Supplier creation");
		return new SupplierDAOImpl(sessionFactory);
	}

	@Autowired
	@Bean(name = "UserImpl")
	public UserDAOImpl getUserImpl(SessionFactory sessionFactory) {
		System.out.println("User creation");
		return new UserDAOImpl(sessionFactory);

	}

}
