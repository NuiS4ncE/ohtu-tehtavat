/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;


import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;
import java.util.Date;

/**
 *
 * @author mluukkai
 */
public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";
        
        String bodyText = Request.Get(url).execute().returnContent().asString();
                
        //System.out.println("json-muotoinen data:");
        //System.out.println( bodyText );

        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);
        Date date = new Date();
        System.out.println("Players from FIN " + date + "\n");
        //System.out.println("Oliot:");
        for (Player player : players) {
            if(player.getNationality().equals("FIN")) {
                int sum = Integer.parseInt(player.getGoals()) + Integer.parseInt(player.getAssists());
                System.out.printf("%-5s %-5s %-5s + %5s = %5s%n", player, player.getTeam(), player.getGoals(), player.getAssists(), sum);
                //System.out.println(player + "    " + player.getTeam()
                //+ " goals " + player.getGoals() + " assists " + player.getAssists());
            }
        }   
    }
      
}
