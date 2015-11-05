//package listener;
//
//
//import xml.XmlReaderDemo;
//import facades.CurrencyFacade;
//import java.io.IOException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//
//
//
//
//public class CurrencyRunner implements Runnable {
//    
//    
//    public XmlReaderDemo xread = new XmlReaderDemo();
//    
//    public CurrencyRunner(){
//        
//    }
//
//    public CurrencyRunner(XmlReaderDemo xread) {
//        this.xread = xread;
//    }
//    
//    
//
//    @Override
//    public void run() {
//        xread.updateCurrencys();
//    }
//
//}