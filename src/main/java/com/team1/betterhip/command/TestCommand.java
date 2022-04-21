package com.team1.betterhip.command;



import java.sql.Blob;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.mariadb.jdbc.internal.com.send.parameters.ByteParameter;
import org.springframework.ui.Model;

import com.team1.betterhip.dao.TestDao;

public class TestCommand implements BetterHipCommand {

	@Override
	public void excute(HttpServletRequest request, SqlSession sqlSession, Model model) {
		// TODO Auto-generated method stub
		TestDao dao = sqlSession.getMapper(TestDao.class);
		byte[] img = dao.blobImg("1");
		
	}

}
