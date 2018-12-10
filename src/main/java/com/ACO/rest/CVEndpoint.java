package com.ACO.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ACO.Constants.Constants;
import com.ACO.domain.CV;
import com.ACO.service.CVService;

@Controller
@RequestMapping(path = "/cv")
public class CVEndpoint {

	@Autowired
	private CVService cvService;

	//Get All CVs
	@GetMapping(path = "/getAll")
	public @ResponseBody Iterable<CV> getAllCVs() {
		return cvService.getAllCVs();
	}

	//Get a CV
	@GetMapping(path = "/getCV/{id}")
	public Optional<CV> getCV(@PathVariable int id) {
		return cvService.getCV(id);
	}

	//Delete a CV
	@DeleteMapping(path = "/deleteCV/{id}")
	public String deleteCV(@PathVariable int id) {
		cvService.deleteCV(id);
		return Constants.CV_DELETED;
	}

	//Update a CV
	@PutMapping(path = "/updateCV/{id}")
	public String updateCV(@PathVariable int id, @RequestBody CV cv) {
		cvService.updateCV(id, cv);
		return Constants.CV_UPDATED;
	}

	//Get all Flagged CVs
	@GetMapping(path = "/getAllFlagged")
	public @ResponseBody Iterable<CV> getAllFlagged() {
		return cvService.getAllFlagged();
	}

	//Get all Medium Flagged CVs
	@GetMapping(path = "/getAllMediumFlagged")
	public @ResponseBody Iterable<CV> getAllMediumFlagged() {
		return cvService.getMediumFlagged();
	}

	//Get all Bad Flagged CVs
	@GetMapping(path = "/getAllBadFlagged")
	public @ResponseBody Iterable<CV> getAllBadFlagged() {
		return cvService.getBadFlagged();
	}

	//Flag/Unflag a CV
	@PutMapping(path = "/updateFlag/{id}/{flag}")
	public String updateFlag(@PathVariable int id, @PathVariable int flag) {
		cvService.updateFlag(id, flag);
		return Constants.CV_FLAGGED;
	}
}