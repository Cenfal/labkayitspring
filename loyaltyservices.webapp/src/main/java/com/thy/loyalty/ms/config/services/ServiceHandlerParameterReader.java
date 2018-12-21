package com.thy.loyalty.ms.config.services;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.thy.loyalty.ms.config.StringUtils;

public class ServiceHandlerParameterReader {
	
	private static Log logger = LogFactory
			.getLog(ServiceHandlerParameterReader.class);

	public ServiceHandlerParameterReader() {
		// TODO Auto-generated constructor stub
	}
	
	
	public static void readXml(String path) throws ParserConfigurationException, SAXException
	{
		try 
		{
			  File file = new File(path);
			  DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			  DocumentBuilder db = dbf.newDocumentBuilder();
			  Document doc = db.parse(file);
			  doc.getDocumentElement().normalize();

			  NodeList nodeLst = doc.getElementsByTagName("service");

			  Service tempService = null;
			  for (int s = 0; s < nodeLst.getLength(); s++) {

			    Node serviceNode = nodeLst.item(s);
			    
			    if (serviceNode.getNodeType() == Node.ELEMENT_NODE) {

			      Element serviceElement = (Element) serviceNode;

			      NodeList serviceElementList = serviceElement.getElementsByTagName("serviceName");

			      Element serviceNameElmnt = (Element) serviceElementList.item(0);
			      NodeList serviceElements = serviceNameElmnt.getChildNodes();
			      String tempServiceName = ((Node) serviceElements.item(0)).getNodeValue();

			      tempService = new Service();
			      tempService.setName(tempServiceName);

			      NodeList methodElementList = serviceElement.getElementsByTagName("method");

			      Method tempMethod = null;
			      for (int n=0;n<methodElementList.getLength();n++)
			      {
			    	  Node methodNode = methodElementList.item(n);

			    	  NodeList nl = methodNode.getChildNodes();

			    	  for(int j=0; j<nl.getLength(); j++)
			    	  {

			    		  if (((Node)nl.item(j)).getNodeName().toString().equals("methodName"))
			    		  {
			    			  tempMethod = new Method();
			    			  String methodName = ((Node)nl.item(j)).getFirstChild().getNodeValue();
			    			  tempMethod.setName(methodName);
			    		  }

			    		  if (((Node)nl.item(j)).getNodeName().toString().equals("transactionIdDetails"))
			    		  {

				    		  Node transactionIdMain = nl.item(j);
				    		  
				    		  NodeList nlTransactionDetails = (transactionIdMain).getChildNodes();

			    			  for (int q=0;	q<nlTransactionDetails.getLength();	q++)
			    			  {

			    				  Node transactionIdNode = nlTransactionDetails.item(q);

					    		  if (transactionIdNode.getNodeType() == Node.ELEMENT_NODE) {

									  Element transactionIdDetailsElement = (Element) transactionIdNode;

									  if (transactionIdDetailsElement.getNodeName().equals("transactionIdUsage"))
									  {
//										  System.out.println("transactionIdUsage : " +transactionIdDetailsElement.getChildNodes().item(0).getNodeValue());
										  tempMethod.setTransactionIdUsage(transactionIdDetailsElement.getChildNodes().item(0).getNodeValue());
									  }
									  else if (transactionIdDetailsElement.getNodeName().equals("transactionIdParamName"))
									  {
//										  System.out.println("transactionIdParamName : " +transactionIdDetailsElement.getChildNodes().item(0).getNodeValue());
										  tempMethod.setTransactionIdParamName(transactionIdDetailsElement.getChildNodes().item(0).getNodeValue());
									  }
									  else if (transactionIdDetailsElement.getNodeName().equals("transactionIdPosition"))
									  {
//										  System.out.println("transactionIdPosition : " +transactionIdDetailsElement.getChildNodes().item(0).getNodeValue());
										  tempMethod.setTransactionIdPosition(transactionIdDetailsElement.getChildNodes().item(0).getNodeValue());
									  }
									  else if (transactionIdDetailsElement.getNodeName().equals("transactionIdNotExistingAction"))
									  {
//										  System.out.println("transactionIdNotExistingAction : " +transactionIdDetailsElement.getChildNodes().item(0).getNodeValue());
										  tempMethod.setTransactionIdNotExistingAction(transactionIdDetailsElement.getChildNodes().item(0).getNodeValue());
									  }

					    		  }

			    			  }
			    		  }    		  

			    		  if (((Node)nl.item(j)).getNodeName().toString().equals("parameters"))
			    		  {

				    		  Node paramNodeMain = nl.item(j);
				    		  
				    		  NodeList nlParameters = (paramNodeMain).getChildNodes();

			    			  for (int q=0;	q<nlParameters.getLength();	q++)
			    			  {

			    				  Node paramNode = nlParameters.item(q);

					    		  if (paramNode.getNodeType() == Node.ELEMENT_NODE) {

					    			  Parameter parameter = new Parameter();
					    			  
					    			  
									  Element nameOnMethod = (Element) paramNode;
									  NodeList nameOnMethodList = nameOnMethod.getElementsByTagName("nameOnMethod");
									  Element nameOnMethodElement = (Element) nameOnMethodList.item(0);
									  NodeList nameOnMethodElementList = nameOnMethodElement.getChildNodes();

									  String nameOnMethodString = ((Node) nameOnMethodElementList.item(0)).getNodeValue();
									  
									  parameter.setNameOnMethod(nameOnMethodString);

									  Element nameOnTable = (Element) paramNode;
									  NodeList nameOnTableList = nameOnTable.getElementsByTagName("nameOnTable");
									  Element nameOnTableElement = (Element) nameOnTableList.item(0);
									  NodeList nameOnTableElementList = nameOnTableElement.getChildNodes();

									  String nameOnTableString = ((Node) nameOnTableElementList.item(0)).getNodeValue();

									  parameter.setNameOnTable(nameOnTableString);
									  
									  tempMethod.getParameters().add(parameter);

					    	    }
			    			  }
				    		  if (tempMethod!=null)
				    		  {
				    			  tempService.getMethods().add(tempMethod);
				    			  tempMethod = null;
				    		  }
			    		  }

			    		  
			    	  }
			      }
			    }
			    
			    if (tempService != null)
			    {
			    	MSServiceHolder.addService(tempService);
			    	tempService = null;
			    }
			    
			  }
			  
			  
			} 
			catch (Exception e) 
			{
			    //e.printStackTrace();
			    logger.error(StringUtils.stack2string( e ) );
			}
	}

	}
	
