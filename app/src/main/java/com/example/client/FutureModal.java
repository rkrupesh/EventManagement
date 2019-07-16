package com.example.client;

public class FutureModal {


    private int ed_stime;
    private int ed_etime;
    private int subtitleId;
    private int fdate;

    public int getEd_stime() {
        return ed_stime;
    }

    public int getEd_etime() {
        return ed_etime;
    }

    public int getSubtitleId() {
        return subtitleId;
    }

    public int getFdate() {
        return fdate;
    }

    public FutureModal(int ed_stime, int ed_etime, int subtitleId, int fdate) {
        this.ed_stime = ed_stime;
        this.ed_etime = ed_etime;
        this.subtitleId = subtitleId;
        this.fdate = fdate;
    }
}