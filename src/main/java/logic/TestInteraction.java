package logic;

public class TestInteraction {

    public static String getBody() {
        return body;
    }

    public static void setBody(String body) {
        TestInteraction.body = body;
    }

    public static Boolean getFirst() {
        return first;
    }

    public static void setFirst(Boolean first) {
        TestInteraction.first = first;
    }

    public static Boolean getSecond() {

        return second;
    }

    public static void setSecond(Boolean second) {
        TestInteraction.second = second;
    }

    private static String body;
    private static Boolean first = true;
    private static Boolean second = false;

}
