package tasks;

import java.io.IOException;
import java.util.*;

class Result {

    /*
     * Complete the 'doesCircleExist' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY commands as parameter.
     */

    public static List<String> doesCircleExist(List<String> commands) {
        // Write your code here

        int numberOfRunsToDetectCycle = 4;
        Map<String, String> results = new TreeMap<>();

        for (String moveCommands : commands) {
            results.put(moveCommands, "NO");

            Coordinates startPosition = new Coordinates(0, 0);
            Direction startDirection = Direction.NOTH;
            for (int i = 1; i <= numberOfRunsToDetectCycle; i++) {
                for (char moveCommand : moveCommands.toCharArray()) {
                    if (moveCommand == (Move.R.getMoveCode())) {
                        startDirection = Direction.getNewDirection(startDirection, Move.R);
                    } else if (moveCommand == (Move.L.getMoveCode())) {
                        startDirection = Direction.getNewDirection(startDirection, Move.L);
                    } else { // if Move.G

                        if (startDirection == Direction.NOTH) {
                            startPosition.incrementY();
                        } else if (startDirection == Direction.EAST) {
                            startPosition.incrementX();
                        } else if (startDirection == Direction.SOUTH) {
                            startPosition.decrementY();
                        } else {
                            startPosition.decrementX();
                        }
                    }
                }

                boolean isCyclicLoopDetected = (startPosition.getX() == 0 && startPosition.getY() == 0);

                if (isCyclicLoopDetected) {
                    results.put(moveCommands, "YES");
                    break;
                }
            }
        }

        return new ArrayList(results.values());
    }

    enum Direction {
        NOTH(0),
        EAST(1),
        WEST(2),
        SOUTH(3);

        int code;

        Direction(int code) {
            this.code = code;
        }

        static Direction getDirectionByCode(int code) {
            return Arrays.stream(Direction.values()).filter(direction -> direction.code == code).findFirst().get();
        }

        static Direction getNewDirection(Direction oldDirection, Move move) {
            Direction newDirection = oldDirection;

            if (move == Move.R) {
                int newDirectionCode = (oldDirection.code + 1) % 4;
                newDirection = Direction.getDirectionByCode(newDirectionCode);
            } else if (move == Move.L) {
                int newDirectionCode = (4 + oldDirection.code - 1) % 4;
                newDirection = Direction.getDirectionByCode(newDirectionCode);
            }

            return  newDirection;
        }
    }

    enum Move {
        R('R'),
        L('L'),
        G('G');

        private char moveCode;

        Move(char moveCode) {
            this.moveCode = moveCode;
        }

        public char getMoveCode() {
            return moveCode;
        }
    }

    static class Coordinates {
        private int x;
        private int y;

        public Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public void incrementY() {
            this.y++;
        }

        public void incrementX() {
            this.x++;
        }

        public void decrementY() {
            this.y--;
        }

        public void decrementX() {
            this.x--;
        }
    }

}

public class RobotMovementsCycleDetection {
    public static void main(String[] args) throws IOException {
        List<String> result = Result.doesCircleExist(Arrays.asList(new String[]{"GGGGR", "RGL"}));

        result.forEach(System.out::println);
    }
}