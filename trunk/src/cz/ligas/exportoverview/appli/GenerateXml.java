package cz.ligas.exportoverview.appli;

import cz.ligas.exportoverview.db.Clients;
import cz.ligas.exportoverview.db.Document;
import cz.ligas.exportoverview.db.DocumentLine;
import cz.ligas.exportoverview.db.UserInfo;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 *
 * @author miro
 */
public class GenerateXml {

    public static void generateHtml(String path, Source src, String xslt)
            throws TransformerException {
//        TransformerFactory tranFactory = TransformerFactory.newInstance();
//        Transformer aTransformer = tranFactory.newTransformer();
//        aTransformer.transform(src, new StreamResult(new File("xml/test.xml")));
        File xsltFile = new File(xslt);
        File fileHtml = new File(path);
        Source xsltSource = new StreamSource(xsltFile);
        TransformerFactory transFact = TransformerFactory.newInstance();
        Transformer trans = transFact.newTransformer(xsltSource);
        trans.transform(src, new StreamResult(fileHtml));
    }

    private static Element generateUserXml(org.w3c.dom.Document doc) throws Exception {
        UserInfo ui = ClientOps.getUserInfo();
        Element client = doc.createElement("UserInfo");
        Element childElement = doc.createElement("name");
        childElement.setTextContent(ui.getClientName());
        client.appendChild(childElement);
        childElement = doc.createElement("street");
        childElement.setTextContent(ui.getClientAddress());
        client.appendChild(childElement);
        childElement = doc.createElement("zip");
        childElement.setTextContent(ui.getPsc());
        client.appendChild(childElement);
        childElement = doc.createElement("city");
        childElement.setTextContent(ui.getCity());
        client.appendChild(childElement);
        childElement = doc.createElement("country");
        childElement.setTextContent(ui.getCountry());
        client.appendChild(childElement);
        childElement = doc.createElement("ico");
        childElement.setTextContent(ui.getIco());
        client.appendChild(childElement);
        childElement = doc.createElement("dic");
        childElement.setTextContent(ui.getDic());
        client.appendChild(childElement);
        return client;
    }

    public static Source generateDocXml(String docType, Document d, Clients c, List<DocumentLine> documentLinesList)
            throws ParserConfigurationException, Exception {
        //Create instance of DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = factory.newDocumentBuilder();
        org.w3c.dom.Document doc = docBuilder.newDocument();
        //create the root element
        Element root = doc.createElement(docType);
        doc.appendChild(root);
        root.appendChild(generateUserXml(doc));
        Element client = doc.createElement("Client");
        Element childElement = doc.createElement("name");
        childElement.setTextContent(c.getClientName());
        client.appendChild(childElement);
        childElement = doc.createElement("street");
        childElement.setTextContent(c.getClientAddress());
        client.appendChild(childElement);
        childElement = doc.createElement("zip");
        childElement.setTextContent(c.getPsc());
        client.appendChild(childElement);
        childElement = doc.createElement("city");
        childElement.setTextContent(c.getCity());
        client.appendChild(childElement);
        childElement = doc.createElement("country");
        childElement.setTextContent(c.getCountry());
        client.appendChild(childElement);
        childElement = doc.createElement("ico");
        childElement.setTextContent(c.getIco());
        client.appendChild(childElement);
        childElement = doc.createElement("dic");
        childElement.setTextContent(c.getDic());
        client.appendChild(childElement);
        root.appendChild(client);
        //create child element
        for (DocumentLine dl : documentLinesList) {
            Element delLine = doc.createElement("DocumentLine");
            childElement = doc.createElement("code");
            childElement.setTextContent(dl.getProd().getProductCode() + "");
            delLine.appendChild(childElement);
            childElement = doc.createElement("name");
            childElement.setTextContent(dl.getProd().getProductName() + "");
            delLine.appendChild(childElement);
            childElement = doc.createElement("amount");
            childElement.setTextContent(dl.getAmount() + "");
            delLine.appendChild(childElement);
            childElement = doc.createElement("price");
            childElement.setTextContent(dl.getPrice() + "");
            delLine.appendChild(childElement);
            childElement = doc.createElement("vat");
            childElement.setTextContent("19%");
            delLine.appendChild(childElement);
            childElement = doc.createElement("total");
            childElement.setTextContent(dl.getTotal()+"");
            delLine.appendChild(childElement);
            root.appendChild(delLine);
        }
        Element totals = doc.createElement("Totals");
        childElement = doc.createElement("sum");
        childElement.setTextContent(d.getTotal() + "");
        totals.appendChild(childElement);
        childElement = doc.createElement("date");
        java.util.Date jDate = new Date(d.getEditDate().getTime());
        SimpleDateFormat sdf = new SimpleDateFormat("d. M. y");
        childElement.setTextContent(sdf.format(jDate));
        totals.appendChild(childElement);
        childElement = doc.createElement("docNumber");
        childElement.setTextContent(d.getDocNumber() + "");
        totals.appendChild(childElement);
        root.appendChild(totals);
        return new DOMSource(doc);
    }
}
