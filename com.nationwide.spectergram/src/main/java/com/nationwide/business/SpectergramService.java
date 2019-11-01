package com.nationwide.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.nationwide.persistence.domain.spgposts;
import com.nationwide.persistence.repository.SpectergramRepository;

@Service
@CrossOrigin("*")
public class SpectergramService {

	@Autowired
	private SpectergramRepository repository;

	

	public List<spgposts> getAllspgposts() {
		return repository.findAll();
	}
	
	public spgposts getSpgPostsByID(Long id) throws Exception {
		return repository.findById(id).orElseThrow(() -> new Exception("Not found"));
	}

	public spgposts savePost(spgposts savePost) {
		return repository.save(savePost);
	}

	public String updatePost(spgposts updatePost) {
		spgposts returnedFromDatabase = repository.getOne(updatePost.getId());
		returnedFromDatabase.setName(updatePost.getName());
		returnedFromDatabase.setPlace(updatePost.getPlace());
		returnedFromDatabase.setCity(updatePost.getCity());
		returnedFromDatabase.setDate(updatePost.getDate());
		returnedFromDatabase.setDescription(updatePost.getDescription());
		returnedFromDatabase.setHeading(updatePost.getHeading());
		repository.flush();
		return "updated";
	}

	public String deletePost(Long id) {
		repository.deleteById(id);
		return "Deleted!";
	}
}
