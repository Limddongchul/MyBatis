package kh.mybatis.factory;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisSqlSessionFactory {
	public static SqlSession getSqlSession() {
		
		try {
			String resource = "kh/mybatis/xml/config.xml";
			InputStream is = Resources.getResourceAsStream(resource);
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			
			return factory.openSession();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
