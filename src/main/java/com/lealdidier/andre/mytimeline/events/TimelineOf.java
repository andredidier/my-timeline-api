package com.lealdidier.andre.mytimeline.events;

import java.util.function.Consumer;

public class TimelineOf implements Timeline {

    private Timeline inner;

    public TimelineOf(Timeline inner) {
        this.inner = inner;
    }

    @Override
    public void list(Consumer<TimelineEvent> ev, Runnable r) {
        inner.list(ev, r);
    }
}
