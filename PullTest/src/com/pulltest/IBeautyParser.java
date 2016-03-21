package com.pulltest;

import java.io.InputStream;
import java.util.List;

public interface IBeautyParser {
	/**
	 * 
	 * 解析输入流，获取Beauty列表
	 * @param is
	 * @return
	 * @throws Exception
	 */
	public List<Beauty> parse(InputStream is) throws Exception;
	
	/**
	 * 
	 * 序列化Beauty对象集合，得到XML形式的字符串
	 * @param beauties
	 * @return
	 * @throws Exception
	 */
	public String serialize(List<Beauty> beauties) throws Exception;


}
