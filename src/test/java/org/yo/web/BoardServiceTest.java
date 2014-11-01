package org.yo.web;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;
import org.yo.service.BoardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/**/*-context.xml"})
public class BoardServiceTest {

	private Logger logger = Logger.getLogger(BoardServiceTest.class);

	@Resource(name="boardService")
	private BoardService service;
	
	@Test
	public void test() {
		Assert.notNull(service);
		logger.info(service.read(1));
	}

}
