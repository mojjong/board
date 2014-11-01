package org.yo.service;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
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
		
/*		BbsVO vo = new BbsVO();
		vo.setBbsNo(1);
		vo.setTitle("����");
		vo.setContent("����");
		vo.setWriter("����");*/
		
		return mapper.read(bbsNo);
	}
	
	public void create(BbsVO vo){
		mapper.create(vo);
		//logger.info(vo.getBbsNo().toString());
		
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
}
