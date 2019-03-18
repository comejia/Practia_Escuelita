package example.pages.content;

public enum FlightOptions {
    ONE {
        public Integer toInt() {
            return 1;
        }
    },

    TWO {
        public Integer toInt() {
            return 2;
        }
    },

    THREE {
        public Integer toInt() {
            return 3;
        }
    },

    FOUR {
        public Integer toInt() {
            return 4;
        }
    },

    FIVE {
        public Integer toInt() {
            return 5;
        }
    }
}
