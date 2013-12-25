package com.cig.freemarker.webpage;

import freemarker.template.Template;
import freemarker.template.Configuration;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class WebPageSample {

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        /**
         * Steps: 
         *  1) Instantiate an engine through Configuration Class,
         *  2) Create Template class object, Template  class object is used for controlling template methods and properties.
         *  3) Populate the dataModel, and call the process() method to create the output.
         */
        
        // Add the values in the datamodel
        Map<String, Object> datamodel = new HashMap<String, Object>();

        datamodel.put("pet", "Bunny");
        datamodel.put("number", new Integer(6));

        // Process the template using FreeMarker
        try {
            
            freemarkerDo(datamodel, "webPageSample.html");
            
            /**
             * example about self-define file extension 
             */
            //freemarkerDo(datamodel, "webPageSample1.abc");
        }catch(Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
    
    //Process a template using FreeMarker and print the results
    static void freemarkerDo(Map datamodel, String template) throws Exception
    {
        // Instantiate an engine through Configuration Class
        Configuration cfg = new Configuration();
        
        //Create Template class object & get the Template
        Template temp = cfg.getTemplate(template);
        
        //Render the template into a Writer, here a StringWriter
         StringWriter writer = new StringWriter();
        //OutputStreamWriter output = new OutputStreamWriter(System.out);
        
        //Merge the model & template
        temp.process(datamodel, writer);
        
        //Print the output to console
        System.out.println(writer.toString());
    }

}

