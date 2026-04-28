package day0428.generic.advance.prob02;

import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {
    public static void main(String[] args) {

        List<Board> boardList = new LinkedList<>();

        boardList.add(new Board("subject1", "content1", "writer1"));
        boardList.add(new Board("subject2", "content2", "writer2"));
        boardList.add(new Board("subject3", "content3", "writer3"));
        boardList.add(new Board("subject4", "content4", "writer4"));
        boardList.add(new Board("subject5", "content5", "writer5"));

        System.out.println("요소의 개수: " + boardList.size());

        System.out.println("3번째 데이터: " + boardList.get(2));

        for (int i = 0; i < boardList.size(); ++i) {
            System.out.println((i + 1) + "번째 데이터: " + boardList.get(i));
        }

        boardList.remove(2);

        boardList.remove(2);

        for (Board board : boardList) {
            System.out.println(board);
        }
    }
}
