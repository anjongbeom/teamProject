package com.kh.team;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kh.team.dao.ProductDao;
import com.kh.team.vo.ProductVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/*.xml")
public class ProductDaoTest {
	
	@Autowired
	private ProductDao productDao;
	
	@Test
	public void ListTest() {
		List<ProductVo> list = productDao.list();
		System.out.println(list);
	}
}
