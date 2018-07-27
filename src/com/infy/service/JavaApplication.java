package com.infy.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.json.JSONObject;
import org.json.simple.parser.ParseException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.infy.bean.BuildDetails;


import com.infy.db.DataBase;
public class JavaApplication {
	   ArrayList<BuildDetails> list=new  ArrayList<>();
	  BuildDetails buildDetails=new BuildDetails();
	   double buildNo;
	   double totaltestcases1;
	   double totalfailtestcases1;
	   double version;
	   	   
	    public String CheckDetails(BuildDetails buildDetails1) throws Exception{
	    	DataBase data=new DataBase();
	    	String checkDetails=null;
			System.out.println("service");
				checkDetails = data.checkDetails(buildDetails1);
				if(checkDetails.equals("Failure")){
					throw new Exception("Service.INVALID_LOGIN");
				}
			
	    	return checkDetails;
	    	
	    	
	    }
	    
	    
   
/*}*/
/*public static  void main(String[] args) throws Exception {
	dashboardService();
}*/
}
		
	
	    


	
	

