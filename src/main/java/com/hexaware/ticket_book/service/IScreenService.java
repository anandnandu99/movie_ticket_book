package com.hexaware.ticket_book.service;

import com.hexaware.ticket_book.dto.ScreenDTO;

import java.util.List;

public interface IScreenService {
    ScreenDTO addScreen(ScreenDTO screenDTO, int theatreId);
    void removeScreen(int screenId);
    List<ScreenDTO> getAllScreens();
    List<ScreenDTO> getScreensByTheatre(int theatreId);
}
