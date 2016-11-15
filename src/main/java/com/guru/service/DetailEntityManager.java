package com.guru.service;

import java.util.List;

import com.guru.entities.DetailEntity;

public interface DetailEntityManager {
	List<DetailEntity> getAllDetail();
	void saveDetail(DetailEntity detailEntity);
	void deleteDetail(DetailEntity detailEntity);
}
