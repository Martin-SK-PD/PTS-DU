package Main;

import java.util.Optional;

public class Position {

    // troma konstruktormi, a troma gettermi
    private Optional<HandPosition> handPosition;
    private Optional<SleepingQueenPosition> sleepingQueenPosition;
    private Optional<AwokenQueenPosition> awokenQueenPosition;



    public Position(HandPosition handPosition){
        this.handPosition = Optional.of(handPosition);
    }

    public Position(SleepingQueenPosition sleepingQueenPosition){
        this.sleepingQueenPosition = Optional.of(sleepingQueenPosition);
    }

    public Position(AwokenQueenPosition awokenQueenPosition){
        this.awokenQueenPosition = Optional.of(awokenQueenPosition);
    }


    public Optional<HandPosition> getHandPosition() {
        return handPosition;
    }

    public Optional<SleepingQueenPosition> getSleepingQueenPosition() {
        return sleepingQueenPosition;
    }


    public Optional<AwokenQueenPosition> getAwokenQueenPosition() {
        return awokenQueenPosition;
    }
}
