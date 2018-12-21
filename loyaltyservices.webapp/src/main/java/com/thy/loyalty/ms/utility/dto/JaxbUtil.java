package com.thy.loyalty.ms.utility.dto;

import java.io.StringReader;
import java.io.StringWriter;
import java.net.MalformedURLException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

public class JaxbUtil {
	
//	private static final SchemaFactory sf = SchemaFactory.newInstance( XMLConstants.W3C_XML_SCHEMA_NS_URI );
	private static final SchemaFactory sf = SchemaFactory.newInstance( "http://www.w3.org/2001/XMLSchema" );
	
	public static <T> String marshal(T object) throws JAXBException, SAXException{
			
			Object jaxbOrPlainObject = object;
			Class clazz = object.getClass();
			
			boolean isXmlRootElement = object.getClass().getAnnotation(XmlRootElement.class) != null ;
			boolean isJaxbElement = object.getClass().equals(JAXBElement.class);
			
			if(isJaxbElement == true){
				clazz = ((JAXBElement)object).getValue().getClass();
			}
			
			if(isXmlRootElement == false && isJaxbElement == false){
				XmlType type = object.getClass().getAnnotation(XmlType.class);
				String name = type.name();
				String namespace = type.namespace();
				
				QName qname = null; 
				if(namespace.equals("##default")){
					qname = new QName(name);
				}else{
					qname = new QName(namespace, name);
				}
				
				
				JAXBElement<T> _temp = new JAXBElement<T>(qname,clazz,null,object);
				
				jaxbOrPlainObject = _temp;
			}
			
			StringWriter sw = new StringWriter();
			
			JAXBContext jc = JAXBContext.newInstance(clazz);
			
			Marshaller m = jc.createMarshaller();
	        
	        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	        m.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
	        
	        m.marshal(jaxbOrPlainObject, sw );
			
			return sw.toString();
		}

	public static <T> T unmarshal(String xml, Class<T> clazz) throws MalformedURLException, SAXException, JAXBException {
		
		StreamSource source = new StreamSource(new StringReader(xml));
		
		JAXBContext jc = JAXBContext.newInstance(clazz.getPackage().getName());
		
		Unmarshaller u = jc.createUnmarshaller();
		
		Object object = u.unmarshal(source,clazz);
		
		if(object.getClass().equals(JAXBElement.class)){
			JAXBElement element = (JAXBElement) object;
			object = element.getValue();
		}
		
		T t = (T)object;
		return t;
	}
	
}
