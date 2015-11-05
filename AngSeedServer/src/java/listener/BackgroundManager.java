//package listener;
//
//import facades.UserFacade;
//import java.util.concurrent.Executors;
//import java.util.concurrent.ScheduledExecutorService;
//import java.util.concurrent.TimeUnit;
//import javax.servlet.ServletContextEvent;
//import javax.servlet.ServletContextListener;
//import javax.servlet.annotation.WebListener;
//
//@WebListener
//public class BackgroundManager implements ServletContextListener {
//
//    private ScheduledExecutorService scheduler;
//
//    @Override
//    public void contextInitialized(ServletContextEvent event) {
//        scheduler = Executors.newSingleThreadScheduledExecutor();
//        scheduler.scheduleAtFixedRate(new CurrencyRunner(), 0, 24, TimeUnit.HOURS);
//    }
//
//    @Override
//    public void contextDestroyed(ServletContextEvent event) {
//        scheduler.shutdownNow();
//    }
//
//}