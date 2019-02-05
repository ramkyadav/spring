package com.example.demo.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.demo.domain.Booking;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "bookingEntityManagerFactory", 
		transactionManagerRef = "bookingTransactionManager", 
		basePackages = "com.example.demo.booking.dao"
)
public class BookingDBConfig {

	@Primary
	@Bean(name = "bookingDataSource")
	@ConfigurationProperties(prefix = "app.booking.datasource")
	public DataSource bookingDataSource() {
		return DataSourceBuilder
					.create()
					.build();
	}

	@Primary
	@Bean(name = "bookingEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder) {
		return builder
					.dataSource(bookingDataSource())
					.packages(Booking.class)
					.persistenceUnit("bookingPU")
					.build();
	}

	@Primary
	@Bean(name = "bookingTransactionManager")
	public PlatformTransactionManager transactionManager(@Qualifier("bookingEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}

}
