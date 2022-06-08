package com.kh.team;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kh.team.dao.BoardDao;
import com.kh.team.vo.BoardVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/*.xml")
public class BoardDaoTest {
	
	@Autowired
	private BoardDao boardDao;
	
	
	@Test
	public void testInsert500() {
		for (int i = 1; i < 500; i++) {
			BoardVo boardVo = new BoardVo("제목-" + i, "내용-" + i, "user01");
			boardDao.create(boardVo);
		}
		
		
	}
	
	

}
