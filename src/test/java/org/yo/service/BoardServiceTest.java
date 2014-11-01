package org.yo.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.yo.vo.BbsVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/**/*-context.xml"})
public class BoardServiceTest {
	static Logger logger = (Logger)Logger.getLogger(BoardServiceTest.class);
	
	@Autowired
	private BoardService service;
	
	@Test
	public void test() {
		//List<BbsVO> list = service.list(1);
		//logger.info(list.toString());	
	}
	
	@Test
	public void read() {
		logger.info(service.read(2));
	}
	
	@Test
	public void create() {
		 //title, content, writer, isfile
		BbsVO vo = new BbsVO().setContent("content").setIsfile("F").setTitle("제목").setWriter("글쓴이");
		service.create(vo);
	}
	

}
