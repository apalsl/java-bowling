package bowling.domain;

import bowling.domain.frames.Frame;
import bowling.domain.mock.TestFrame;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.assertThat;

public class ScoreCalculateTest {
    @Test
    @DisplayName("Strike 한 경우 다음 2번의 투구의 점수를 합한다. (2번의 투구가 스트라이크인 경우)")
    public void strikeScoreTest() {
        TestFrame frame1 = TestFrame.getFirstFrame();
        Frame frame2 = frame1.initNextFrame();
        Frame frame3 = frame2.initNextFrame();

        frame1.setKnockDownPins(KnockDownPins.valueOf(10));
        frame2.setKnockDownPins(KnockDownPins.valueOf(10));
        frame3.setKnockDownPins(KnockDownPins.valueOf(10));

        assertThat(frame1.getCalculatedScore()).isEqualTo(30);
    }

    @Test
    @DisplayName("Strike 한 경우 다음 2번의 투구의 점수를 합한다.")
    public void strikeScoreWithScoreTest() {
        TestFrame frame1 = TestFrame.getFirstFrame();
        Frame frame2 = frame1.initNextFrame();
        Frame frame3 = frame2.initNextFrame();

        frame1.setKnockDownPins(KnockDownPins.valueOf(10));
        frame2.setKnockDownPins(KnockDownPins.valueOf(3));
        frame2.setKnockDownPins(KnockDownPins.valueOf(3));

        assertThat(frame1.getCalculatedScore()).isEqualTo(16);
    }

    @Test
    @DisplayName("Strike 한 경우 다음 2번의 투구의 점수를 합한다. (2번째 투구가 스페어인 경우)")
    public void strikeScoreWithSpareTest() {
        TestFrame frame1 = TestFrame.getFirstFrame();
        Frame frame2 = frame1.initNextFrame();
        Frame frame3 = frame2.initNextFrame();

        frame1.setKnockDownPins(KnockDownPins.valueOf(10));
        frame2.setKnockDownPins(KnockDownPins.valueOf(5));
        frame2.setKnockDownPins(KnockDownPins.valueOf(5));

        assertThat(frame1.getCalculatedScore()).isEqualTo(20);
    }

    @Test
    @DisplayName("Strike 한 경우 다음 2번의 투구가 존재하지 않으면 null")
    public void strikeScoreNullTest() {
        TestFrame frame1 = TestFrame.getFirstFrame();
        Frame frame2 = frame1.initNextFrame();
        Frame frame3 = frame2.initNextFrame();

        frame1.setKnockDownPins(KnockDownPins.valueOf(10));
        frame2.setKnockDownPins(KnockDownPins.valueOf(10));

        assertThat(frame1.getCalculatedScore()).isEqualTo(null);
    }

    @Test
    @DisplayName("Spare 한 경우 다음번의 투구의 점수를 합한다.")
    public void spareScoreTest() {
        TestFrame frame1 = TestFrame.getFirstFrame();
        Frame frame2 = frame1.initNextFrame();

        frame1.setKnockDownPins(KnockDownPins.valueOf(5));
        frame1.setKnockDownPins(KnockDownPins.valueOf(5));
        frame2.setKnockDownPins(KnockDownPins.valueOf(10));

        assertThat(frame1.getCalculatedScore()).isEqualTo(20);
    }

    @Test
    @DisplayName("Spare 한 경우 다음번의 투구가 존재하지 않으면 null")
    public void spareScoreNullTest() {
        TestFrame frame1 = TestFrame.getFirstFrame();
        Frame frame2 = frame1.initNextFrame();

        frame1.setKnockDownPins(KnockDownPins.valueOf(5));
        frame1.setKnockDownPins(KnockDownPins.valueOf(5));

        assertThat(frame1.getCalculatedScore()).isEqualTo(null);
    }

