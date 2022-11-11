package com.everest.dating.controllers;

import com.everest.dating.services.general.MatchServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/match")
public class MatchController {

    private final MatchServiceImpl matchService;

    public MatchController(MatchServiceImpl matchService) {
        this.matchService = matchService;
    }

    @PostMapping("/possibilities/{id}")
    public ResponseEntity<?> getPossibleMatches(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(matchService.getPossibleMatch(id));
    }

    @PostMapping("/make/{id}/{matchId}")
    public ResponseEntity<?> makeMatch(@PathVariable Long id, @PathVariable Long matchId) {
        return ResponseEntity.status(HttpStatus.OK).body(matchService.makeMatch(id, matchId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMatches(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(matchService.getMatches(id));
    }

    @PostMapping("/percentage/{id}/{matchId}")
    public ResponseEntity<?> getPercentageMatch(@PathVariable Long id, @PathVariable Long matchId) {
        return ResponseEntity.status(HttpStatus.OK).body(matchService.getPercentageMatch(id, matchId));
    }
}
