package com.nationwide.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nationwide.persistence.domain.spgposts;
import com.nationwide.persistence.repository.SpectergramRepository;

@Service
public class SpectergramService {

	@Autowired
	private SpectergramRepository repository;

	public SpectergramService() {

	}

	public List<spgposts> getAllspgposts() {
		return repository.findAll();
	}

	public spgposts savePost(spgposts savePost) {
		return repository.save(savePost);
	}

	public spgposts updatePost(spgposts updatePost) {
		return repository.save(updatePost);
	}

	public String deletePost(Long id) {
		repository.deleteById(id);
		return "Deleted!";
	}
}
