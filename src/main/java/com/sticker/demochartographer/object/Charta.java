package com.sticker.demochartographer.object;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Charta implements Serializable {

    private static long count = 1;

    private long id;
    private int width;
    private int height;
    @Builder.Default
    private List<Fragment> fragments = new ArrayList<>();

    public static synchronized long initAndGetId() {
        return count++;
    }
}
