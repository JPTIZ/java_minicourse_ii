public class Main {
    public static void main(String[] args) {
	Database database = new Database();
        MyWindow window = new MyWindow(database);
        window.setVisible(true);
    }
}
