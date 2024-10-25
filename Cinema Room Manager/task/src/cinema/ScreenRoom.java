package cinema;

public class ScreenRoom {

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Screen:\n");

        builder.append("  1 2 3 4 5 6 7 8\n");
        for (int i = 1; i < 8; i++) {
            builder.append("%d S S S S S S S S%n".formatted(i));
        }

        return builder.toString();
    }
}
