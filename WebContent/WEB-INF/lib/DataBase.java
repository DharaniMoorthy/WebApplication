package com.infy.db;



import java.net.UnknownHostException;

import org.bson.BasicBSONObject;
import org.bson.Document;

import com.infy.bean.BuildDetails;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class DataBase {

	public String checkDetails(BuildDetails buildDetails)throws Exception
    { 
    	String string =null;
    	try {
    		 DB db=(new MongoClient("CHNMCT399659D",27017)).getDB("mydb");
    	        BasicDBObject query = new BasicDBObject();
    	        System.out.println("db"+buildDetails.getUserName());
    	        System.out.println("db"+buildDetails.getPassword());
    	        query.put("name", buildDetails.getUserName());
    	        query.put("password", buildDetails.getPassword());
    	        DBCollection collection = db.getCollection("logintable");
    	        DBCursor cursor = collection.find(query);
    	        System.out.println(cursor.count());
    	       if(cursor.count()>=1){
    	        string= "SUCCESS";
    	       }
    	       else{
    	    	   string= "Failure";
    	       }

			
		} catch (Exception e) {
			throw new Exception("Service.DBerror");
		}
    	System.out.println(string);
    	return string;
       
    }
	public String signUpDetails(BuildDetails buildDetails)throws Exception
    { 
    	String string =null;
    	try {
    		 DB db=(new MongoClient("CHNMCT399659D",27017)).getDB("mydb");
    		BasicDBObject query = new BasicDBObject();
  	        query.put("name", buildDetails.getUserName());
  	        DBCollection collection = db.getCollection("logintable");
  	        DBCursor cursor = collection.find(query);
  	        System.out.println(cursor.count());
  	      if(cursor.count()>=1){
  	        string= "Success";
  	       }
  	       else{
  	    	string= "Failure";
  	    	DBCollection dbcollection=db.getCollection("logintable");
 	        BasicDBObject basicDBObject=new BasicDBObject();
 	        basicDBObject.put("name", buildDetails.getUserName());
 	        basicDBObject.put("password", buildDetails.getPassword());
 	        dbcollection.insert(basicDBObject);
  	       }
    	        
    	      

			
		} catch (Exception e) {
			throw new Exception("Service.DBerror");
		}
    	System.out.println(string);
    	return string;
       
    }
    public String dataEntry(BuildDetails buildDetails) throws Exception{
    	try{
    	System.out.println("db");
    	DB	db=(new MongoClient("CHNMCT399659D",27017)).getDB("mydb");
    	System.out.println("datebase"+buildDetails.getBuildNumber());
        DBCollection dbcollection=db.getCollection("HybridDetails");
        BasicDBObject basicDBObject=new BasicDBObject();
        System.out.println("djwi");
        System.out.println(buildDetails.getResult());
        basicDBObject.put("BuildResult", buildDetails.getResult());
        System.out.println(buildDetails.getBuildDuration());
        basicDBObject.put("BuildDuration", buildDetails.getBuildDuration());
        System.out.println(buildDetails.getBuildNumber());
        basicDBObject.put("BuildNumber", buildDetails.getBuildNumber());
        System.out.println(buildDetails.getViolations());
        if(buildDetails.getViolations() !=null){
        	  basicDBObject.put("issues", buildDetails.getViolations());
            }
            else{
            	  basicDBObject.put("issues",0.0);
            }
      
        basicDBObject.put("TotalTestCases", buildDetails.getTotalTestCases());
        basicDBObject.put("TotalFailureTestCases", buildDetails.getTotalFailureTestCases());
        basicDBObject.put("TotalPassedTestCases", buildDetails.getTotalPassedTestCases());
        basicDBObject.put("JobName", buildDetails.getFullName());
        basicDBObject.put("Repo URL", buildDetails.getRemoteURL());
        basicDBObject.put("Version", buildDetails.getMavenVersion());
        if(buildDetails.getStatus() !=null){
        basicDBObject.put("Status", buildDetails.getStatus());
        }
        else{
        	basicDBObject.put("Status","Failed");
        }
        if(buildDetails.getOctopusDuration() !=null){
        basicDBObject.put("OctopusDuration", buildDetails.getOctopusDuration());
        }
        else{
        	 basicDBObject.put("OctopusDuration",0.0);
        }
        basicDBObject.put("SeleniumBuildDuration", buildDetails.getSeleniumBuildDuration());
        basicDBObject.put("TotalSeleniumTestCases", buildDetails.getTotalSeleniumTestCases());
        basicDBObject.put("TotalSeleniumFailureTestCases", buildDetails.getTotalSeleniumFailureTestCases());
        basicDBObject.put("TotalSeleniumPassedTestCases", buildDetails.getTotalSeleniumPassedTestCases());
        if(buildDetails.getPackName() !=null){
        basicDBObject.put("Package", buildDetails.getPackName());
        }
        else{
        	basicDBObject.put("Package","Cobertura Not Integrated");
        }
        if(buildDetails.getPackRatio() !=null){
        basicDBObject.put("PackageRatio", buildDetails.getPackRatio());
        }
        else{
        	basicDBObject.put("PackageRatio", 0.0);
        }
        if(buildDetails.getFileName() !=null){
        basicDBObject.put("Files", buildDetails.getFileName());
        }
        else{
        	 basicDBObject.put("Files","Cobertura Not Integrated");
        }
        if(buildDetails.getFileRatio() !=null){
        basicDBObject.put("FilesRatio", buildDetails.getFileRatio());
        }
        else{
        	 basicDBObject.put("FilesRatio",0.0);
        }
        if(buildDetails.getClassName() !=null){
        	 basicDBObject.put("Classes", buildDetails.getClassName());
            }
            else{
            	 basicDBObject.put("Classes","Cobertura Not Integrated");
            }
        if(buildDetails.getClassRatio() !=null){
        	basicDBObject.put("ClassesRatio", buildDetails.getClassRatio());
            }
            else{
            	 basicDBObject.put("ClassesRatio",0.0);
            }
        
        if(buildDetails.getMethodName() !=null){
        	 basicDBObject.put("Methods", buildDetails.getMethodName());
           }
           else{
           	 basicDBObject.put("Methods","Cobertura Not Integrated");
           }
        if(buildDetails.getMethodRatio() !=null){
        	   basicDBObject.put("MethodsRatio", buildDetails.getMethodRatio());
            }
            else{
            	 basicDBObject.put("MethodsRatio",0.0);
            }
        if(buildDetails.getLineName() !=null){
        	  basicDBObject.put("Lines", buildDetails.getLineName());
        	  }
          else{
          	 basicDBObject.put("Lines","Cobertura Not Integrated");
          }
        if(buildDetails.getLineRatio() !=null){
        	   basicDBObject.put("LinesRatio", buildDetails.getLineRatio());
            }
            else{
            	 basicDBObject.put("LinesRatio",0.0);
            }
        
        if(buildDetails.getCobName() !=null){
        	  basicDBObject.put("CoverageAreaName", buildDetails.getCobName());
      	  }
        else{
        	 basicDBObject.put("CoverageAreaName","Cobertura Not Integrated");
        }
        if(buildDetails.getCobRatio() !=null){
        	  basicDBObject.put("CoverageRatio", buildDetails.getCobRatio());
         }
         else{
         	 basicDBObject.put("CoverageRatio",0.0);
         }
        
        if(buildDetails.getMajorViolations() !=null){
      	  basicDBObject.put("Major", buildDetails.getMajorViolations());
       }
       else{
       	 basicDBObject.put("Major",0.0);
       }
        if(buildDetails.getMinorViolations() !=null){
      	  basicDBObject.put("Minor", buildDetails.getMinorViolations());
       }
       else{
       	 basicDBObject.put("Minor",0.0);
       }
        if(buildDetails.getCritical() !=null){
      	  basicDBObject.put("Critical", buildDetails.getCritical());
       }
       else{
       	 basicDBObject.put("Critical",0.0);
       }
        if(buildDetails.getBlocker() !=null){
      	  basicDBObject.put("Blocker", buildDetails.getBlocker());
       }
       else{
       	 basicDBObject.put("Blocker",0.0);
       }
        dbcollection.insert(basicDBObject);
    	}
    	catch(Exception e){
    		System.out.println(e.getMessage());
    	throw new Exception("Service.DBerror");
    	}
        return "OK";    	
    }
    public BuildDetails getData(Double i) throws Exception{
    	BuildDetails buildDetails=new BuildDetails();
    	try{
    		System.out.println("inside getting");
    	    	 
    	DB	db=(new MongoClient("CHNMCT399659D",27017)).getDB("mydb");
    	DBCollection coll = db.getCollection("HybridDetails");
    	System.out.println(coll);
    	BasicDBObject query = new BasicDBObject();
    	query.put("BuildNumber", i);	
    	DBCursor cursor = coll.find(query);
    	System.out.println(cursor.hasNext());
    	DBObject oneDetails;  	
    	while (cursor.hasNext()) {
    		
    		System.out.println("Test 1");
    		oneDetails=cursor.next();    
    	    String str=oneDetails.get("BuildResult").toString();
    	    buildDetails.setResult(str);
    	    System.out.println("result"+str);
    	    
    	    System.out.println("Test 2");
    	    Double d=(Double) oneDetails.get("BuildDuration");
    	    buildDetails.setBuildDuration(d);
    	    
    	    System.out.println("Test 3");   
    	    Double d1=(Double) oneDetails.get("BuildNumber");
    	    buildDetails.setBuildNumber(d1);
    	    
    	    System.out.println("Test 4");
    	    Double d2=(Double) oneDetails.get("TotalTestCases");
    	    buildDetails.setTotalTestCases(d2);
    	    
    	    System.out.println("Test 5"); 
    	    Double d3=(Double) oneDetails.get("TotalFailureTestCases");
    	    buildDetails.setTotalFailureTestCases(d3);;
    	    
    	    System.out.println("Test 6"); 
    	    Double d4=(Double) oneDetails.get("TotalPassedTestCases");
    	    buildDetails.setTotalPassedTestCases(d4);;
    	    
    	    System.out.println("Test 7"); 
    	    Double d5=(Double) oneDetails.get("issues");
    	    buildDetails.setViolations(d5);
    	    
    	    System.out.println("Test 8"); 
    	    if(oneDetails.get("Status") !=null){
    	    String str1=oneDetails.get("Status").toString();
    	    buildDetails.setStatus(str1);
    	    System.out.println("result"+str1);
    	}
    	    else{
    	    	 buildDetails.setStatus("Failed");
    	    }
    	    
    	  
    	    System.out.println("Test 9");  
    	    Double d6=(Double) oneDetails.get("TotalSeleniumTestCases");
    	    buildDetails.setTotalSeleniumTestCases(d6);;
    	    System.out.println("ts"+d6);
    	   
    	    
    	    System.out.println("Test 10");  
    	    Double d7=(Double) oneDetails.get("TotalSeleniumFailureTestCases");
    	    buildDetails.setTotalSeleniumFailureTestCases(d7);
    	    System.out.println("tfs"+d7);
    	    
    	    System.out.println("Test 11");  
    	    Double d8=(Double) oneDetails.get("TotalSeleniumPassedTestCases");
    	    buildDetails.setTotalSeleniumPassedTestCases(d8);
    	    System.out.println("tps"+d8);
    	    
    	   
    	    Double d9=(Double) oneDetails.get("OctopusDuration");
    	    buildDetails.setOctopusDuration(d9);
    	    
    	    String str1=oneDetails.get("CoverageAreaName").toString();
    	    buildDetails.setCobName(str1);;  System.out.println("result"+str);
    	   
    	    Double d10=(Double) oneDetails.get("CoverageRatio");
    	    buildDetails.setCobRatio(d10);
 
    	    String str2=oneDetails.get("Package").toString();
    	    buildDetails.setPackName(str2);  
    	   
    	    Double d11=(Double) oneDetails.get("PackageRatio");
    	    buildDetails.setPackRatio(d11);;
    	    
    	    String str3=oneDetails.get("Files").toString();
    	    buildDetails.setFileName(str3);
    	   
    	    Double d12=(Double) oneDetails.get("FilesRatio");
    	    buildDetails.setFileRatio(d12);
    	    
    	    String str4=oneDetails.get("Classes").toString();
    	    buildDetails.setClassName(str4);;
    	   
    	    Double d13=(Double) oneDetails.get("ClassesRatio");
    	    buildDetails.setClassRatio(d13);
    	    
    	    String str5=oneDetails.get("Methods").toString();
    	    buildDetails.setMethodName(str5);
    	   
    	    Double d14=(Double) oneDetails.get("MethodsRatio");
    	    buildDetails.setMethodRatio(d14);
    	    
    	    String str6=oneDetails.get("Lines").toString();
    	    buildDetails.setLineName(str6);
    	   
    	    Double d15=(Double) oneDetails.get("LinesRatio");
    	    buildDetails.setLineRatio(d15);
  
    	    String str7=oneDetails.get("JobName").toString();
    	    buildDetails.setFullName(str7);
     
    	   String str8=oneDetails.get("Repo URL").toString();
    	    buildDetails.setRemoteURL(str8);
    	    
    	    String str9=oneDetails.get("Version").toString();
    	    buildDetails.setMavenVersion(str9);
    	    
    	    Double d16=(Double) oneDetails.get("Major");
    	    buildDetails.setMajorViolations(d16);
    	    
    	    Double d17=(Double) oneDetails.get("Minor");
    	    buildDetails.setMinorViolations(d17);
    	    
    	    Double d18=(Double) oneDetails.get("Blocker");
    	    buildDetails.setBlocker(d18);
    	    
    	    Double d19=(Double) oneDetails.get("Critical");
    	    buildDetails.setCritical(d19);
    	    
    	    }
		
    	}
    	catch(Exception e){
    		System.out.println(e);
        	throw new Exception("Service.DBerror");
        	}
    
		return buildDetails;
    	
    	} 
    
    public  double getLastData() throws Exception{
    	
    	 double buildNo;
    	 try{
    	 MongoDatabase database = (new MongoClient("CHNMCT399659D",27017)).getDatabase("mydb");
    	 MongoCollection<Document> collection = database.getCollection("HybridDetails"); 
    	 FindIterable<Document> user = null;
    	 String hashedAndSalted;
    	 user = collection.find().sort(new BasicDBObject("BuildNumber",-1)).limit(1);
    	 try {
    		 hashedAndSalted = user.first().get("BuildNumber").toString();
        	 buildNo = Double.parseDouble(hashedAndSalted);    		  
         }
    	 catch(Exception e){   	 
    	 buildNo = 0.0;    
    }
    	}
    	catch(Exception e){
        	throw new Exception("Service.DBerror");
        	}
    	 return buildNo;
    	 
    }
    	 
	}



