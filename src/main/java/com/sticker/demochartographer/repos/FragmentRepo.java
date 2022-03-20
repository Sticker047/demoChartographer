package com.sticker.demochartographer.repos;

import com.sticker.demochartographer.object.Fragment;

import java.util.HashMap;
import java.util.Map;

public class FragmentRepo {
    private static Map<Long, Fragment> storage = new HashMap<>();

    public static void save(Fragment tile) {
        storage.put((long)storage.size(), tile);
    }
}
