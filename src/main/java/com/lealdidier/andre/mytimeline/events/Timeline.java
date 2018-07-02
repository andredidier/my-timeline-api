package com.lealdidier.andre.mytimeline.events;

import java.util.function.Consumer;

public interface Timeline {
    void list(Consumer<TimelineEvent> ev, Runnable r);
}
