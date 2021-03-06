package com.sticker.demochartographer.services;

import com.sticker.demochartographer.exception.ChartaNotFoundException;
import com.sticker.demochartographer.exception.FragmentOutOfBoundException;
import com.sticker.demochartographer.repos.ChartaRepo;
import org.springframework.stereotype.Service;

import java.io.File;

// TODO: 20.03.2022  
@Service
public class FragmentService {

    public void createFragment(File file, Long chartaId, Integer x, Integer y, Integer width, Integer height) throws FragmentOutOfBoundException, ChartaNotFoundException {

        if (x + width > ChartaRepo.findById(chartaId).getWidth() ||
                y + height > ChartaRepo.findById(chartaId).getHeight()) {
            throw new FragmentOutOfBoundException("фрагмент вне границ холста");
        }
    }
}
