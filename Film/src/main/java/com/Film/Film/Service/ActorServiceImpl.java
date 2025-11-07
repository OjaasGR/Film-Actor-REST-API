package com.Film.Film.Service;

import com.Film.Film.Entity.Actor;
import com.Film.Film.ExceptionHandler.ActorNotFoundException;
import com.Film.Film.ExceptionHandler.MovieNotFoundException;
import com.Film.Film.Repo.ActorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
public class ActorServiceImpl implements ActorService {
    @Autowired
    private ActorRepository actorRepository;


    @Override
    public List<Actor> getActors() {
        return actorRepository.findAll();
    }

    @Override
    public Actor getActor(int id) {
        return actorRepository.findById(id)
                .orElseThrow(() -> new ActorNotFoundException("Actor not found with id " + id));
    }

    @Override
    public Actor addActor(Actor actor) {
        return actorRepository.save(actor);
    }

    @Override
    public Actor updateActor(int id,Actor actor) {
        Actor actor1 = actorRepository.getReferenceById(id);
        actor1.setName(actor.getName());
        actor1.setAge(actor.getAge());
        actor1.setRemuneration(actor.getRemuneration());
        return actorRepository.save(actor1);

    }

    @Override
    public void deleteActor(int id) {
        Actor actor1 = actorRepository.getReferenceById(id);
        actorRepository.delete(actor1);

    }

    @Override
    public Actor saveActor(Actor actor) {
        return actorRepository.save(actor);
    }
}
