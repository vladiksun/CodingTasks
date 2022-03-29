package tasks;

//  https://javaconceptoftheday.com/how-to-create-pyramid-of-numbers-in-java/
public class Pyramid {

    public static void main(String[] args) {

        printPattern1();
    }

//         1
//        1 2
//       1 2 3
//      1 2 3 4
//     1 2 3 4 5
//    1 2 3 4 5 6
//   1 2 3 4 5 6 7
//  1 2 3 4 5 6 7 8
// 1 2 3 4 5 6 7 8 9
    static void printPattern1() {
        int noOfRows = 9;
        // Initializing rowCount with 1
        int rowCount = 1;

        // rows decreasing ...
        for (int i = noOfRows; i > 0; i--) {

            //  Printing i spaces at the beginning of each row
            for (int j = 1; j <= i; j++) {
                System.out.print(" ");
            }

            //  Printing 'j' value at the end of each row
            for (int j = 1; j <= rowCount; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
            rowCount ++;
        }
    }




}
