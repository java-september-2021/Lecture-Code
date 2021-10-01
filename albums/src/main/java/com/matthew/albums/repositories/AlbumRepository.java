package com.matthew.albums.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.matthew.albums.models.Album;

@Repository
public interface AlbumRepository extends CrudRepository<Album, Long>{
	List<Album> findAll(); // SELECT * FROM albums
	List<Album> findByAlbumNameContaining(String containing);
	boolean existsByAlbumName(String albumName);
}
