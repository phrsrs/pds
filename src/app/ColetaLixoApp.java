package app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

// ==========================================
// 1. MODEL (Modelo de Dados)
// ==========================================
class PontoColeta {
    private String bairro;
    private String tipoColeta; // "Convencional" ou "Seletiva (Recicláveis)"
    private String dias;
    private String horarioTurno;

    public PontoColeta(String bairro, String tipoColeta, String dias, String horarioTurno) {
        this.bairro = bairro;
        this.tipoColeta = tipoColeta;
        this.dias = dias;
        this.horarioTurno = horarioTurno;
    }

    public String getBairro() { return bairro; }
    public String getTipoColeta() { return tipoColeta; }
    public String getDias() { return dias; }
    public String getHorarioTurno() { return horarioTurno; }
}

// ==========================================
// 2. CONTROLLER (Regras de Negócio e Banco de Dados)
// ==========================================
class ColetaController {
    private List<PontoColeta> listaPontos;

    public ColetaController() {
        listaPontos = new ArrayList<>();
        carregarDadosOficiais();
    }

    private void carregarDadosOficiais() {
        // --- DADOS DA COLETA SELETIVA ---
        addSeletiva("ALTO GASPARINHO", "Terça-feira", "A partir das 05:00h");
        addSeletiva("ARRAIAL D'OURO", "Quarta-feira", "A partir das 05:00h");
        addSeletiva("BARRACÃO", "Sexta-feira", "A partir das 05:00h");
        addSeletiva("BARRACÃO (COMUNIDADE ÓLEO GRANDE)", "Sexta-feira", "A partir das 05:00h");
        addSeletiva("BATEIAS", "Sexta-feira", "A partir das 05:00h");
        addSeletiva("BELA VISTA", "Quinta-feira", "A partir das 05:00h");
        addSeletiva("BELCHIOR ALTO", "Quarta-feira", "A partir das 05:00h");
        addSeletiva("BELCHIOR BAIXO", "Quarta-feira", "A partir das 05:00h");
        addSeletiva("BELCHIOR CENTRAL", "Quarta-feira", "A partir das 05:00h");
        addSeletiva("CENTRO", "Sexta-feira", "A partir das 05:00h");
        addSeletiva("COLONINHA", "Quinta-feira", "A partir das 05:00h");
        addSeletiva("FIGUEIRA", "Quinta-feira", "A partir das 05:00h");
        addSeletiva("GASPAR GRANDE", "Terça-feira", "A partir das 05:00h");
        addSeletiva("GASPAR GRANDE (LOCALIDADE GARUBA)", "Quinta-feira", "A partir das 05:00h");
        addSeletiva("GASPAR ALTO", "Terça-feira", "A partir das 05:00h");
        addSeletiva("GASPAR MIRIM EXCETO A COHAB", "Terça-feira", "A partir das 05:00h");
        addSeletiva("GASPAR MIRIM (COHAB)", "Terça-feira", "A partir das 05:00h");
        addSeletiva("GASPARINHO", "Terça-feira", "A partir das 05:00h");
        addSeletiva("LAGOA", "Quarta-feira", "A partir das 05:00h");
        addSeletiva("MACUCO", "Sexta-feira", "A partir das 05:00h");
        addSeletiva("MARGEM ESQUERDA E SERTÃO VERDE", "Segunda-feira", "A partir das 05:00h");
        addSeletiva("LOCALIDADE MORRO GRANDE", "Quarta-feira", "A partir das 05:00h");
        addSeletiva("POÇO GRANDE", "Quarta-feira", "A partir das 05:00h");
        addSeletiva("SANTA TEREZINHA", "Sexta-feira", "A partir das 05:00h");
        addSeletiva("SANTA TERESINHA (BOM JESUS)", "Sexta-feira", "A partir das 05:00h");
        addSeletiva("SÃO PEDRO", "Quarta-feira", "A partir das 05:00h");
        addSeletiva("SETE DE SETEMBRO", "Segunda-feira", "A partir das 05:00h");

        // --- DADOS DA COLETA CONVENCIONAL ---
        addConvencional("ALTO GASPARINHO", "Quarta-feira", "Manhã");
        addConvencional("ARRAIAL D'OURO", "Quinta-feira", "Manhã");
        addConvencional("BARRACÃO", "Quarta-feira e Sábado", "Manhã");
        addConvencional("BARRACÃO (COMUNIDADE ÓLEO GRANDE)", "Quinta-feira", "Manhã");
        addConvencional("BATEIAS", "Quarta-feira e Sábado", "Manhã");
        addConvencional("BELA VISTA", "Segunda, Quarta e Sexta", "Tarde");
        addConvencional("BELCHIOR ALTO", "Segunda e Sexta", "Manhã");
        addConvencional("BELCHIOR BAIXO", "Segunda e Sexta", "Manhã");
        addConvencional("BELCHIOR CENTRAL", "Segunda e Sexta", "Manhã");
        addConvencional("CENTRO", "Segunda a Sábado", "Tarde");
        addConvencional("COLONINHA", "Segunda, Quarta e Sexta", "Tarde");
        addConvencional("FIGUEIRA", "Segunda, Quarta e Sexta", "Tarde");
        addConvencional("GASPAR GRANDE", "Segunda, Quarta e Sexta", "Manhã");
        addConvencional("GASPAR GRANDE (LOCALIDADE GARUBA)", "Segunda e Sexta", "Manhã");
        addConvencional("GASPAR ALTO", "Quarta-feira", "Manhã");
        addConvencional("GASPAR MIRIM EXCETO A COHAB", "Segunda, Quarta e Sexta", "Manhã");
        addConvencional("GASPAR MIRIM (COHAB)", "Terça, Quinta e Sábado", "Tarde");
        addConvencional("GASPARINHO", "Segunda, Quarta e Sexta", "Manhã");
        addConvencional("LAGOA", "Terça-feira e Sábado", "Manhã");
        addConvencional("MACUCO", "Terça-feira", "Manhã");
        addConvencional("MARGEM ESQUERDA E SERTÃO VERDE", "Terça, Quinta e Sábado", "Manhã");
        addConvencional("LOCALIDADE MORRO GRANDE", "Terça-feira", "Manhã");
        addConvencional("POÇO GRANDE E RUA ITAJAÍ", "Terça, Quinta e Sábado", "Manhã");
        addConvencional("SANTA TEREZINHA", "Terça, Quinta e Sábado", "Tarde");
        addConvencional("SANTA TERESINHA (BOM JESUS)", "Terça, Quinta e Sábado", "Manhã");
        addConvencional("SÃO PEDRO", "Terça, Quinta e Sábado", "Tarde");
        addConvencional("SETE DE SETEMBRO", "Terça, Quinta e Sábado", "Tarde");
    }

