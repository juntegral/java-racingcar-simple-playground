public class Car {
    private static final int MaxPosition= 4;
    private final String name;
    private int position;

    public Car(final String name) {
        validateNameLength(name);
        this.name = name;
        this.position = 0;
    }

    private void validateNameLength(final String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    // 새롭게 추가된 이동 로직
    public void move(final int randomNumber) {
        if (randomNumber >= MaxPosition) {
            this.position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}