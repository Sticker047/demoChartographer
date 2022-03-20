package com.sticker.demochartographer.object;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class Charta implements Serializable {

    private long id;
    private int width;
    private int height;
    private List<Fragment> fragments;
}
