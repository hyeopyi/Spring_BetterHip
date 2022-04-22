package com.team1.betterhip.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.team1.betterhip.dto.UserInfoDto;
import com.team1.betterhip.util.Constant;

public class UserInfoDao {


	//------------Field--------------- 
	
	JdbcTemplate template; 
	
	//----------Constructor----------- 
		
	public UserInfoDao() {
		// TODO Auto-generated constructor stub
			
		this.template = Constant.template;
	}
		
	
	//-----------Method---------------
	

	//회원 정보 view 	
	public UserInfoDto userInfoViewDao(String USER_ID) {
		String query = "select user_id, "
				     + "user_pw, "
				     + "user_name, "
				     + "user_phone, "
				     + "user_email, "
				     + "user_postcode, "
				     + "user_address, "
				     + "user_address_detail, "
				     + "user_joindate "
					 + "from user where user_id = '" + USER_ID + "'" ;
		
		return template.queryForObject(query, new BeanPropertyRowMapper<UserInfoDto>(UserInfoDto.class));

	}//userInfoViewDao
	
	
	//회원 정보 수정 
	public void userInfoModifyDao(final String USER_ID, 
								  final String new_user_pw, 
								  final String user_name, 
								  final String user_email, 
								  final String user_phone, 
								  final String user_postcode, 
								  final String user_address, 
								  final String user_address_detail) {
		
		String query = "update user set "
					 + "user_pw = ?, "
					 + "user_name = ?, "
					 + "user_email = ?, "
					 + "user_phone = ?, "
					 + "user_postcode = ?, "
					 + "user_address = ?, "
					 + "user_address_detail = ? "
					 + "where user_id = ?";
		
		this.template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				
				ps.setString(1, new_user_pw);
				ps.setString(2, user_name);
				ps.setString(3, user_email);
				ps.setString(4, user_phone);
				ps.setString(5, user_postcode);
				ps.setString(6, user_address);
				ps.setString(7, user_address_detail);
				ps.setString(8, USER_ID);
						
			}
		});
		
	}//userInfoModifyDao
		
	//회원 탈퇴 
	public void userInfoDeleteDao(final String USER_ID) {
		
		String query = "update user set user_leavedate = now() where user_id = ?";
		this.template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1, USER_ID);
				
			}
		});
		
	}//userInfoDeleteDao
	
}//End
