package Model;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author pampado
 */

public class Work {
    
    // Pega o HTML, separa as informações dos jogos, grava nos devidos campos da classe entidade e envia para gravação no BD
    
    public void doStuff(int plusDays) throws FailingHttpStatusCodeException, IOException, SQLException, ParseException {
        
        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        webClient.getOptions().setJavaScriptEnabled(false);
        webClient.getOptions().setCssEnabled(false);
        String date = setDate(plusDays);
        String URL = "https://globoesporte.globo.com/placar-ge/" + date + "/jogos.ghtml";
        HtmlPage page = webClient.getPage(URL);
        List<HtmlElement> games = page.getByXPath("//*[@id=\"futuro\"]/section[*]/article");
        
        for (HtmlElement e : games) {
            
            DomNodeList<HtmlElement> nodeSpan = e.getElementsByTagName("span");
            Game game = new Game();
            game.setChampName(nodeSpan.get(0).getTextContent());
            game.setHomeTeam(nodeSpan.get(1).getTextContent());
            game.setAwayTeam(nodeSpan.get(2).getTextContent());
            DomNodeList<HtmlElement> nodeTime = e.getElementsByTagName("time");
            String gameHour = nodeTime.get(0).getTextContent();
            date+=gameHour;
            Date initDate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(date);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String parsedDate = formatter.format(initDate);
            game.setGameDate(parsedDate);
            System.out.println("###################################\n               Jogo\n"+game.getHomeTeam()+" X "+game.getAwayTeam()+"\nHorário: "+gameHour+"\n"+game.getChampName());
            System.out.println("");
            DBRCaller dbrc = new DBRCaller(game);
        }
    }
    
    // Define e retorna a data atual, adicionando, ou nao, quantidade de dias a ela
    // Recebe a quantidade de dias como parametro
    
    public static String setDate(int days) {
        
        Date actualDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(actualDate);
        c.add(Calendar.DATE, +days);
        String fDate = new SimpleDateFormat("dd-MM-yyyy").format(c.getTime());
        return fDate;
    }
}