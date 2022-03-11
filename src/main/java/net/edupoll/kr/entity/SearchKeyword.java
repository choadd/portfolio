package net.edupoll.kr.entity;

import java.util.Arrays;

public class SearchKeyword {

	private String column;
	private String keyword;

	@Override
	public String toString() {
		return "SearchKeyword [column=" + column + ", keyword=" + keyword + "]";
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

}
