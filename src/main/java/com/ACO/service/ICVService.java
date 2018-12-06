package com.ACO.service;

import java.util.Optional;

import com.ACO.domain.CV;

public interface ICVService {

	public CV addCV(CV cv);

	public Iterable<CV> getAllCVs();

//	public Optional<CV> getCV(int id);

	public CV updateCV(int id, CV cv);

	public String deleteCV(int id);

}
