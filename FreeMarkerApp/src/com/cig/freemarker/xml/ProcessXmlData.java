package com.cig.freemarker.xml;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.ext.dom.NodeModel;

/**
 * This class about how to prase xml file or xml string sources by freemarker template file
 * 
 * @author zhangkeh
 *
 */
public class ProcessXmlData {

	/**
	 * java application exec method
	 * @param args
	 */
	public static void main(String[] args) {
		
		// 1. source is xml file
		String xmlFileName="user_info.xml";
		
		// 2. source is xml string
		String xmlSource="<recipients>" +
							"<person><name>Deepak Keswani</name> <address>C-14, 4th, Aarohi Apartments, S.G Highways, A'bad</address> </person>" +
							"<person> <name>Bhavik Shah</name> <address>C-15, 5th, C Aarohi Apartment, Rajkot</address> </person>" +
							"<person> <name>Hitesh Methani</name> <address>D-15, 9th, H Block, Rajkot</address> </person>" +
						 "</recipients>";

		// same template file 
		String templateFileName="user_info.ftl";
		
		
		
		/**
		 * firstly parse xml file
		 */
		System.out.println("------------------        firstly parse xml file  ------------------------");
		testParseXmlFileByFreemarker(xmlFileName,templateFileName);
		
		/**
		 * second parse xml source 
		 */
		System.out.println("------------------        second parse xml source  ------------------------");
		testParserStringByFreemarker(xmlSource, templateFileName);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void testParseXmlFileByFreemarker(String xmlFileName,String templateFileName) {
		/**
		 * Steps: 1) Instantiate an engine through Configuration Class, 2)
		 * Create Template class object, Template class object is used for
		 * controlling template methods and properties. 3) Populate the
		 * dataModel, and call the process() method to create the output.
		 */

		// Add the values in the datamodel
		Map tree = new HashMap();

		File document = new File(xmlFileName);

		// Read the XML file and process the template using FreeMarker
		try {
			// NodeModel is a class of FreeMarker API, used for parsing the XML file.
			tree.put("doc", NodeModel.parse(document));
			//freemarkerDo(tree, templateFileName);
			
			// Instantiate an engine through Configuration Class
			Configuration cfg = new Configuration();

			// Create Template class object & get the Template
			Template tpl = cfg.getTemplate(templateFileName);

			// Render the template into a Writer, here a StringWriter
			StringWriter writer = new StringWriter();
			// OutputStreamWriter output = new OutputStreamWriter(System.out);

			// Merge the model & template
			tpl.process(tree, writer);

			// Print the output to console
			System.out.println(writer.toString());
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

	

	/**
	 * String maybe is xml
	 * fisrt transform xml to NodeModel then save to map
	 * second parse this map by define freemarker template
	 * finally return parse result by freemark template
	 * 
	 * @param xmlSource input source
	 * @param templateFileName freemarker template file name
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void testParserStringByFreemarker(String xmlSource, String templateFileName) {
		
		// map is store xml data 
		Map root = new HashMap();

		try {
			
			// transform input source 
			StringReader reader = new StringReader(xmlSource);
			InputSource inputSource = new InputSource(reader);
			
			// Add the values in the datamodel
			NodeModel result = NodeModel.parse(inputSource);
			root.put("doc", result);
			
			// freemarke parse string by template file
			try {
				freemarkerDo(root, templateFileName);
			} catch (Exception e) {
				System.out.println("Exception");
			}
			
		} catch (IOException e) {
			System.out.println("IOException");
		} catch (SAXException e) {
			System.out.println("SAXException");
		} catch (ParserConfigurationException e) {
			System.out.println("ParserConfigurationException");
		}

	}

	
	// Process a template using FreeMarker and print the results
	@SuppressWarnings("rawtypes")
	public static void freemarkerDo(Map datamodel, String templateFileName) throws Exception {
		// Instantiate an engine through Configuration Class
		Configuration cfg = new Configuration();

		// Create Template class object & get the Template
		Template tpl = cfg.getTemplate(templateFileName);

		// Render the template into a Writer, here a StringWriter
		StringWriter writer = new StringWriter();
		// OutputStreamWriter output = new OutputStreamWriter(System.out);

		// Merge the model & template
		tpl.process(datamodel, writer);

		// Print the output to console
		System.out.println(writer.toString());

	}
}
