package org.centrale.api.service;

import org.centrale.domain.*;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class GameService {


    public List<String> historyOfWinner = new ArrayList<>();

    public Game game = new Game();

    public String playGame(String playerName1, String playerName2){
        Player player1 = new Player();
        Player player2 = new Player();

        for (int i = 0; i < game.playerList.size(); i++) {
            if(playerName1.equals(game.playerList.get(i).name)){
                player1 = game.playerList.get(i);

            } else if(playerName2.equals(game.playerList.get(i).name)){
                player2 = game.playerList.get(i);
            }
        }
        int res = game.play(player1, player2);
        String ret = "";
        if(res!=0){
            if(res==1){
                historyOfWinner.add(player1.name);
                ret = "player1 wins this one";
            } else if(res==-1)
            {
                historyOfWinner.add(player2.name);
                ret = "player2 wins this one";
            }
        } else {
            ret = "draw";
        }
        return ret;
    }

    public List<String> getHistoryOfWinner(){
        return historyOfWinner;
    }

    public List<Player> getPlayerList(){
        return game.getList();
    }

    public void setHand(String playerName, int hand){
        for (int i = 0; i < game.playerList.size() ; i++) {
            Player tempPlayer = game.playerList.get(i);
            if(tempPlayer.name.equals(playerName)){
                tempPlayer.play(hand);
            }
        }
    }

    public void addPlayer(String name){
        Player player = new Player();
        player.name = name;
        game.addPlayer(player);
    }

    public void removePlayer(String playerName){
        for (int i = 0; i < game.playerList.size() ; i++) {
            if(playerName.equals(game.playerList.get(i).name)){
                game.removePlayer(game.playerList.get(i));
            }
        }
    }

}
