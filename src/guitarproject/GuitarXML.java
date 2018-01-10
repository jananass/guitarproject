/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guitarproject;
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
/**
 *
 * @author s16005598
 */
public class GuitarXML {
    public GuitarChord[] chords;
    
    public GuitarXML(){
    }
    
    public void searchXML()
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            factory.setValidating(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            ErrorHandler errHandler = new GuitarXMLErrorHandler();
            builder.setErrorHandler(errHandler);
            
            File fileXML = new File("src/chords/chords.xml");

            try
            {
                Document xml = builder.parse(fileXML);
                NodeList root = xml.getElementsByTagName("chord");
                chords = fromChords(root);
            }
            catch (SAXParseException e){}
        }
        catch (ParserConfigurationException e)
        {
            e.printStackTrace();
        }
        catch (SAXException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public GuitarChord[] fromChords(NodeList nlist)
    {
        GuitarChord[] c = new GuitarChord[nlist.getLength()];
        
        for (int i = 0;i< nlist.getLength();i++)
        {
            Node n = nlist.item(i);
            NodeList elem= n.getChildNodes();
            c[i] = new GuitarChord();
            String tuning ="";
            String strings[] = new String[6];
            for (int j = 0; j<elem.getLength();j++)
            {
                Node m = elem.item(j);
                String name = m.getNodeName();
                if (m instanceof Element)
                {
                    Element me = ((Element) m);
                    switch (name)
                    {
                        case "name" :
                            System.out.println(c[i].name);
                            c[i].name = me.getAttribute("value");
                            break;
                        case "fret" :
                            c[i].fret = Integer.parseInt(me.getAttribute("value"));
                            break;
                        case "string" :
                            tuning = (me.getAttribute("id").equals("1") ? me.getAttribute("tuning") : tuning + " " + me.getAttribute("tuning") );
                            strings[Integer.parseInt(me.getAttribute("id"))-1] = me.getAttribute("value");
                            break;
                    }
                }    
            }
            c[i].tuning = tuning;
            c[i].strings = strings;
        }
        
        return c;
    }
}
