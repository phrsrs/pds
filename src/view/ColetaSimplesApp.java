package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.ColetaController;
import model.PontoColeta;

public class ColetaSimplesApp extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtBusca;
    private JTable tabela;
    private DefaultTableModel modeloTabela;
    private ColetaController controller;

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ColetaSimplesApp frame = new ColetaSimplesApp();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ColetaSimplesApp() {
        controller = new ColetaController();

        setTitle("Consulta de Coleta de Lixo - Gaspar/SC");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 750, 450);
        setLocationRelativeTo(null);

        // Menu Superior
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menuAjuda = new JMenu("Ajuda");
        menuBar.add(menuAjuda);

        JMenuItem menuSobre = new JMenuItem("Sobre");
        menuSobre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(ColetaSimplesApp.this,
                        "Sistema de Consulta de Coleta de Lixo\nDesenvolvido no padrão MVC.",
                        "Sobre", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        menuAjuda.add(menuSobre);

        // Painel Principal
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPane.setLayout(new BorderLayout(0, 10));
        setContentPane(contentPane);

        // Painel de Pesquisa
        JPanel panelTopo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelTopo.add(new JLabel("Pesquisar Bairro, Tipo ou Dia:"));

        txtBusca = new JTextField(25);
        txtBusca.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                atualizarTabela();
            }
        });
        panelTopo.add(txtBusca);
        contentPane.add(panelTopo, BorderLayout.NORTH);

        // Tabela central com a coluna de Horário / Turno
        String[] colunas = {"Bairro / Localidade", "Tipo de Coleta", "Dias de Atendimento", "Horário / Turno"};
        modeloTabela = new DefaultTableModel(colunas, 0) {
            private static final long serialVersionUID = 1L;
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tabela = new JTable(modeloTabela);
        JScrollPane scrollPane = new JScrollPane(tabela);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        // Carrega os dados na inicialização
        atualizarTabela();
    }

    private void atualizarTabela() {
        modeloTabela.setRowCount(0);
        String texto = txtBusca.getText().trim();

        List<PontoColeta> lista = texto.isEmpty() ? controller.listarTodos() : controller.filtrar(texto);

        for (PontoColeta p : lista) {
            modeloTabela.addRow(new Object[] { p.getBairro(), p.getTipo(), p.getDias(), p.getHorario() });
        }
    }
}
