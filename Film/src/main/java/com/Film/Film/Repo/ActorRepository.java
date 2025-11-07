package com.Film.Film.Repo;

import com.Film.Film.Entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Integer> {
}
