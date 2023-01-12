package com.fincomp.Dev_FinComp.Services.SearchImpl;

import com.fincomp.Dev_FinComp.Services.SearchXML;
import lombok.Getter;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


@Service
public class SdnService implements SearchXML {


    private final URL url;

    {
        try {
            url = new URL("https://www.treasury.gov/ofac/downloads/sdn.xml");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private final String PRINCIPAL_NODE = "sdnEntry";
    public final String NODE_CHILD_ID = "id"; // Nodo de busqueda de id para existsId
    public final String NODE_CHILD_AKA = "aka"; // Nodo de busqueda de id para existsName
    public final String TAG_SEARCH_ID = "idNumber"; // tagname de busqueda de id para existsId
    public final String TAG_SEARCH_AKA = "lastName"; // tagname de busqueda de id para existsName


    @Override
    public Document readFile() {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            // Document doc = db.parse(file);
            URLConnection conn = this.url.openConnection();
            Document doc = db.parse(conn.getInputStream());
            doc.getDocumentElement().normalize();

            return doc;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Node existsId(String id) {
        try {
            Document doc = readFile();
            assert doc != null;
            NodeList nodeList = doc.getElementsByTagName(this.PRINCIPAL_NODE);
            for (int itr = 0; itr < nodeList.getLength(); itr++) {
                Node node = nodeList.item(itr);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
                    NodeList idChildren = eElement.getElementsByTagName(this.NODE_CHILD_ID);
                    for (int i = 0; i < idChildren.getLength(); i++) {
                        Node child = idChildren.item(i);
                        Element idElement = (Element) child;
                        String ok = idElement.getElementsByTagName(this.TAG_SEARCH_ID).item(0).getTextContent();
                        if (ok.equals(id)) {
                            return node;
                        }
                    }
                }
            }
            return null;
        } catch (NullPointerException e) {
            return null;
        }
    }

    @Override
    public Node existsName(String name) {
        try {
            Document doc = readFile();

            NodeList nodeList = doc.getElementsByTagName(this.PRINCIPAL_NODE);
            for (int itr = 0; itr < nodeList.getLength(); itr++) {
                Node node = nodeList.item(itr);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
                    String ok = eElement.getElementsByTagName(this.TAG_SEARCH_AKA).item(0).getTextContent();
                    if (ok.equals(name)) {
                        return node;
                    }else {
                        NodeList idChildren = eElement.getElementsByTagName(this.NODE_CHILD_AKA);
                        for (int i = 0; i < idChildren.getLength(); i++) {
                            Node child = idChildren.item(i);
                            Element lastName = (Element) child;
                            String x = lastName.getElementsByTagName(this.TAG_SEARCH_AKA).item(0).getTextContent();
                            if (x.equals(name)) {
                                return node;
                            }
                        }
                    }
                }
            }
            return null;
        } catch (NullPointerException e) {
            return null;
        }
    }
}
