package org.yo.web.util;

public interface Criteria {
	
	public String getSql();
	public String getKey();
	public void addCri(String key, String value);
	
	public int getCnt();
	
	public void setCnt(int cnt);
	
	public int getStartPage();
	
	public void setStartPage(int startPage);
	
	public int getEndPage();
	
	public void setEndPage(int endPage);
	
	public int getCurrentBlock();
	
	public void setCurrentBlock(int currentBlock);
	
	public int getTotalPage();
	
	public void setTotalPage(int totalPage);
	
	public int getTotalBlock();
	
	public void setTotalBlock(int totalBlock);
	
	public int getCurrentPage();
	
	public void setCurrentPage(int currentPage);
	
	public int getStartRecord();
	
	public void setStartRecord(int startRecord);
	
	public int getEndRecord();
	
	public void setEndRecord(int endRecord);
	
	public String getCategory();
	
	public void setCategory(String category);
	
	public String getKeyword();
	
	public void setKeyword(String keyword);
	
	public boolean hasPrev();
	
	public boolean hasNext();
	
	public String selected(String type);
}
