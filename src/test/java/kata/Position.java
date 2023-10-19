package kata;

public class Position {

    private final int row;
    private final int column;

    private Position(int row, int column) {

        this.row = row;
        this.column = column;
    }

    public static PositionWithRow inRow(int row) {
        return new PositionWithRow(row);
    }

    public static PositionWithColumn inColumn(int column) {
        return new PositionWithColumn(column);
    }

    public int toIndex() {
        return column * 4 + row;
    }

    public static class PositionWithRow {

        private final int row;

        public PositionWithRow(int row) {
            this.row = row;
        }

        public Position inColumn(int column) {
            return new Position(this.row, column);
        }
    }

    public static class PositionWithColumn {

        private final int column;

        public PositionWithColumn(int column) {
            this.column = column;
        }

        public Position inRow(int row) {
            return new Position(row, this.column);
        }
    }
}
