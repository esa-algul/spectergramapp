package com.nationwide.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/spectergramapp")
public class SpectergramController {

	@Autowired
	private SpectergramService spgService;

	@GetMapping("/spgposts")
	public List<spgposts> getAllspgposts() {
		return spgService.getAllspgposts();
	}

	@PostMapping("/spgposts")
	public spgposts savePost(@RequestBody spgposts PostToSave) {
		return spgService.savePost(PostToSave);
	}

	@PutMapping("/spgposts")
	public spgposts updatePost(@RequestBody spgposts PostToUpdate) {
		return spgService.updatePost(PostToUpdate);
	}

	@DeleteMapping("/spgposts/{id}")
	public String deltePost(@PathVariable(value = "id") long id) {
		spgService.deletePost(id);
		return "Deleted!";
	}
}