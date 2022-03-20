package com.sticker.demochartographer.services;

import com.sticker.demochartographer.exception.ChartaNotFoundException;
import com.sticker.demochartographer.object.Charta;
import com.sticker.demochartographer.repos.ChartaRepo;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ChartaService {

    public Long delete(Long id) throws ChartaNotFoundException, IOException {
        ChartaRepo.deleteById(id);
        Deleter.deleteCharta(id);
        return id;
    }

    public long createCharta(int width, int height) throws IOException {

        if (width > 20000 || width <= 0 || height > 50000 || height <= 0) {
            throw new IllegalArgumentException();
        }


        Charta charta = Charta.builder()
                .id(Charta.initAndGetId())
                .width(width)
                .height(height)
                .build();

        Saver.saveCharta(charta);
        return ChartaRepo.save(charta);
    }
}
