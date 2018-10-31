package kh.mybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kh.mybatis.dto.UsersDTO;

public class UsersDAO {
	public boolean idPwCheck(SqlSession session, Map<String,String> map) {
		boolean result = false;
		try {
			result = session.selectOne("Users.selectuser",map);
		}finally {
			session.close();
		}
		return result;
	}
	
	public int insert(SqlSession session, UsersDTO dto) {
		int result = 0;
		
		try {
			result = session.insert("Users.insert",dto);
		}finally {
			session.commit();
			session.close();
		}
		return result;
	}
	
	public int delete(SqlSession session, String id) {
		int result =0;
		
		try {
			result = session.delete("Users.delete",id);
		}finally {
			session.commit();
			session.close();
		}
		
		return result;
	}
	
	public List<UsersDTO> select(SqlSession session,String id){
		List<UsersDTO> result = null;
		try {
			result = session.selectList("Users.select",id);
		}finally {
			session.close();
		}
		return result;
	}
}
