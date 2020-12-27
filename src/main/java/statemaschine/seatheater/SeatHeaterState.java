package statemaschine.seatheater;

public enum SeatHeaterState {
    STATE_OFF {
        SeatHeaterState next() {
            return SeatHeaterState.STATE_FOUR;
        }
    }, STATE_FOUR {
        SeatHeaterState next() {
            return SeatHeaterState.STATE_THREE;
        }
    }, STATE_THREE {
        SeatHeaterState next() {
            return SeatHeaterState.STATE_TWO;
        }
    }, STATE_TWO {
        SeatHeaterState next() {
            return SeatHeaterState.STATE_ONE;
        }
    }, STATE_ONE {
        SeatHeaterState next() {
            return SeatHeaterState.STATE_OFF;
        }
    };

    abstract SeatHeaterState next();

}
