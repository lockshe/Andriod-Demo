package com.bytedance.i18n.daydayup.day2;

public class Params {

    private int imgSrc;
    private int titleText;
    private int scoreText;

    public Params(int imgSrc, int titleText, int scoreText){
        this.imgSrc = imgSrc;
        this.titleText = titleText;
        this.scoreText = scoreText;
    }

    public int getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(int imgSrc) {
        this.imgSrc = imgSrc;
    }

    public int getTitleText() {
        return titleText;
    }

    public void setTitleText(int titleText) {
        this.titleText = titleText;
    }

    public int getScoreText() {
        return scoreText;
    }

    public void setScoreText(int scoreText) {
        this.scoreText = scoreText;
    }
}
