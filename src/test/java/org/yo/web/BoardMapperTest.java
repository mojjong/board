package org.yo.web;

import static org.junit.Assert.fail;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.yo.mapper.BoardMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/**/*-context.xml"})
public class BoardMapperTest {

	private Logger logger = Logger.getLogger(BoardMapperTest.class);
	
	@Inject
	BoardMapper mapper;
	

	@Test
	public void test() {
		logger.info(mapper);
		logger.info(mapper.getTime());
	}

}
