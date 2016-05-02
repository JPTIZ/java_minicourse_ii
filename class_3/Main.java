public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        MainWindow window = new MainWindow(database);
        window.setVisible(true);
    }
}
