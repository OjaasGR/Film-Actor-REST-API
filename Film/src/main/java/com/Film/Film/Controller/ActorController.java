package com.Film.Film.Controller;

import com.Film.Film.Entity.Actor;
import com.Film.Film.Repo.ActorRepository;
import com.Film.Film.Service.ActorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController

public class ActorController {
    @Autowired
    private ActorService actorService;

    private ObjectMapper objectMapper;

    public ActorController(ActorService actorService, ObjectMapper objectMapper) {
        this.actorService = actorService;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/actors")
    public List<Actor> getAllActors(){
        return actorService.getActors();
    }
    @GetMapping("/actors/{id}")
    public Actor getActorById(@PathVariable int id){
        return actorService.getActor(id);
    }
    @PostMapping("/actors")
    public Actor addActor(@RequestBody Actor actor){
        return actorService.addActor(actor);
    }
    @DeleteMapping("/actors/{id}")
    public void deleteActor(@PathVariable int id){
        actorService.deleteActor(id);
    }
    @PatchMapping("/actors/{id}")
    public Actor updateActor(@PathVariable int id, @RequestBody Map<String,Object> patchPayload){
        Actor actor = actorService.getActor(id);
        Actor patchedActor = apply(patchPayload,actor);
        Actor a = actorService.saveActor(patchedActor);
        return a;
    }

    private Actor apply(Map<String, Object> patchPayload, Actor actor) {
        ObjectNode patchedActor = objectMapper.convertValue(patchPayload, ObjectNode.class);
        ObjectNode actorNode = objectMapper.convertValue(actor, ObjectNode.class);
        actorNode.setAll(patchedActor);
        return objectMapper.convertValue(actorNode, Actor.class);
    }
}
