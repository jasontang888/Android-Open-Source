package com.pulltest;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;

import com.pulltest.SmartInfoBrowserBean.TileBean;

import android.util.Xml;

public class MyParserImpl {

	
	public List<TileBean> parse(InputStream is) throws Exception {
		List<TileBean> mList = null;
		TileBean beauty = null;
		
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
			                 mList = new ArrayList<TileBean>(); // ��ʼ��books����
			                 break;
			             // �жϵ�ǰ�¼��Ƿ�Ϊ��ǩԪ�ؿ�ʼ�¼�
			             case XmlPullParser.START_TAG:
			                 if (xpp.getName().equals("Tile")) { // �жϿ�ʼ��ǩԪ���Ƿ���book
			                     beauty = new TileBean();
			                 } else if (xpp.getName().equals("Icon")) {
			                     eventType = xpp.next();//�ý�����ָ��name���Ե�ֵ
			                     // �õ�name��ǩ������ֵ��������beauty��name
			                     if(beauty !=null)
			                     beauty.setIcon(xpp.getText());
			                 } else if (xpp.getName().equals("IconThumbnail")) { // �жϿ�ʼ��ǩԪ���Ƿ���book
			                     eventType = xpp.next();//�ý�����ָ��age���Ե�ֵ
			                     // �õ�age��ǩ������ֵ��������beauty��age
			                     beauty.setIconThumbnail(xpp.getText());
			                 } else if (xpp.getName().equals("Label")) {
			                     eventType = xpp.next();//�ý�����ָ��name���Ե�ֵ
			                     // �õ�name��ǩ������ֵ��������beauty��name
			                     beauty.setLabel(xpp.getText());
			                 } else if (xpp.getName().equals("Link")) { // �жϿ�ʼ��ǩԪ���Ƿ���book
			                     eventType = xpp.next();//�ý�����ָ��age���Ե�ֵ
			                     // �õ�age��ǩ������ֵ��������beauty��age
			                     beauty.setLink(xpp.getText());
			                 } 
			                 break;
			  
			             // �жϵ�ǰ�¼��Ƿ�Ϊ��ǩԪ�ؽ����¼�
			             case XmlPullParser.END_TAG:
			                 if (xpp.getName().equals("Tile")) { // �жϽ�����ǩԪ���Ƿ���book
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




}
