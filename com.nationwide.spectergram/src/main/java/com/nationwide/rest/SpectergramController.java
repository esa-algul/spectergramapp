package com.nationwide.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nationwide.business.SpectergramService;
import com.nationwide.persistence.domain.spgposts;


@RestController
@CrossOrigin("*")
@RequestMapping("/spectergramapp/spgposts")
public class SpectergramController {

	@Autowired
	private SpectergramService spgService;
	
	@GetMapping
	public List<spgposts> getAllspgposts() {
		return spgService.getAllspgposts();
	}

	@GetMapping("/{id}")
	public spgposts getSpgPostsByID(@PathVariable Long id) throws Exception {
		return spgService.getSpgPostsByID(id);
	}

	@PostMapping
	public spgposts savePost(@RequestBody spgposts PostToSave) {
		return spgService.savePost(PostToSave);
	}
	
	@PutMapping
	public String updatePost(@RequestBody spgposts PostToUpdate) {
		return spgService.updatePost(PostToUpdate);
	}

	@DeleteMapping("/{id}")
	public String deletePost(@PathVariable(value = "id") long id) {
		spgService.deletePost(id);
		return "Deleted!";
	}
}