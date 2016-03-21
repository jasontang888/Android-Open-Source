package com.pulltest;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;

import android.util.Xml;

public class BeautyParserImpl implements IBeautyParser{

	@Override
	public List<Beauty> parse(InputStream is) throws Exception {
		List<Beauty> mList = null;
		Beauty beauty = null;
		
		// ��android.util.Xml����һ��XmlPullParserʵ��
		XmlPullParser xpp = Xml.newPullParser();
		// ���������� ��ָ�����뷽ʽ
		xpp.setInput(is,"UTF-8");
		// ������һ���¼�
		int eventType = xpp.getEventType();
		
		while (eventType != XmlPullParser.END_DOCUMENT){
			 switch (eventType) {
			             // �жϵ�ǰ�¼��Ƿ�Ϊ�ĵ���ʼ�¼�
			             case XmlPullParser.START_DOCUMENT:
			                 mList = new ArrayList<Beauty>(); // ��ʼ��books����
			                 break;
			             // �жϵ�ǰ�¼��Ƿ�Ϊ��ǩԪ�ؿ�ʼ�¼�
			             case XmlPullParser.START_TAG:
			                 if (xpp.getName().equals("beauty")) { // �жϿ�ʼ��ǩԪ���Ƿ���book
			                     beauty = new Beauty();
			                 } else if (xpp.getName().equals("name")) {
			                     eventType = xpp.next();//�ý�����ָ��name���Ե�ֵ
			                     // �õ�name��ǩ������ֵ��������beauty��name
			                     beauty.setName(xpp.getText());
			                 } else if (xpp.getName().equals("age")) { // �жϿ�ʼ��ǩԪ���Ƿ���book
			                     eventType = xpp.next();//�ý�����ָ��age���Ե�ֵ
			                     // �õ�age��ǩ������ֵ��������beauty��age
			                     beauty.setAge(xpp.getText());
			                 } 
			                 break;
			  
			             // �жϵ�ǰ�¼��Ƿ�Ϊ��ǩԪ�ؽ����¼�
			             case XmlPullParser.END_TAG:
			                 if (xpp.getName().equals("beauty")) { // �жϽ�����ǩԪ���Ƿ���book
			                     mList.add(beauty); // ��book��ӵ�books����
			                     beauty = null;
			                 }
			                 break;
			             }
			             // ������һ��Ԫ�ز�������Ӧ�¼�
			             eventType = xpp.next();
			         }
			         return mList;

		}


	@Override
	public String serialize(List<Beauty> beauties) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