    private void addSeletiva(String bairro, String dias, String horario) {
        listaPontos.add(new PontoColeta(bairro, "Seletiva (Recicláveis)", dias, horario));
    }

    private void addConvencional(String bairro, String dias, String horario) {
        listaPontos.add(new PontoColeta(bairro, "Convencional", dias, horario));
    }

    public List<PontoColeta> getTodosPontos() {
        return listaPontos;
    }

    public List<PontoColeta> filtrar(String buscaBairro, String filtroTipo) {
        List<PontoColeta> resultado = new ArrayList<>();
        for (PontoColeta p : listaPontos) {
            boolean bateuBairro = buscaBairro.isEmpty() || p.getBairro().toLowerCase().contains(buscaBairro.toLowerCase());
            boolean bateuTipo = filtroTipo.equals("Todos") || p.getTipoColeta().equalsIgnoreCase(filtroTipo);

            if (bateuBairro && bateuTipo) {
                resultado.add(p);
            }
        }
        return resultado;
    }
}

// ==========================================
// 3. VIEW (Interface Gráfica com WindowBuilder)
// ==========================================
public class ColetaLixoApp extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtBuscaBairro;
    private JComboBox<String> cbFiltroTipo;
    private JTable tableColeta;
    private DefaultTableModel tableModel;
    
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
                    ColetaLixoApp frame = new ColetaLixoApp();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ColetaLixoApp() {
        controller = new ColetaController();

        setTitle("Sistema de Consulta de Coleta de Lixo - Gaspar/SC");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 850, 550);
        setLocationRelativeTo(null);

        // --- BARRA DE MENU ---
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnArquivo = new JMenu("Arquivo");
        menuBar.add(mnArquivo);

        JMenuItem mntmSair = new JMenuItem("Sair");
        mntmSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        mnArquivo.add(mntmSair);

        JMenu mnAjuda = new JMenu("Ajuda");
        menuBar.add(mnAjuda);

        JMenuItem mntmSobre = new JMenuItem("Sobre");
        mntmSobre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(ColetaLixoApp.this,
                        "Sistema de Consulta de Horários de Coleta de Lixo\n"
                        + "Cidade: Gaspar - SC\n"
                        + "Desenvolvido para Prática de Desenvolvimento de Sistemas\n"
                        + "Versão 1.0 - MVC & Swing",
                        "Sobre o Sistema", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        mnAjuda.add(mntmSobre);

        // --- PAINEL PRINCIPAL ---
        contentPane = new JPanel();
        contentPane.setBackground(new Color(245, 247, 248));
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPane.setLayout(new BorderLayout(0, 10));
        setContentPane(contentPane);

        // --- CABEÇALHO ---
        JPanel panelHeader = new JPanel();
        panelHeader.setBackground(new Color(27, 94, 32));
        panelHeader.setLayout(new BorderLayout(0, 0));
        panelHeader.setBorder(new EmptyBorder(15, 15, 15, 15));
        contentPane.add(panelHeader, BorderLayout.NORTH);

        JLabel lblTitulo = new JLabel("Coleta de Lixo - Gaspar/SC");
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 22));
        panelHeader.add(lblTitulo, BorderLayout.WEST);

        JLabel lblSubtitulo = new JLabel("Horários e dias por Bairro/Localidade");
        lblSubtitulo.setForeground(new Color(200, 230, 201));
        lblSubtitulo.setFont(new Font("Segoe UI", Font.ITALIC, 13));
        panelHeader.add(lblSubtitulo, BorderLayout.SOUTH);

        // --- PAINEL CENTRAL (FILTROS E TABELA) ---
        JPanel panelCenter = new JPanel();
        panelCenter.setOpaque(false);
        panelCenter.setLayout(new BorderLayout(0, 10));
        contentPane.add(panelCenter, BorderLayout.CENTER);

        // Painel de Filtros (Pesquisa)
        JPanel panelFiltros = new JPanel();
        panelFiltros.setBackground(Color.WHITE);
        panelFiltros.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200)), 
                " Filtro e Pesquisa ", TitledBorder.LEFT, TitledBorder.TOP, 
                new Font("Segoe UI", Font.BOLD, 12), new Color(33, 33, 33)));
        
        GridBagLayout gbl_panelFiltros = new GridBagLayout();
        gbl_panelFiltros.columnWidths = new int[]{0, 250, 0, 180, 0, 0};
        gbl_panelFiltros.rowHeights = new int[]{40, 0};
        gbl_panelFiltros.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_panelFiltros.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        panelFiltros.setLayout(gbl_panelFiltros);

        JLabel lblBairro = new JLabel("Procurar Bairro:");
        lblBairro.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        GridBagConstraints gbc_lblBairro = new GridBagConstraints();
        gbc_lblBairro.anchor = GridBagConstraints.EAST;
        gbc_lblBairro.insets = new Insets(5, 10, 5, 5);
        gbc_lblBairro.gridx = 0;
        gbc_lblBairro.gridy = 0;
        panelFiltros.add(lblBairro, gbc_lblBairro);

        txtBuscaBairro = new JTextField();
        txtBuscaBairro.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        txtBuscaBairro.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                atualizarTabela();
            }
        });
        GridBagConstraints gbc_txtBuscaBairro = new GridBagConstraints();
        gbc_txtBuscaBairro.insets = new Insets(5, 0, 5, 15);
        gbc_txtBuscaBairro.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtBuscaBairro.gridx = 1;
        gbc_txtBuscaBairro.gridy = 0;
        panelFiltros.add(txtBuscaBairro, gbc_txtBuscaBairro);
        txtBuscaBairro.setColumns(10);

        JLabel lblTipo = new JLabel("Tipo de Coleta:");
        lblTipo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        GridBagConstraints gbc_lblTipo = new GridBagConstraints();
        gbc_lblTipo.anchor = GridBagConstraints.EAST;
        gbc_lblTipo.insets = new Insets(5, 5, 5, 5);
        gbc_lblTipo.gridx = 2;
        gbc_lblTipo.gridy = 0;
        panelFiltros.add(lblTipo, gbc_lblTipo);

        cbFiltroTipo = new JComboBox<>();
        cbFiltroTipo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        cbFiltroTipo.setModel(new DefaultComboBoxModel<>(new String[] {"Todos", "Convencional", "Seletiva (Recicláveis)"}));
        cbFiltroTipo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                atualizarTabela();
            }
        });
        GridBagConstraints gbc_cbFiltroTipo = new GridBagConstraints();
        gbc_cbFiltroTipo.insets = new Insets(5, 0, 5, 10);
        gbc_cbFiltroTipo.fill = GridBagConstraints.HORIZONTAL;
        gbc_cbFiltroTipo.gridx = 3;
        gbc_cbFiltroTipo.gridy = 0;
        panelFiltros.add(cbFiltroTipo, gbc_cbFiltroTipo);

        JButton btnLimpar = new JButton("Limpar Filtros");
        btnLimpar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        btnLimpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtBuscaBairro.setText("");
                cbFiltroTipo.setSelectedIndex(0);
                atualizarTabela();
            }
        });
        GridBagConstraints gbc_btnLimpar = new GridBagConstraints();
        gbc_btnLimpar.insets = new Insets(5, 0, 5, 10);
        gbc_btnLimpar.gridx = 4;
        gbc_btnLimpar.gridy = 0;
        panelFiltros.add(btnLimpar, gbc_btnLimpar);

        panelCenter.add(panelFiltros, BorderLayout.NORTH);

        // --- TABELA DE RESULTADOS ---
        String[] colunas = {"Bairro / Localidade", "Tipo de Coleta", "Dias da Coleta", "Horário / Turno"};
        tableModel = new DefaultTableModel(colunas, 0) {
            private static final long serialVersionUID = 1L;
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tableColeta = new JTable(tableModel);
        tableColeta.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        tableColeta.setRowHeight(25);
        tableColeta.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        tableColeta.getTableHeader().setBackground(new Color(230, 238, 232));

        JScrollPane scrollPane = new JScrollPane(tableColeta);
        panelCenter.add(scrollPane, BorderLayout.CENTER);

        // Rodapé informativo
        JLabel lblRodape = new JLabel("Exibindo informações oficiais dos serviços de Coleta Seletiva e Convencional.");
        lblRodape.setHorizontalAlignment(SwingConstants.CENTER);
        lblRodape.setFont(new Font("Segoe UI", Font.ITALIC, 11));
        lblRodape.setForeground(Color.GRAY);
        contentPane.add(lblRodape, BorderLayout.SOUTH);

        // Popula a tabela ao iniciar
        atualizarTabela();
    }

    private void atualizarTabela() {
        tableModel.setRowCount(0);

        String busca = txtBuscaBairro.getText();
        String tipo = cbFiltroTipo.getSelectedItem().toString();

        List<PontoColeta> pontos = controller.filtrar(busca, tipo);

        for (PontoColeta p : pontos) {
            Object[] linha = {
                p.getBairro(),
                p.getTipoColeta(),
                p.getDias(),
                p.getHorarioTurno()
            };
            tableModel.addRow(linha);
        }
    }
}
