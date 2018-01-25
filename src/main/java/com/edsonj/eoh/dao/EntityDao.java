package com.edsonj.eoh.dao;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.edsonj.eoh.entity.Party;

public interface EntityDao extends PagingAndSortingRepository<Party, Long> {

}
