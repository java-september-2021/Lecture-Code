package com.matthew.thoughts.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matthew.thoughts.models.Thought;
import com.matthew.thoughts.models.User;
import com.matthew.thoughts.repositories.ThoughtRepository;

@Service
public class ThoughtService {
	@Autowired
	private ThoughtRepository tRepo;
	
	public Thought create(Thought thought) {
		return this.tRepo.save(thought);
	}
	
	public List<Thought> allThoughts(){
		return this.tRepo.findAll();
	}
	
	public List<Thought> getAllThoughtsSorted(){
		return this.tRepo.findByOrderByNumOfLikesDesc();
	}
	
	public Thought grabOneThought(Long id) {
		return this.tRepo.findById(id).orElse(null);
	}
	
	public void likeThought(User user, Thought thought) {
		List<User> usersWhoLikes = thought.getLikers();
		usersWhoLikes.add(user);
		thought.setNumOfLikes(thought.getNumOfLikes()+1);
		this.tRepo.save(thought);
	}
	
	public void unlikeThought(User user, Thought thought) {
		List<User> usersWhoLikes = thought.getLikers();
		usersWhoLikes.remove(user);
		thought.setNumOfLikes(thought.getNumOfLikes()-1);
		this.tRepo.save(thought);
	}
}
