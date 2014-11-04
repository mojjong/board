package org.yo.service;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.yo.mapper.BoardMapper;
import org.yo.vo.BbsVO;
import org.yo.vo.ReplyVO;
import org.yo.web.util.Criteria;

@Service("boardService")
public class BoardService {
	
	private static Logger logger = LoggerFactory.getLogger(BoardService.class);
	
	@Inject
	private BoardMapper mapper;
	
	public List<BbsVO> list(Criteria cri){
		return mapper.list(cri);
	}
	
	
	public BbsVO read(Integer bbsNo){
		BbsVO vo = mapper.read(bbsNo);
		vo.setFileList(mapper.fileread(bbsNo));
		return vo;
	}
	
	@Transactional(propagation=Propagation.REQUIRED) //메소드 단위로 트랜잭션 처리하고 싶을때.
	public void create(BbsVO vo){
		
		mapper.create(vo);
		logger.info("mapper입니다.");
		
		
		for (String filename : vo.getFileList()) {
			logger.info("transactional : " + vo.getBbsNo() + ", " + filename);
			mapper.Upload(vo.setFilename(filename));
		}
	};
				
	public void delete(Integer bbsno){
		mapper.delete(bbsno);
	};
					
	public void update(BbsVO vo){
		mapper.update(vo);
	};
	
	
	public void replyCre(ReplyVO vo){
		mapper.replyCre(vo);
	};
	
	public List<ReplyVO> replyList(Integer bbsno){
		return mapper.replyList(bbsno);
	};
	
	public ReplyVO replyRead(ReplyVO vo){
		return mapper.replyRead(vo);
	}
	public void replyUpdate(ReplyVO vo){
		mapper.replyUpdate(vo);
	}
	
	public void replyDelete(Integer replyNo){
		mapper.replyDelete(replyNo);
	}
	
	public String getFileName(BbsVO vo){
		return mapper.getFileName(vo);
	}
}
