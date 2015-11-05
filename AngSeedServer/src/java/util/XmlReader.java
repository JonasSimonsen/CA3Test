//package util;
//
import entity.CurrencyRates;
import facades.CurrencyFacade;
import java.io.IOException;
import org.xml.sax.*;
import org.xml.sax.helpers.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
//
public class XmlReader extends DefaultHandler implements Runnable {

    List<CurrencyRates> currencyList = new ArrayList();
    String code = "";
    String desc = "";
    Double rate = 0.0;
    String date = "";

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start Document (Sax-event)");
    }

    @Override
    public void endDocument() throws SAXException {
        CurrencyFacade facade = new CurrencyFacade();
        facade.addCurrenciesToDB(currencyList);
        System.out.println("End Document (Sax-event)");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
//        System.out.print("Element: " + localName + ": ");
//        for (int i = 0; i < attributes.getLength(); i++) {
//            System.out.print("[Atribute: NAME: " + attributes.getLocalName(i) + " VALUE: " + attributes.getValue(i) + "] ");
//        }
//        System.out.println("");

        if (attributes.getLocalName(0).equals("id")) {
            date = attributes.getValue(0);
        }
        
        for (int i = 0; i < attributes.getLength(); i++) {
            if (attributes.getLocalName(i).equals("code")) {
                code = attributes.getValue(i);
            } else if (attributes.getLocalName(i).equals("desc")) {
                desc = attributes.getValue(i);
            } else if (attributes.getLocalName(i).equals("rate")) {
                if (attributes.getValue(i).equals("-")) {
                    rate = 1.0;
                } else {
                    rate = Double.parseDouble(attributes.getValue(i));
                }
            }
        }
        if (rate != 0.0) {
            currencyList.add(new CurrencyRates(code, desc, rate, date));
            rate = 0.0;
        }
    }

    public static void main(String[] argv) {
        try {
            XMLReader xr = XMLReaderFactory.createXMLReader();
            xr.setContentHandler(new XmlReader());
            URL url = new URL("http://www.nationalbanken.dk/_vti_bin/DN/DataService.svc/CurrencyRatesXML?lang=en");
            xr.parse(new InputSource(url.openStream()));
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            XMLReader xr = XMLReaderFactory.createXMLReader();
            xr.setContentHandler(new XmlReader());
            URL url = new URL("http://www.nationalbanken.dk/_vti_bin/DN/DataService.svc/CurrencyRatesXML?lang=en");
            xr.parse(new InputSource(url.openStream()));
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }

}
//    