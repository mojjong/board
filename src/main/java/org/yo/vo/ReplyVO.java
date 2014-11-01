package org.yo.vo;

import java.sql.Date;

public class ReplyVO {
	private int replyNo;
	private int bbsNo;
	private String reply;
	private String replyer;
	private Date replydate;
	
	public int getReplyNo() {
		return replyNo;
	}
	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}
	public int getBbsNo() {
		return bbsNo;
	}
	public void setBbsNo(int bbsNo) {
		this.bbsNo = bbsNo;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public String getReplyer() {
		return replyer;
	}
	public void setReplyer(String replyer) {
		this.replyer = replyer;
	}
	public Date getReplydate() {
		return replydate;
	}
	public void setReplydate(Date replydate) {
		this.replydate = replydate;
	}
	@Override
	public String toString() {
		return "ReplyVO [replyNo=" + replyNo + ", bbsNo=" + bbsNo + ", reply="
				+ reply + ", replyer=" + replyer + ", replydate=" + replydate
				+ "]";
	}
	
}
