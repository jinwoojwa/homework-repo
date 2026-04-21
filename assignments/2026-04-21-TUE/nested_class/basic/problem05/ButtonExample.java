package basic.problem05;

public class ButtonExample {
    public static void main(String[] args) {
        Button btn = new Button();

        class OkListener implements Button.ClickListener {
            @Override
            public void onClick() {
                System.out.println("Ok 버튼 클릭");
            }
        }

        btn.setClickListener(new OkListener());

        btn.click();
    }
}
