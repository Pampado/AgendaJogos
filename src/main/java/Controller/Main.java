package Controller;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import java.io.IOException;
import java.text.ParseException;


/**
 *
 * @author pampado
 */

public class Main {
    
    // Inicia os trabalhos do bot
    
    public static void main(String[] args) throws FailingHttpStatusCodeException, IOException, ParseException {
        
        int qtdDias = 5; //Qtd de dias a ser verificado | A quantidade de conexões simultaneas com o BD será o limitador
        
        for (int i = 0; i <= qtdDias; i++) {
            
            Model.WorkCaller newThread = new Model.WorkCaller(i);
        }
    }
}
