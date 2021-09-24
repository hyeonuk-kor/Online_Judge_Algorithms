import java.util.Arrays;
import java.util.Comparator;

public class GreedyAlgorithm {
    public void knapsackFunc(int[][] objectList, double capacity) {
        double totalValue = 0.0;
        double fraction = 0.0;

        // 정렬하기
        Arrays.sort(objectList, new Comparator<int[]>() {
            @Override
            public int compare(int[] objectItem1, int[] objectItem2) {
                return (objectItem2[1] / objectItem2[0]) - (objectItem1[1] / objectItem1[0]);
            }
        });

        for (int index = 0; index < objectList.length; index++) {
            if ( (capacity - (double)objectList[index][0]) >= 0 ) {
                capacity -= (double)objectList[index][0];
                totalValue += (double)objectList[index][1];
                System.out.println(objectList[index][0] + ", " + objectList[index][1] + ": " + 1);
            } else {
                fraction = capacity / (double)objectList[index][0];
                totalValue += (double)objectList[index][1] * fraction;
                System.out.println(objectList[index][0] + ", " + objectList[index][1] + ": " + fraction);
                break;
            }
        }
        System.out.println("총 담을 수 있는 가치: " + totalValue);
    }

    public static void main(String[] args) {
        GreedyAlgorithm gObject = new GreedyAlgorithm();
        int[][] objectList = { {10, 10}, {15, 12}, {20, 10}, {25, 8}, {30, 5} };
        gObject.knapsackFunc(objectList, 30.0);
    }
}