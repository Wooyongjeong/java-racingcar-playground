package racingcar.domain;

public class Car {
    private final Name name;
    private final Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public void move(int number) {
        position.move(number);
    }

    public Position getMaxPosition(Position maxPosition) {
        if (position.lessThan(maxPosition)) {
            return maxPosition;
        }
        return this.position;
    }

    public boolean isWinner(Position winnerPosition) {
        return position.equals(winnerPosition);
    }
}
