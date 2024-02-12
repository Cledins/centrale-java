package org.centrale.api.service;
import java.util.NoSuchElementException;

import org.centrale.api.GameEntity;
import org.centrale.api.GameRepository;
import org.centrale.api.PlayerEntity;
import org.centrale.api.PlayerRepository;
import org.centrale.domain.*;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class GameService {

    final PlayerRepository playerRepository;
    final GameRepository gameRepository;
    public GameService(PlayerRepository playerRepository, GameRepository gameRepository) {
        this.playerRepository = playerRepository;
        this.gameRepository = gameRepository;
    }

    public List<String> historyOfWinner = new ArrayList<>();

    public Game game = new Game();

    public String playGame(String playerName1, String playerName2){
        GameEntity gameEntity = new GameEntity();
        Integer maxId = gameRepository.findMaxGameEntityId();

        gameEntity.setId(maxId + 1);

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
                ret = player1.name + " wins this one";
            } else if(res==-1)
            {
                historyOfWinner.add(player2.name);
                ret = player2.name + " wins this one";
            }
        } else {
            ret = "draw";
        }
        gameEntity.setDescription(ret);
        gameRepository.save(gameEntity);
        return ret;
    }

    public List<String> getHistoryOfWinner(){
        return historyOfWinner;
    }

    public List<Player> getPlayerList(){
        return game.getList();
    }

    public PlayerEntity getPlayerInfo(Integer id){
        PlayerEntity playerEntity = playerRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);
        return playerEntity;
    }

    public void setHand(String playerName, int hand){
        for (int i = 0; i < game.playerList.size() ; i++) {
            Player tempPlayer = game.playerList.get(i);
            if(tempPlayer.name.equals(playerName)){
                PlayerEntity playerEntity = playerRepository.findByName(playerName);
                playerEntity.setHand(hand);
                playerRepository.save(playerEntity);
                tempPlayer.play(hand);
            }
        }
    }

    public void addPlayer(String name){
        PlayerEntity playerEntity = new PlayerEntity();
        Player player = new Player();

        Integer maxId = playerRepository.findMaxPlayerEntityId();

        playerEntity.setId(maxId + 1);

        player.name = name;
        playerEntity.name = name;

        playerEntity.hand = 0;

        game.addPlayer(player);
        playerRepository.save(playerEntity);
    }

    public void removePlayer(String playerName){
        for (int i = 0; i < game.playerList.size() ; i++) {
            if(playerName.equals(game.playerList.get(i).name)){
                game.removePlayer(game.playerList.get(i));
            }
        }
    }

}
