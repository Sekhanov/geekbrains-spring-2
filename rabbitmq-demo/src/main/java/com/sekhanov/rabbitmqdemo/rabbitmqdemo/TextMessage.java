package com.sekhanov.rabbitmqdemo.rabbitmqdemo;

public class TextMessage {

    private String text;

    public TextMessage() {
    }

    public TextMessage(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
