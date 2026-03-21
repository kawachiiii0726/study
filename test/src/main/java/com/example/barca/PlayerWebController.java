package com.example.barca;

import com.example.barca.Player;
import com.example.barca.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PlayerWebController {

    @Autowired
    private PlayerService playerService;

    @GetMapping("/players")
    public String showPlayerList(Model model) {
        // Serviceからデータを取得
        List<Player> players = playerService.getAllPlayersSorted();
        
        // "players" という名前でHTML（Thymeleaf）にデータを渡す
        model.addAttribute("players", players);
        
        // templates/players.html を呼び出す
        return "players";
    }
}