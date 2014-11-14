package org.yo.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

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
		
		List<String> fileList = mapper.fileread(bbsNo);
		
		vo.setFileList(fileList);
		
		List<String> suffixs = new ArrayList<String>();
		
		for(String str : fileList){
			suffixs.add(str.substring(str.lastIndexOf(".")));
		}
		
		vo.setSuffixs(suffixs);
		
		return vo;
	}
	/*
	public List<BbsVO> fileRead(Integer bbsNo){
		
		List<BbsVO> list = mapper.fileread(bbsNo);
		
		List<String> suffixs = new ArrayList<String>();
		List<String> fileNames = new ArrayList<String>();
		
		for(BbsVO bvo : list){
			suffixs.add(bvo.getSuffix());
			fileNames.add(bvo.getFilename());
		}
		
		return mapper.fileread(bbsNo);
	}
	*/
	@Transactional(propagation=Propagation.REQUIRED) //메소드 단위로 트랜잭션 처리하고 싶을때.
	public void create(BbsVO vo){
		
		mapper.create(vo);
		logger.info("mapper입니다.");
		
		
		for (int i = 0; i < vo.getFileNames().size(); i++) {
			logger.info(vo.getFileNames().get(i));
			vo.setFilename(vo.getFileNames().get(i));
			vo.setSuffix(vo.getSuffixs().get(i));
			
			mapper.Upload(vo);
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
