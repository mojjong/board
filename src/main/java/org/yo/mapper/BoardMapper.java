package org.yo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.yo.vo.BbsVO;
import org.yo.vo.ReplyVO;
import org.yo.web.util.Criteria;


public interface BoardMapper {

	@Select("select sysdate from dual")
	public String getTime();
	
	//글 단위 처리 메소드
/*	@Select("select rn, bbsno, title, content, writer, regdate, viewcnt from"
   +" (select rownum rn, bbsno, title, content, writer, regdate, viewcnt"
  +" from tbl_bbs where rownum <=(#{page}*15) order by bbsno desc) where rn >=#{page}")*/
	public List<BbsVO> list(Criteria cri);
	
	//@Select("select bbsno, title, content, writer, regdate, viewcnt, isfile from tbl_bbs where bbsno=#{bbsNo}")
	public BbsVO read(Integer bbsNo);
	
	@Delete("delete from tbl_bbs where bbsno=#{bbsno}")
	public void delete(Integer bbsno);
	
	public void create(BbsVO vo);
		
	public void update(BbsVO vo);
	
	
	//reply 단위 처리 메소드.
	@Insert("insert into tbl_reply (replyno, bbsno,replyer, reply, replydate)values (seq_reply_no.nextval, #{bbsNo}, #{replyer},#{reply},sysdate)")
	public void replyCre(ReplyVO vo);
	
	@Select("select replyno, replyer, reply, replydate from tbl_reply re, tbl_bbs bbs where re.bbsno = bbs.bbsno and bbs.bbsno =#{bbsno}")
	public List<ReplyVO> replyList(Integer bbsno);
	
	@Select("select replyno, replyer, reply from tbl_reply where replyno = #{replyNo}")
	public ReplyVO replyRead(ReplyVO vo);
	
	@Update("update tbl_reply set reply = #{reply} where replyno = #{replyNo}")
	public void replyUpdate(ReplyVO vo);
	
	@Delete("delete from tbl_reply where replyno=#{replyNo}")
	public void replyDelete(Integer replyNo);
	
}
