package config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class daoTest {

	public static void main(String[] args) {
		test1();

	}

	static void test1() {
		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(AppConfig.class);
	}
}
