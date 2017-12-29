package com.bjs.utils.pomanaylise;


import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class PomAnalysis {
	   public static void main(String[] args) throws DocumentException {
		   //创建SAXReader对象  
		   SAXReader reader = new SAXReader();  
		   //读取文件 转换成Document  
		   Document document = reader.read(new File("E:/mars_dev/zeus-server-zqb-v4.3.3-dbbusiness/zeus-server-web/pom.xml"));  
		   //获取根节点元素对象  
		   Element root = document.getRootElement();  
		   //遍历  
		   getProfileNodes(root);
//		   listNodes(root);  
		
	}
	      
	    //遍历当前节点下的所有节点  
	    public static  void listNodes(Element node){  
	        //首先获取当前节点的所有属性节点  
	        List<Attribute> list = node.attributes();  
	        //遍历属性节点  
	        for(Attribute attribute : list){  
	            System.out.println(attribute.getName() +"=" + attribute.getValue());  
	        }  
	        //如果当前节点内容不为空，则输出  
	        if(!(node.getTextTrim().equals(""))){  
	             System.out.println( node.getName() + "=" + node.getText());    
	        }  
	        //同时迭代当前节点下面的所有子节点  
	        //使用递归  
	        Iterator<Element> iterator = node.elementIterator();  
	        while(iterator.hasNext()){  
	            Element e = iterator.next();  
	            listNodes(e);  
	        }  
	    }
	    //遍历当前节点下的所有节点  
	    public static  List<Element> getProfileNodes(Element node){  
	    	//首先获取当前节点的所有属性节点  
	    	List<Element> list = node.attributes();  
	        Iterator<Element> iterator = node.elementIterator();  
	        while(iterator.hasNext()){  
	            Element e = iterator.next(); 
	            if(e.getName().equals("profiles")){
	            	System.out.println(e.getName());
	            	 Iterator<Element> prolist =  e.elementIterator();
	            	 while(prolist.hasNext()){
	            		 Element e2 = prolist.next(); 
	            		 System.out.println(e2.getName());
	            		 System.out.println("================");
	            		 listNodes(e2);
	            		 System.out.println("================");
	            	 }
	            }  
	        }  
	    	return list;
	    }
}
