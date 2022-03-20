package com.sticker.demochartographer.services;

import com.sticker.demochartographer.exception.ChartaNotFoundException;
import com.sticker.demochartographer.object.Charta;
import com.sticker.demochartographer.repos.ChartaRepo;
import org.springframework.stereotype.Service;

@Service
public class ChartaService {

    public Charta getCharta(Long id) throws ChartaNotFoundException {
        Charta charta = ChartaRepo.findById(id);
        if (charta == null) {
            throw new ChartaNotFoundException("Холст не найден");
        }
        return charta;
    }

    public Long delete(Long id) {
        ChartaRepo.deleteById(id);
        return id;
    }

    public long createCharta(int width, int height) {

        if (width > 20000 || width <= 0 || height > 50000 || height <= 0)
            throw new IllegalArgumentException();

        Charta charta = new Charta();
        charta.setWidth(width);
        charta.setHeight(height);
        return ChartaRepo.save(charta);
    }
}
