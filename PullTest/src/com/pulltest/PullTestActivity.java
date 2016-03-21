package com.pulltest;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.util.Xml;
import android.widget.TextView;

import com.example.pulltest.R;
import com.pulltest.SmartInfoBrowserBean.SmartInfoDetailsBean;
import com.pulltest.SmartInfoBrowserBean.TileBean;
import com.pulltest.SmartInfoBrowserBean.Tilesbean;



public class PullTestActivity extends Activity{
	
	private static String TAG = "googg";
	//装载Beauty类型的链表，其内容由XML文件解析得到
	//private List<Beauty> beautyList;TileBean
	private List<TileBean> beautyList;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pulltest);
		
		try {
			//通过assertmanager的open方法获取到beauties.xml文件的输入流
			//InputStream is = this.getAssets().open("beauties.xml");
			InputStream is = this.getAssets().open("SmartInfoBrowserMetaData.xml");
			//初始化自定义的实现类BeautyParserImpl
			//BeautyParserImpl pbp = new BeautyParserImpl();
			//MyParserImpl pbp = new MyParserImpl();
			//调用pbp的parse()方法，将输入流传进去解析，返回的链表结果赋给beautyList
			//beautyList = pbp.parse(is);
			
			
			
			  SmartInfoBrowserBean bean = null;
//				
			  bean = new SmartInfoBrowserBean();
//								
//			  		bean.setSmartInfoDetails(getSmartInfoDetailsBean(is));
//					bean.setTilesbean(getTilesbean(is));
//				
//			    
//				Log.d(TAG, bean.toString());
//				 TextView textView = (TextView) findViewById(R.id.textView);  
//			        textView.setText(bean.toString()); 
			bean = getSmartInfoBrowserBean(is);
			String s = bean.toString();
			TextView textView = (TextView) findViewById(R.id.textView);  
	        textView.setText(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//setupViews();
		 
	}
	
	

	/**
	<SmartInfoDetails>
		<Title>Crown Promanade Melbourn</Title>
		<Icon>./MainsmartinfonIcon.jpg</Icon>
		<Description>Here you find the general information about all services that our hotel provides(Like breakfast timings, bike rental or about our airport shuttle service</Description>
		<StartPageURL>./smartinfo.html</StartPageURL>
	</SmartInfoDetails>
 * @param is
 * @return
 * @throws Exception
 */
public static SmartInfoDetailsBean getSmartInfoDetailsBean(InputStream is) {
	SmartInfoDetailsBean sidbean = null;

	try {
		XmlPullParser parser = Xml.newPullParser();
		parser.setInput(is, "UTF-8");
		int eventType = parser.getEventType();
		while (eventType != XmlPullParser.END_DOCUMENT) {
			switch (eventType) {
				case XmlPullParser.START_DOCUMENT:
					break;
				case XmlPullParser.START_TAG:
					if (parser.getName().equals("SmartInfoDetails")) {
						sidbean = new SmartInfoDetailsBean();
					} else if (parser.getName().equals("Title")) {
						eventType = parser.next();
						sidbean.setTitle(parser.getText());
					} else if (parser.getName().equals("Icon")) {
						eventType = parser.next();
						sidbean.setIcon(parser.getText());
					} else if (parser.getName().equals("Description")) {
						eventType = parser.next();
						sidbean.setDescription(parser.getText());
					} else if (parser.getName().equals("StartPageURL")) {
						eventType = parser.next();
						sidbean.setStartPageURL(parser.getText());
					} 
					break;
				case XmlPullParser.END_TAG:
					break;
			}

			eventType = parser.next();
		}
	} catch (XmlPullParserException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	Log.d(TAG, "sidbean==" + sidbean.toString());
	return sidbean;

}

/**
	<Tile>  
		<Icon>./folder1/Iconfilename1.jpg</Icon>
		<IconThumbnail>./folder1/filenameThumbnail1.jpg</IconThumbnail>
		<Label>Title text1</Label>
		<Link>./folder1/tile1.html</Link>
	</Tile>
 * 
 * @param is
 * @return
 * @throws Exception
 */
public static SmartInfoBrowserBean getSmartInfoBrowserBean(InputStream is) {
	Tilesbean mTilesbean = null;
	List<TileBean> mList = null;
	TileBean tbean = null;
	SmartInfoDetailsBean sidbean = null;
	SmartInfoBrowserBean bean = null;		
	 

	try {
		XmlPullParser parser = Xml.newPullParser();
		parser.setInput(is, "UTF-8");
		int eventType = parser.getEventType();
		while (eventType != XmlPullParser.END_DOCUMENT) {
			switch (eventType) {
				case XmlPullParser.START_DOCUMENT:
					bean = new SmartInfoBrowserBean();
					mList = new ArrayList<TileBean>();
					break;
				case XmlPullParser.START_TAG:
					if (parser.getName().equals("SmartInfoDetails")) {
						sidbean = new SmartInfoDetailsBean();
					} else if (parser.getName().equals("Title")) {
						eventType = parser.next();
						sidbean.setTitle(parser.getText());
					}  else if (parser.getName().equals("Description")) {
						eventType = parser.next();
						sidbean.setDescription(parser.getText());
					} else if (parser.getName().equals("StartPageURL")) {
						eventType = parser.next();
						sidbean.setStartPageURL(parser.getText());
					} 
					/////////////////////////////////////////
					else if (parser.getName().equals("Tile")) {
						tbean = new TileBean();
					} else if (parser.getName().equals("Icon")) {
						eventType = parser.next();
						if(sidbean !=null)
							sidbean.setIcon(parser.getText());
						if(tbean !=null)
							tbean.setIcon(parser.getText());
					} else if (parser.getName().equals("IconThumbnail")) {
						eventType = parser.next();
						tbean.setIconThumbnail(parser.getText());
					} else if (parser.getName().equals("Label")) {
						eventType = parser.next();
						tbean.setLabel(parser.getText());
					} else if (parser.getName().equals("Link")) {
						eventType = parser.next();
						tbean.setLink(parser.getText());
					}
					break;
				case XmlPullParser.END_TAG:
					if (parser.getName().equals("SmartInfoDetails")) {
						bean.setSmartInfoDetails(sidbean);
						sidbean = null;
					}
					if (parser.getName().equals("Tile")) {
						mList.add(tbean);
						tbean = null;
					}
					
					break;
			}

			eventType = parser.next();
			
		}
	} catch (XmlPullParserException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	mTilesbean = new Tilesbean();
	mTilesbean.setTiles(mList);
	
	bean.setTilesbean(mTilesbean);
	
	Log.d(TAG, "mTilesbean==" + bean.toString());
	return bean;

}

public static Tilesbean getTilesbean(InputStream is) {
	Tilesbean mTilesbean = null;
	List<TileBean> mList = null;
	TileBean tbean = null;

	try {
		XmlPullParser parser = Xml.newPullParser();
		parser.setInput(is, "UTF-8");
		int eventType = parser.getEventType();
		while (eventType != XmlPullParser.END_DOCUMENT) {
			switch (eventType) {
				case XmlPullParser.START_DOCUMENT:
					mList = new ArrayList<TileBean>();
					break;
				case XmlPullParser.START_TAG:
					if (parser.getName().equals("Tile")) {
						tbean = new TileBean();
					} else if (parser.getName().equals("Icon")) {
						eventType = parser.next();
						if(tbean !=null)
						tbean.setIcon(parser.getText());
					} else if (parser.getName().equals("IconThumbnail")) {
						eventType = parser.next();
						tbean.setIconThumbnail(parser.getText());
					} else if (parser.getName().equals("Label")) {
						eventType = parser.next();
						tbean.setLabel(parser.getText());
					} else if (parser.getName().equals("Link")) {
						eventType = parser.next();
						tbean.setLink(parser.getText());
					}
					break;
				case XmlPullParser.END_TAG:
					if (parser.getName().equals("Tile")) {
						mList.add(tbean);
						tbean = null;
					}
					break;
			}

			eventType = parser.next();
			
		}
	} catch (XmlPullParserException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	mTilesbean = new Tilesbean();
	mTilesbean.setTiles(mList);
	Log.d(TAG, "mTilesbean==" + mTilesbean.toString());
	return mTilesbean;

}

public static List<TileBean> parse(InputStream is) throws Exception {
	List<TileBean> mList = null;
	TileBean beauty = null;
	
	// 由android.util.Xml创建一个XmlPullParser实例
	XmlPullParser xpp = Xml.newPullParser();
	// 设置输入流 并指明编码方式
	xpp.setInput(is,"UTF-8");
	// 产生第一个事件
	int eventType = xpp.getEventType();
	
	while (eventType != XmlPullParser.END_DOCUMENT){
		 switch (eventType) {
		             // 判断当前事件是否为文档开始事件
		             case XmlPullParser.START_DOCUMENT:
		                 mList = new ArrayList<TileBean>(); // 初始化books集合
		                 break;
		             // 判断当前事件是否为标签元素开始事件
		             case XmlPullParser.START_TAG:
		                 if (xpp.getName().equals("Tile")) { // 判断开始标签元素是否是book
		                     beauty = new TileBean();
		                 } else if (xpp.getName().equals("Icon")) {
		                     eventType = xpp.next();//让解析器指向name属性的值
		                     // 得到name标签的属性值，并设置beauty的name
		                     if(beauty !=null)
		                     beauty.setIcon(xpp.getText());
		                 } else if (xpp.getName().equals("IconThumbnail")) { // 判断开始标签元素是否是book
		                     eventType = xpp.next();//让解析器指向age属性的值
		                     // 得到age标签的属性值，并设置beauty的age
		                     beauty.setIconThumbnail(xpp.getText());
		                 } else if (xpp.getName().equals("Label")) {
		                     eventType = xpp.next();//让解析器指向name属性的值
		                     // 得到name标签的属性值，并设置beauty的name
		                     beauty.setLabel(xpp.getText());
		                 } else if (xpp.getName().equals("Link")) { // 判断开始标签元素是否是book
		                     eventType = xpp.next();//让解析器指向age属性的值
		                     // 得到age标签的属性值，并设置beauty的age
		                     beauty.setLink(xpp.getText());
		                 } 
		                 break;
		  
		             // 判断当前事件是否为标签元素结束事件
		             case XmlPullParser.END_TAG:
		                 if (xpp.getName().equals("Tile")) { // 判断结束标签元素是否是book
		                     mList.add(beauty); // 将book添加到books集合
		                     beauty = null;
		                 }
		                 break;
		             }
		             // 进入下一个元素并触发相应事件
		             eventType = xpp.next();
		         }
	               Log.d(TAG, "mTilesbean==" + mList.toString());
		         return mList;

	}

	/**
	 * 将数据显示到手机界面上
	 */
	private void setupViews(){
		String result = "";
		
		for (TileBean b : beautyList) {  
            result += b.toString();  
        }  

        TextView textView = (TextView) findViewById(R.id.textView);  
        textView.setText(result); 
	}

}
