import javax.swing.JFrame;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyWindow extends JFrame {
    public static final long serialVersionUID = 1L;

    private JMenuBar menuBar;
    private JMenu menuRegister;
    private JMenuItem itemRegisterProduct;

    public MyWindow() {
        super();

        menuBar = new JMenuBar();
        menuRegister = new JMenu("Cadastrar");
        itemRegisterProduct = new JMenuItem("Produto");
        itemRegisterProduct.addActionListener(
                    new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            onSelectRegisterProduct();
                        }
                    }
                );

        menuRegister.add(itemRegisterProduct);

        menuBar.add(menuRegister);

        setJMenuBar(menuBar);

        setSize(640, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void onSelectRegisterProduct() {
        WindowEditProduct editProductWindow = new WindowEditProduct(this);
        editProductWindow.setVisible(true);
    }

}
