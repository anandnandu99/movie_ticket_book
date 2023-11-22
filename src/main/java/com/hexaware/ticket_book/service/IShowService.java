package com.hexaware.ticket_book.service;

import java.util.List;

import com.hexaware.ticket_book.dto.ShowDTO;


public interface IShowService {
    ShowDTO addShow(ShowDTO showDTO);

	List<ShowDTO> getAllShows();
}
