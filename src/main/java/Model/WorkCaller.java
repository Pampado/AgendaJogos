package Model;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pampado
 */

// Classe que gera thread de iniciação do Bot

public final class WorkCaller extends Thread {
    
    private int plusDay;
    
    public WorkCaller (int plusDays) throws FailingHttpStatusCodeException, IOException {
        
        this.setPlusDay(plusDays);
        start();
    }
    
    @Override
    public void run() {
        
        Work init = new Work();
        try {
            init.doStuff(this.getPlusDay());
        } catch (FailingHttpStatusCodeException | IOException | SQLException | ParseException ex) {
            Logger.getLogger(WorkCaller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getPlusDay() {
        return plusDay;
    }

    public void setPlusDay(int plusDay) {
        this.plusDay = plusDay;
    }
}
