package day0428.generic.advance.prob02;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {
    public static void main(String[] args) {

        // TODO: Board 클래스를 저장하기 위한 ArrayList 인스턴스 생성
        List<Board> boardList = new ArrayList<>();

        // TODO: Board 클래스의 인스턴스 5개를 생성하여 ArrayList에 추가
        boardList.add(new Board("subject1", "content1", "writer1"));
        boardList.add(new Board("subject2", "content2", "writer2"));
        boardList.add(new Board("subject3", "content3", "writer3"));
        boardList.add(new Board("subject4", "content4", "writer4"));
        boardList.add(new Board("subject5", "content5", "writer5"));

        // TODO: ArrayList에 저장된 요소의 개수 출력
        System.out.println("요소의 개수: " + boardList.size());

        // TODO: 3번째 데이터를 추출하여 출력
        System.out.println("3번째 데이터: " + boardList.get(2));

        // TODO: 일반 for 문으로 순회하면서 리스트의 각 요소를 출력
        for (int i = 0; i < boardList.size(); ++i) {
            System.out.println((i + 1) + "번째 데이터: " + boardList.get(i));
        }

        // TODO: 인덱스 2에 해당하는 요소 제거
        boardList.remove(2);

        // TODO: 인덱스 2에 해당하는 요소 제거
        boardList.remove(2);

        // TODO: 향상된 for 문으로 순회하면서 리스트의 각 요소를 출력
        for (Board board : boardList) {
            System.out.println(board);
        }
    }
}
