import javax.swing.JFrame;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WindowEditProduct extends JDialog {
    public static final long serialVersionUID = 3L;

    private JLabel lblName;
    private JLabel lblCost;
    private JTextField edtName;
    private JTextField edtCost;
    private JButton btnSave;
    private Database database;

    public WindowEditProduct(JFrame parent, Database database) {
        super(parent);

        this.database = database;

        setModal(true);

        lblName = new JLabel("Nome:");
        lblName.setSize(64, 24);
        lblName.setLocation(4, 4);

        lblCost = new JLabel("Preço:");
        lblCost.setSize(64, 24);
        lblCost.setLocation(4, 32);

        edtName = new JTextField();
        edtName.setSize(64, 24);
        edtName.setLocation(68, 4);

        edtCost = new JTextField();
        edtCost.setSize(64, 24);
        edtCost.setLocation(68, 32);

        btnSave = new JButton("Salvar");
        btnSave.setSize(128, 24);
        btnSave.setLocation(4, 60);

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveProduct();
            }
        });

        setTitle("Cadastro de Produto");
        setLayout(null);
        getContentPane().add(lblName);
        getContentPane().add(lblCost);
        getContentPane().add(edtName);
        getContentPane().add(edtCost);
        getContentPane().add(btnSave);
        setSize(320, 240);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void saveProduct() {
        Product product = new Product(
                                edtName.getText(),
                                Double.parseDouble(edtCost.getText())
                            );
        database.saveProduct(product);
    }

}
