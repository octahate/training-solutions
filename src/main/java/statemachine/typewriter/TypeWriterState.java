package statemachine.typewriter;

public enum TypeWriterState {
    UPPERCASE {
        public TypeWriterState next() {
            return TypeWriterState.LOWERCASE;
        }
    }, LOWERCASE {
        public TypeWriterState next() {
            return TypeWriterState.UPPERCASE;
        }
    };

    abstract TypeWriterState next();


}
