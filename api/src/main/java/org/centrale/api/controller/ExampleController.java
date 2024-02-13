package org.centrale.api.controller;

import jakarta.websocket.server.PathParam;
import org.centrale.api.GameRepository;
import org.centrale.api.PlayerEntity;
import org.centrale.api.service.GameService;
import org.centrale.domain.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.println;

@RestController
public class ExampleController {
    final GameService gameService;
    final GameRepository gameRepository;

    public ExampleController(GameService gameService, GameRepository gameRepository) {
        this.gameService = gameService;
        this.gameRepository = gameRepository;;
    }

    @GetMapping("/")
    public String hello() {return("Hello !");}
    @GetMapping("/play")
    public String play(@RequestParam Integer player1Id, @RequestParam Integer player2Id, @RequestParam Integer handPlayer1, @RequestParam Integer handPlayer2){
        gameService.setHand(player1Id, handPlayer1);
        gameService.setHand(player2Id, handPlayer2);
        return gameService.playGame(player1Id, player2Id, handPlayer1, handPlayer2);
    }

    @PostMapping("/player")
    public void addString(@RequestParam String name){
        gameService.addPlayer(name);
    }

    @GetMapping("/player/{id}")
    public PlayerEntity getPlayer(@PathVariable("id")Integer id){
        return gameService.getPlayerInfo(id);
    }

    @PostMapping("/remove")
    public void removeString(@RequestParam String name){
        gameService.removePlayer(name);
    }

    @GetMapping("/list")
    public List<Player> seelist(){return gameService.getPlayerList();}

    @GetMapping("/history")
    public List<String> seeHistory(){ return gameService.getHistoryOfWinner();}

    @GetMapping("/game-stats")
    public String getStats(@RequestParam Integer playerId1){
        return gameService.getStats(playerId1);
    }

    //@PostMapping("/set")
    //public void setHand(@RequestParam String name,
      //                  @RequestParam int hand ){
        //gameService.setHand(name, hand);

    //}

    //@PostMapping("pouet")
    //public void pouet(@RequestParam Integer id, @RequestParam String name){ playerDBService.addPlayer(id, name);}

}
