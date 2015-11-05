//package util;
//
//import entity.Currency;
//import facades.CurrencyFacade;
//import java.io.IOException;
//import org.xml.sax.*;
//import org.xml.sax.helpers.*;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.List;
//
//public class XmlReader extends DefaultHandler {
//
//    List<Currency> currencys = new ArrayList();
//    private String id;
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public List<Currency> getCurrencys() {
//        return currencys;
//    }
//
//    @Override
//    public void startDocument() throws SAXException {
//        System.out.println("Start Document (Sax-event)");
//    }
//
//    @Override
//    public void endDocument() throws SAXException {
//        System.out.println("End Document (Sax-event)");
//    }
//
//    @Override
//    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
//        Currency CE = new Currency();
//        for (int i = 0; i < attributes.getLength(); i++) {
//            String attribute = attributes.getLocalName(i);
//            if (attribute.equals("id")) {
//                setId(attributes.getValue(i));
//            }
//            if (attribute.equals("code")) {
//                CE.setCode(attributes.getValue(i));
//            }
//            if (attribute.equals("desc")) {
//                CE.setDescription(attributes.getValue(i));
//            }
//            if (attribute.equals("rate")) {
//                if (attributes.getValue(i).equals("-")) {
//                    CE.setRate(0);
//                } else {
//                    CE.setRate(Double.parseDouble(attributes.getValue(i)));
//                }
//            }
//            CE.setDate(id);
//
//        }
//        currencys.add(CE);
//    }
//
//    public void updateCurrencys() {
//        try {
//            XMLReader xr = XMLReaderFactory.createXMLReader();
//            xr.setContentHandler(new XmlReader());
//            URL url = new URL("http://www.nationalbanken.dk/_vti_bin/DN/DataService.svc/CurrencyRatesXML?lang=en");
//            xr.parse(new InputSource(url.openStream()));
//            CurrencyFacade cf = new CurrencyFacade();
//            List<Currency> currencyList = getCurrencys();
//            Currency CE = new Currency();
//            CE.setCode("DK");
//            CE.setDate("balls");
//            CE.setDescription("Danmark");
//            CE.setRate(20.20);
//            currencys.add(CE);
//            cf.getCurrencyRates(currencys);
//        } catch (SAXException | IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
//    