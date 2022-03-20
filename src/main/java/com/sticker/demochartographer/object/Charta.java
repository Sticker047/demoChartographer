package com.sticker.demochartographer.object;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Charta {

    private long id;
    private int width;
    private int height;
    private List<Fragment> fragments;
}
