package net.edupoll.kr.mapper;

import org.apache.ibatis.annotations.Select;

public interface TestMapper {
	
	@Select("select sysdate from dual")
	public String getTime();

}
