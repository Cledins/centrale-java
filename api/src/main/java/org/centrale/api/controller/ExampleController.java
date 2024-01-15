package org.centrale.api.controller;

import org.centrale.api.service.CacheService;
import org.centrale.api.service.GameService;
import org.centrale.api.service.PlayerDBService;
import org.centrale.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExampleController {
    final GameService gameService;
    final PlayerDBService playerDBService;

    public ExampleController(GameService gameService, PlayerDBService playerDBService) {
        this.gameService = gameService;
        this.playerDBService = playerDBService;;
    }

    @GetMapping("/")
    public String hello() {return("Hello !");}
    @GetMapping("play")
    public String play(@RequestParam String playerName1, @RequestParam String playerName2){
        return gameService.playGame(playerName1, playerName2);
    }

    @PostMapping("/add")
    public void addString(@RequestParam String name){
        gameService.addPlayer(name);
    }

    @PostMapping("/remove")
    public void removeString(@RequestParam String name){
        gameService.removePlayer(name);
    }

    @GetMapping("/list")
    public List<Player> seelist(){return gameService.getPlayerList();}

    @GetMapping("/history")
    public List<String> seeHistory(){ return gameService.getHistoryOfWinner();}

    @PostMapping("/set")
    public void setHand(@RequestParam String name,
                        @RequestParam int hand ){
        gameService.setHand(name, hand);
    }

    @PostMapping("pouet")
    public void pouet(@RequestParam Integer id, @RequestParam String name){ playerDBService.addPlayer(id, name);}

}
