package com.pulltest;

import java.io.InputStream;
import java.util.List;

public interface IBeautyParser {
	/**
	 * 
	 * ��������������ȡBeauty�б�
	 * @param is
	 * @return
	 * @throws Exception
	 */
	public List<Beauty> parse(InputStream is) throws Exception;
	
	/**
	 * 
	 * ���л�Beauty���󼯺ϣ��õ�XML��ʽ���ַ���
	 * @param beauties
	 * @return
	 * @throws Exception
	 */
	public String serialize(List<Beauty> beauties) throws Exception;


}
