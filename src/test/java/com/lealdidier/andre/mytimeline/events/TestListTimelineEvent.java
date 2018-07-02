package com.lealdidier.andre.mytimeline.events;

import net.bytebuddy.implementation.bytecode.Addition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;
import org.mockito.AdditionalAnswers;
import org.mockito.ArgumentCaptor;

import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.AdditionalAnswers.answerVoid;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@DisplayName("Test list of timeline events")
public class TestListTimelineEvent {

    @Test
    @DisplayName("No events in TimelineOf")
    public void listNoEventsInTimelineOf() {
        Timeline mocked = mock(Timeline.class);
        Timeline timeline = new TimelineOf(mocked);
        Consumer<TimelineEvent> eventConsumer = mock(Consumer.class);
        Runnable emptyList = mock(Runnable.class);
        doAnswer(answerVoid((Consumer<TimelineEvent> a, Runnable b) -> b.run())).when(mocked).list(any(), any());

        timeline.list(eventConsumer, emptyList);

        verifyZeroInteractions(eventConsumer);
        verify(emptyList).run();
        verify(mocked).list(any(), any());
    }

    @Test
    @DisplayName("One event in TimelineOf")
    public void listOneEventInTimelinefOf() {
        Timeline mocked = mock(Timeline.class);
        Timeline timeline = new TimelineOf(mocked);
        Consumer<TimelineEvent> eventConsumer = mock(Consumer.class);
        Runnable emptyList = mock(Runnable.class);
        doAnswer(answerVoid((Consumer<TimelineEvent> a, Runnable b) -> a.accept(mock(TimelineEvent.class)))).when(mocked).list(any(), any());

        timeline.list(eventConsumer, emptyList);

        verify(eventConsumer).accept(any());
        verifyZeroInteractions(emptyList);
        verify(mocked).list(any(), any());
    }
}
