package org.yo.vo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class BbsVO {

	private Integer bbsNo;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private Integer viewcnt;
	private Integer cnt;
	private String isfile;
	private String filename;
	private Integer newdata;
	private List<MultipartFile> upfile;
	private List<String> fileList;
	
	

	public List<String> getFileList() {
		return fileList;
	}

	public BbsVO setFileList(List<String> fileList) {
		this.fileList = fileList;
		return this;
	}

	public List<MultipartFile> getUpfile() {
		return upfile;
	}

	public BbsVO setUpfile(List<MultipartFile> upfile) {
		this.upfile = upfile;	
		this.fileList = new ArrayList<String>();
		return this;
	}

	public Integer getNewdata() {
		return newdata;
	}

	public void setNewdata(Integer newdata) {
		this.newdata = newdata;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public Integer getViewcnt() {
		return viewcnt;
	}

	public void setViewcnt(Integer viewcnt) {
		this.viewcnt = viewcnt;
	}

	public Integer getBbsNo() {
		return bbsNo;
	}

	public BbsVO setBbsNo(Integer bbsNo) {
		this.bbsNo = bbsNo;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public BbsVO setTitle(String title) {
		this.title = title;
		return this;
	}

	public String getContent() {
		return content;
	}

	public BbsVO setContent(String content) {
		this.content = content;
		return this;
	}

	public String getWriter() {
		return writer;
	}

	public BbsVO setWriter(String writer) {
		this.writer = writer;
		return this;
	}

	public Integer getCnt() {
		return cnt;
	}

	public void setCnt(Integer cnt) {
		this.cnt = cnt;
	}

	public String getIsfile() {
		return isfile;
	}

	public BbsVO setIsfile(String isfile) {
		this.isfile = isfile;
		return this;
	}

	public String getFilename() {
		return filename;
	}

	public BbsVO setFilename(String filename) {
		this.filename = filename;
		return this;
	}

	@Override
	public String toString() {
		return "BbsVO [bbsNo=" + bbsNo + ", title=" + title + ", content="
				+ content + ", writer=" + writer + ", regdate=" + regdate
				+ ", viewcnt=" + viewcnt + ", cnt=" + cnt + ", isfile="
				+ isfile + ", fileName=" + filename + "]";
	}

}