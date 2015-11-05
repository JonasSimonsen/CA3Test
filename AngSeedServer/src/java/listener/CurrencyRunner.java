package listener;

import facades.CurrencyFacade;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.XmlReader;

public class CurrencyRunner implements Runnable {
    
    
    public XmlReader xread = new XmlReader();
    
    public CurrencyRunner(){
        
    }

    public CurrencyRunner(XmlReader xread) {
        this.xread = xread;
    }
    
    

    @Override
    public void run() {
        xread.updateCurrencys();
    }

}