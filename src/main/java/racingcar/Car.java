package racingcar;

public class Car {
    private static final String SEPARATOR = " : ";
    private final Name name;
    private final MoveCount moveCount;

    private Car(String name) {
        this.name = Name.from(name);
        this.moveCount = new MoveCount();
    }

    public static Car from(String name) {
        return new Car(name);
    }

    public void moveForward(int num) {
        moveCount.report(num);
    }

    public int getMoveCount() {
        return this.moveCount.getMoveCount();
    }

    public String getResult() {
        String name = this.name.getName();
        String result = this.moveCount.getResult();
        return name + SEPARATOR + result;
    }
}
