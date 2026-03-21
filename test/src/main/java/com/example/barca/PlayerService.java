package com.example.barca;

import com.example.barca.Player;
import com.example.barca.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

   
    public List<Player> getAllPlayersSorted() {
        return playerRepository.findAllByOrderByBackNumberAsc();
    }
}
