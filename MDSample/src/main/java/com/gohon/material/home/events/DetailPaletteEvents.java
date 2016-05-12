package com.gohon.material.home.events;



/**
 * Created by liuyonglong on 16/5/12.
 */
public class DetailPaletteEvents {
    private int colors;
    public DetailPaletteEvents(int colors) {
        this.colors = colors;
    }

    public int getStatusBarScrim() {

        return colors;
    }


}
