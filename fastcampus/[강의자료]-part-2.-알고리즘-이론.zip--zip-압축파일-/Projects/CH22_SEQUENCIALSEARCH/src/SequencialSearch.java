import java.util.ArrayList;

public class SequencialSearch {
    public int searchFunc(ArrayList<Integer> dataList, Integer searchItem) {
        for (int index = 0; index < dataList.size(); index++) {
            if (dataList.get(index) == searchItem) {
                return index;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SequencialSearch sSearch = new SequencialSearch();
        ArrayList<Integer> testData = new ArrayList<Integer>();

        for (int index = 0; index < 10; index++) {
            testData.add((int)(Math.random() * 100));턴
        }
        System.out.println(testData);
        System.out.println(sSearch.searchFunc(testData, 19)); // 해당 숫자가 없으면, -1, 있으면 1을 리
    }
}