    @Test
    @DisplayName("Strike, Spare가 아닌 경우 현재 frame의 점수만 합산")
    public void noneStrikeAndSpareTest() {
        TestFrame frame1 = TestFrame.getFirstFrame();

        frame1.setKnockDownPins(KnockDownPins.valueOf(3));
        frame1.setKnockDownPins(KnockDownPins.valueOf(3));

        assertThat(frame1.getCalculatedScore()).isEqualTo(6);
    }

    @Test
    @DisplayName("Strike 한 경우 다음 2번의 투구의 점수를 합한다. (2번의 투구가 스트라이크인 경우)")
    public void strikeScoreTest_lastFrame() {
        TestFrame frame9 = TestFrame.getFrame(9);
        Frame lastFrame = frame9.initNextFrame();

        frame9.setKnockDownPins(KnockDownPins.valueOf(10));
        lastFrame.setKnockDownPins(KnockDownPins.valueOf(10));
        lastFrame.setKnockDownPins(KnockDownPins.valueOf(10));

        assertThat(frame9.getCalculatedScore()).isEqualTo(30);
    }

    @Test
    @DisplayName("Strike 한 경우 다음 2번의 투구의 점수를 합한다.")
    public void strikeScoreWithScoreTest_lastFrame() {
        TestFrame frame9 = TestFrame.getFrame(9);
        Frame lastFrame = frame9.initNextFrame();

        frame9.setKnockDownPins(KnockDownPins.valueOf(10));
        lastFrame.setKnockDownPins(KnockDownPins.valueOf(3));
        lastFrame.setKnockDownPins(KnockDownPins.valueOf(3));

        assertThat(frame9.getCalculatedScore()).isEqualTo(16);
    }

    @Test
    @DisplayName("Strike 한 경우 다음 2번의 투구의 점수를 합한다. (2번째 투구가 스페어인 경우)")
    public void strikeScoreWithSpareTest_lastFrame() {
        TestFrame frame9 = TestFrame.getFrame(9);
        Frame lastFrame = frame9.initNextFrame();

        frame9.setKnockDownPins(KnockDownPins.valueOf(10));
        lastFrame.setKnockDownPins(KnockDownPins.valueOf(5));
        lastFrame.setKnockDownPins(KnockDownPins.valueOf(5));

        assertThat(frame9.getCalculatedScore()).isEqualTo(20);
    }

    @Test
    @DisplayName("Strike 한 경우 다음 2번의 투구가 존재하지 않으면 null")
    public void strikeScoreNullTest_lastFrame() {
        TestFrame frame9 = TestFrame.getFrame(9);
        Frame lastFrame = frame9.initNextFrame();

        frame9.setKnockDownPins(KnockDownPins.valueOf(10));
        lastFrame.setKnockDownPins(KnockDownPins.valueOf(5));

        assertThat(frame9.getCalculatedScore()).isEqualTo(null);
    }

    @Test
    @DisplayName("Spare 한 경우 다음번의 투구의 점수를 합한다.")
    public void spareScoreTest_lastFrame() {
        TestFrame frame9 = TestFrame.getFrame(9);
        Frame lastFrame = frame9.initNextFrame();

        frame9.setKnockDownPins(KnockDownPins.valueOf(5));
        frame9.setKnockDownPins(KnockDownPins.valueOf(5));
        lastFrame.setKnockDownPins(KnockDownPins.valueOf(10));

        assertThat(frame9.getCalculatedScore()).isEqualTo(20);
    }

    @Test
    @DisplayName("Spare 한 경우 다음번의 투구가 존재하지 않으면 null")
    public void spareScoreNullTest_lastFrame() {
        TestFrame frame9 = TestFrame.getFrame(9);
        Frame lastFrame = frame9.initNextFrame();

        frame9.setKnockDownPins(KnockDownPins.valueOf(5));
        frame9.setKnockDownPins(KnockDownPins.valueOf(5));

        assertThat(frame9.getCalculatedScore()).isEqualTo(null);
    }
}
