package com.Film.Film.Service;

import com.Film.Film.Entity.Actor;

import java.util.List;

public interface ActorService {
    List<Actor> getActors();
    Actor getActor(int id);
    Actor addActor(Actor actor);
    Actor updateActor(int id,Actor actor);
    void deleteActor(int id);
    Actor saveActor(Actor actor);
}
