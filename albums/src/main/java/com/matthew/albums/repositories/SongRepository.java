package com.matthew.albums.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.matthew.albums.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Long>{

}
