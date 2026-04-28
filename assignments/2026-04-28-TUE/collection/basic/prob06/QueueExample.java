package day0428.collection.basic.prob06;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {

        Queue<Message> messageQueue = new LinkedList<>();

        messageQueue.offer(new Message("sendMail", "홍길동"));
        messageQueue.offer(new Message("sendSMS", "신용권"));
        messageQueue.offer(new Message("sendKakaotalk", "김자바"));

        while (!messageQueue.isEmpty()) {
            var message = messageQueue.poll();

            String send = switch (message.getCommand()) {
                case "sendMail" -> "메일";
                case "sendSMS" -> "SMS";
                case "sendKakaotalk" -> "카카오톡";
                default -> "";
            };

            System.out.println(message.getTo() + "님에게 " + send + "를 보냅니다.");
        }
    }
}
