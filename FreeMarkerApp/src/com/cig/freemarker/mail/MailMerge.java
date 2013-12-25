package com.cig.freemarker.mail;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class MailMerge
{

    /**
     * @param args
     */
    public static void main(String[] args){
        try {
           //testFreemakrerExecResult(null,"temateExecTemplate.ftl");
        	testEmaliMerge();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * test meail merge method
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public static void testEmaliMerge(){
        /**
         * Steps: 
         *  1) Instantiate an engine through Configuration Class,
         *  2) Create Template class object, Template  class object is used for controlling template methods and properties.
         *  3) Populate the dataModel, and call the process() method to create the output.
         */

        // Add the values in the datamodel
        // Properties data = new Properties();
        Map dataModel = new HashMap();
        Map<String, String> recpInfo = new HashMap<String, String>();
        List<Map<String, String>> recipientList = new ArrayList<Map<String, String>>();

        recpInfo.put("recipient", "Deepak");
        recpInfo.put("address", "C-14, 4th, Aarohi Apartments, S.G Highways, A'bad.");
        recipientList.add(recpInfo);

        recpInfo = new HashMap<String, String>();
        recpInfo.put("recipient", "Bhavik");
        recpInfo.put("address", "C-15, 5th, C Aarohi Apartment, Rajkot.");
        recipientList.add(recpInfo);

        recpInfo = new HashMap<String, String>();
        recpInfo.put("recipient", "Hitesh");
        recpInfo.put("address", "D-15, 9th, H Block, Rajkot.");
        recipientList.add(recpInfo);

        dataModel.put("recepientList", recipientList);

        // Process the template using FreeMarker
        try
        {
            // data.load(new FileInputStream("mail.properties"));
            // freemarkerDo(data, "mail.ftl");

            freemarkerDo(dataModel, "sendEmail.ftl");

        } catch (Exception e)
        {
            System.out.println(e.getLocalizedMessage());
        }
    }
    
    
    // Process a template using FreeMarker and print the results
    static void freemarkerDo(Map datamodel, String template) throws Exception
    {
        // Instantiate an engine through Configuration Class
        Configuration cfg = new Configuration();

        // Create Template class object & get the Template
        Template temp = cfg.getTemplate(template);

        // OutputStreamWriter output = new OutputStreamWriter(System.out);

        // Render the template into a Writer, here a StringWriter
        StringWriter writer = new StringWriter();

        // Merge the model & template
        temp.process(datamodel, writer);
        
        // Use the output in the body of your emails
        System.out.println(writer.toString());
    }
    
    
    /**
     * just a test method to test freemarker template exec code result 
     * @param datamodel
     * @param template
     * @throws Exception
     */
    public static void testFreemakrerExecResult(@SuppressWarnings("rawtypes") Map datamodel, String template) throws Exception{
        
        Configuration cfg = new Configuration();

        /**
         *  Create Template class object & get the Template,  
         *  template path is this project root foler
         */
        Template temp = cfg.getTemplate(template);

        // OutputStreamWriter output = new OutputStreamWriter(System.out);

        // Render the template into a Writer, here a StringWriter
        StringWriter writer = new StringWriter();

        // Merge the model & template
        temp.process(datamodel, writer);
        
        // Use the output in the body of your emails
        System.out.println(writer.toString());
    }
    
}
