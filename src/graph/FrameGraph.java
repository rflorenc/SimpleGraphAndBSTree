package graph;

import btree.FrameTree;
import java.awt.*;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class FrameGraph extends javax.swing.JFrame {

    
    Graph graph = new Graph(8);
    int i = 0, ValX = 0, ValY = 0, raio = 10;
    DrawCircles dc;
    Image ScreenImg;
    
    // File(open,save, ...)
    JFileChooser fc = null;
    File f = null;
    FileReader fr = null;
    FileWriter fwr = null;
    
    //Circle positions
    Point pc1 = new Point(200, 250);
    Point pc2 = new Point(250, 110);
    Point pc3 = new Point(300, 300);
    Point pc4 = new Point(450, 150);
    Point pc5 = new Point(80, 300);
    Point pc6 = new Point(70, 50);
    Point pc7 = new Point(460, 380);
    Point pc8 = new Point(460, 80);
    
    //Arch conections
    Vertex v1 = new Vertex(1, pc1);
    Vertex v2 = new Vertex(2, pc2);
    Vertex v3 = new Vertex(3, pc3);
    Vertex v4 = new Vertex(4, pc4);
    Vertex v5 = new Vertex(5, pc5);
    Vertex v6 = new Vertex(6, pc6);
    Vertex v7 = new Vertex(7, pc7);
    Vertex v8 = new Vertex(8, pc8);
    //Criação do Ciruclo
    Circle gb1 = new Circle(pc1, raio);
    Circle gb2 = new Circle(pc2, raio);
    Circle gb3 = new Circle(pc3, raio);
    Circle gb4 = new Circle(pc4, raio);
    Circle gb5 = new Circle(pc5, raio);
    Circle gb6 = new Circle(pc6, raio);
    Circle gb7 = new Circle(pc7, raio);
    Circle gb8 = new Circle(pc8, raio);

    public FrameGraph() {
        initComponents();
    }

    public JTextArea getjTextArea1() {
        return jTextArea1;
    }

    public void setjTextArea1(JTextArea jTextArea1) {
        this.jTextArea1 = jTextArea1;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnVoltar = new javax.swing.JButton();
        DrawPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        checkbox1 = new java.awt.Checkbox();
        checkbox2 = new java.awt.Checkbox();
        checkbox3 = new java.awt.Checkbox();
        Jtabuleiro = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        btnLimpar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        JMenuFicheiro = new javax.swing.JMenu();
        jMenuOpenFile = new javax.swing.JMenuItem();
        JMenuSave = new javax.swing.JMenu();
        JMenuSaveTexto = new javax.swing.JMenuItem();
        JMenuSaveBin = new javax.swing.JMenuItem();
        JMenuExit = new javax.swing.JMenuItem();
        JMenuGrafo = new javax.swing.JMenu();
        jMenuVerificarGrafo = new javax.swing.JMenuItem();
        jMenuISHORTEST_PATH = new javax.swing.JMenuItem();
        jMenuHops = new javax.swing.JMenuItem();
        jMenuDijkstra = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Grafos");
        setLocationByPlatform(true);
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        btnVoltar.setText("Back");
        btnVoltar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        DrawPanel.setBackground(new java.awt.Color(255, 204, 51));
        DrawPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        DrawPanel.setPreferredSize(new java.awt.Dimension(500, 400));
        DrawPanel.setRequestFocusEnabled(false);
        DrawPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DrawPanelformMouseClicked(evt);
            }
        });
        DrawPanel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                DrawPanelComponentShown(evt);
            }
        });

        org.jdesktop.layout.GroupLayout DrawPanelLayout = new org.jdesktop.layout.GroupLayout(DrawPanel);
        DrawPanel.setLayout(DrawPanelLayout);
        DrawPanelLayout.setHorizontalGroup(
            DrawPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 496, Short.MAX_VALUE)
        );
        DrawPanelLayout.setVerticalGroup(
            DrawPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 396, Short.MAX_VALUE)
        );

        jLabel1.setText("Total vertices:");

        checkbox1.setLabel("Level 1");

        checkbox2.setLabel("Level 2");

        checkbox3.setLabel("Level 3");

        Jtabuleiro.setText("Generate");
        Jtabuleiro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JtabuleiroMouseClicked(evt);
            }
        });
        Jtabuleiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtabuleiroActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        btnLimpar.setText("Clear");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        JMenuFicheiro.setText("File");

        jMenuOpenFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuOpenFile.setText("Open...");
        jMenuOpenFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuOpenFileActionPerformed(evt);
            }
        });
        JMenuFicheiro.add(jMenuOpenFile);

        JMenuSave.setText("Save");

        JMenuSaveTexto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        JMenuSaveTexto.setText("Save text");
        JMenuSaveTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMenuSaveTextoActionPerformed(evt);
            }
        });
        JMenuSave.add(JMenuSaveTexto);

        JMenuSaveBin.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        JMenuSaveBin.setText("Save state");
        JMenuSaveBin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMenuSaveBinActionPerformed(evt);
            }
        });
        JMenuSave.add(JMenuSaveBin);

        JMenuFicheiro.add(JMenuSave);

        JMenuExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        JMenuExit.setText("Exit");
        JMenuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMenuExitActionPerformed(evt);
            }
        });
        JMenuFicheiro.add(JMenuExit);

        jMenuBar1.add(JMenuFicheiro);

        JMenuGrafo.setText("Tests");

        jMenuVerificarGrafo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        jMenuVerificarGrafo.setText("Verify graph type");
        jMenuVerificarGrafo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuVerificarGrafoActionPerformed(evt);
            }
        });
        JMenuGrafo.add(jMenuVerificarGrafo);

        jMenuISHORTEST_PATH.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuISHORTEST_PATH.setText("Determine shortest path");
        jMenuISHORTEST_PATH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuISHORTEST_PATHActionPerformed(evt);
            }
        });
        JMenuGrafo.add(jMenuISHORTEST_PATH);

        jMenuHops.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        jMenuHops.setText("Determine hop number");
        JMenuGrafo.add(jMenuHops);

        jMenuDijkstra.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        jMenuDijkstra.setText("Dijkstra");
        jMenuDijkstra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuDijkstraActionPerformed(evt);
            }
        });
        JMenuGrafo.add(jMenuDijkstra);

        jMenuBar1.add(JMenuGrafo);

        setJMenuBar(jMenuBar1);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(btnLimpar))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .addContainerGap()
                                .add(btnVoltar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 48, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(layout.createSequentialGroup()
                                .add(77, 77, 77)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 499, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(layout.createSequentialGroup()
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                            .add(layout.createSequentialGroup()
                                                .add(jLabel1)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 26, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                            .add(DrawPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                .add(checkbox3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                                    .add(checkbox2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                    .add(org.jdesktop.layout.GroupLayout.LEADING, checkbox1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                                            .add(Jtabuleiro))))))
                        .add(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(69, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 14, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel1))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(DrawPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(169, 169, 169)
                        .add(checkbox1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(checkbox2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(checkbox3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(21, 21, 21)
                        .add(Jtabuleiro)))
                .add(38, 38, 38)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 36, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(10, 10, 10)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(btnVoltar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(btnLimpar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void setLocationRelativeTo(Component c) {
        super.setLocationRelativeTo(null);
    }

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        this.JtabuleiroActionPerformed(null);
        JOptionPane.showMessageDialog(this, "Whoops...", "Info", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_formMouseClicked

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        this.dispose();
        new FrameTree().setVisible(true);
}//GEN-LAST:event_btnVoltarActionPerformed

    private void jMenuVerificarGrafoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuVerificarGrafoActionPerformed
        try {

            System.out.println("\nVerify conected graph:");
            if (checkbox1.getState() == true) {
                if (graph.ConexGraph(3) == true) {
                    JOptionPane.showMessageDialog(null, "Connected graph");
                    System.out.println(" Connected graph");
                } else {
                    JOptionPane.showMessageDialog(null, "Não Connected graph");
                    System.out.println(" Non connected graph");

                    this.JtabuleiroActionPerformed(evt);
                }

                return;
            } else if (checkbox2.getState() == true) {
                if (graph.ConexGraph(2) == true) {
                    JOptionPane.showMessageDialog(null, "Connected graph");
                    System.out.println(" Connected graph");
                } else {
                    JOptionPane.showMessageDialog(null, "Não Connected graph");
                    System.out.println(" Non connected graph");
                }
                this.JtabuleiroActionPerformed(evt);


                return;
            } else if (checkbox3.getState() == true) {
                if (graph.ConexGraph(1) == true) {
                    JOptionPane.showMessageDialog(null, "Connected graph");
                    System.out.println(" Connected graph");
//                        JOptionPane.showMessageDialog(null, "\nConnected graph", "\nVerifição Tipo de Graph(" + j + ")", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Não Connected graph");
//                        JOptionPane.showMessageDialog(null, "\nNon connected graph", "\nVerifição Tipo de Graph(" + j + ")", JOptionPane.INFORMATION_MESSAGE);
                    System.out.println(" Non connected graph");
                }
                this.JtabuleiroActionPerformed(evt);

                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na verificação Conexa do grafo.");
        }
    }//GEN-LAST:event_jMenuVerificarGrafoActionPerformed

    private void JMenuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMenuExitActionPerformed
        System.exit(0);
}//GEN-LAST:event_JMenuExitActionPerformed

    private void jMenuOpenFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuOpenFileActionPerformed

        fc = new JFileChooser();
        Graphics g = this.DrawPanel.getGraphics();
        int option = fc.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            this.paintComponent(g);
            this.JtabuleiroActionPerformed(evt);
            try {
                f = fc.getSelectedFile();
                fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String line = null;
                int lines = 0;
                while ((line = br.readLine()) != null) {
                    //this.jTextArea1.setText("Linha " + (lines++) + ": " + line+"\n");
                    this.jTextArea1.setText(line + "\n");
                    br.readLine();
                    //JOptionPane.showMessageDialog(null, "Linha " + (lines++) + ": " + line);
                }
                br.close();

            } catch (IOException ex) {
                Logger.getLogger(FrameGraph.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.JtabuleiroActionPerformed(evt);

}//GEN-LAST:event_jMenuOpenFileActionPerformed

    private void DrawPanelformMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DrawPanelformMouseClicked

        Graphics g = this.DrawPanel.getGraphics();
        //this.graph.drawGraph(g);
        try {
            if (checkbox1.getState() != true && checkbox2.getState() != true && checkbox3.getState() != true) {
                JOptionPane.showMessageDialog(null, "Têm de selecionar um nivel.", "Informação", JOptionPane.INFORMATION_MESSAGE);
            } else {

                Point p = new Point(evt.getX(), evt.getY());
                System.out.println("" + p);

                if (checkbox1.getState() == true) {

                    if (gb1.isInside(p) == true) {
                        g.drawOval((int) p.getX(), (int) p.getY(), raio, raio);
                        g.drawString("Select", (int) p.getX(), (int) p.getY());
                        g.setColor(Color.GREEN);
                        g.fillOval((int) p.getX(), (int) p.getY(), raio, raio);

                    } else if (gb2.isInside(p) == true) {
                        g.drawOval((int) p.getX(), (int) p.getY(), raio, raio);
                        g.drawString("Select", (int) p.getX(), (int) p.getY());
                        g.setColor(Color.GREEN);
                        g.fillOval((int) p.getX(), (int) p.getY(), raio, raio);

                    } else if (gb3.isInside(p) == true) {
                        g.drawOval((int) p.getX(), (int) p.getY(), raio, raio);
                        g.drawString("Select", (int) p.getX(), (int) p.getY());
                        g.setColor(Color.GREEN);
                        g.fillOval((int) p.getX(), (int) p.getY(), raio, raio);

                    } else if (gb4.isInside(p) == true) {
                        g.drawOval((int) p.getX(), (int) p.getY(), raio, raio);
                        g.drawString("Select", (int) p.getX(), (int) p.getY());
                        g.setColor(Color.GREEN);
                        g.fillOval((int) p.getX(), (int) p.getY(), raio, raio);

                    } else if (gb5.isInside(p) == true) {
                        g.drawOval((int) p.getX(), (int) p.getY(), raio, raio);
                        g.drawString("Select", (int) p.getX(), (int) p.getY());
                        g.setColor(Color.GREEN);
                        g.fillOval((int) p.getX(), (int) p.getY(), raio, raio);

                    } else if (gb6.isInside(p) == true) {
                        g.drawOval((int) p.getX(), (int) p.getY(), raio, raio);
                        g.drawString("Select", (int) p.getX(), (int) p.getY());
                        g.setColor(Color.GREEN);
                        g.fillOval((int) p.getX(), (int) p.getY(), raio, raio);

                    } else {
                        JOptionPane.showMessageDialog(null, "Try inside the circles!", "Info", JOptionPane.INFORMATION_MESSAGE);
                        this.JtabuleiroActionPerformed(null);

                    }
                    return;

                } else if (checkbox2.getState() == true) {
                    if (gb1.isInside(p) == true) {
                        g.drawOval((int) p.getX(), (int) p.getY(), raio, raio);
                        g.drawString("Select", (int) p.getX(), (int) p.getY());
                        g.setColor(Color.GREEN);
                        g.fillOval((int) p.getX(), (int) p.getY(), raio, raio);
                    } else if (gb2.isInside(p) == true) {
                        g.drawOval((int) p.getX(), (int) p.getY(), raio, raio);
                        g.drawString("Select", (int) p.getX(), (int) p.getY());
                        g.setColor(Color.GREEN);
                        g.fillOval((int) p.getX(), (int) p.getY(), raio, raio);
                    } else if (gb3.isInside(p) == true) {
                        g.drawOval((int) p.getX(), (int) p.getY(), raio, raio);
                        g.drawString("Select", (int) p.getX(), (int) p.getY());
                        g.setColor(Color.GREEN);
                        g.fillOval((int) p.getX(), (int) p.getY(), raio, raio);
                    } else if (gb4.isInside(p) == true) {
                        g.drawOval((int) p.getX(), (int) p.getY(), raio, raio);
                        g.drawString("Select", (int) p.getX(), (int) p.getY());
                        g.setColor(Color.GREEN);
                        g.fillOval((int) p.getX(), (int) p.getY(), raio, raio);
                    } else if (gb5.isInside(p) == true) {
                        g.drawOval((int) p.getX(), (int) p.getY(), raio, raio);
                        g.drawString("Select", (int) p.getX(), (int) p.getY());
                        g.setColor(Color.GREEN);
                        g.fillOval((int) p.getX(), (int) p.getY(), raio, raio);
                    } else if (gb6.isInside(p) == true) {
                        g.drawOval((int) p.getX(), (int) p.getY(), raio, raio);
                        g.drawString("Select", (int) p.getX(), (int) p.getY());
                        g.setColor(Color.GREEN);
                        g.fillOval((int) p.getX(), (int) p.getY(), raio, raio);
                    } else if (gb7.isInside(p) == true) {
                        g.drawOval((int) p.getX(), (int) p.getY(), raio, raio);
                        g.drawString("Select", (int) p.getX(), (int) p.getY());
                        g.setColor(Color.GREEN);
                        g.fillOval((int) p.getX(), (int) p.getY(), raio, raio);
                    } else {
                        JOptionPane.showMessageDialog(null, "Try inside the circles!", "Info", JOptionPane.INFORMATION_MESSAGE);
                        this.JtabuleiroActionPerformed(null);
                    }
                    return;

                } else if (checkbox3.getState() == true) {
                    if (gb1.isInside(p) == true) {
                        g.drawOval((int) p.getX(), (int) p.getY(), raio, raio);
                        g.drawString("Select", (int) p.getX(), (int) p.getY());
                        g.setColor(Color.GREEN);
                        g.fillOval((int) p.getX(), (int) p.getY(), raio, raio);
                    } else if (gb2.isInside(p) == true) {
                        g.drawOval((int) p.getX(), (int) p.getY(), raio, raio);
                        g.drawString("Select", (int) p.getX(), (int) p.getY());
                        g.setColor(Color.GREEN);
                        g.fillOval((int) p.getX(), (int) p.getY(), raio, raio);
                    } else if (gb3.isInside(p) == true) {
                        g.drawOval((int) p.getX(), (int) p.getY(), raio, raio);
                        g.drawString("Select", (int) p.getX(), (int) p.getY());
                        g.setColor(Color.GREEN);
                        g.fillOval((int) p.getX(), (int) p.getY(), raio, raio);
                    } else if (gb4.isInside(p) == true) {
                        g.drawOval((int) p.getX(), (int) p.getY(), raio, raio);
                        g.drawString("Select", (int) p.getX(), (int) p.getY());
                        g.setColor(Color.GREEN);
                        g.fillOval((int) p.getX(), (int) p.getY(), raio, raio);
                    } else if (gb5.isInside(p) == true) {
                        g.drawOval((int) p.getX(), (int) p.getY(), raio, raio);
                        g.drawString("Select", (int) p.getX(), (int) p.getY());
                        g.setColor(Color.GREEN);
                        g.fillOval((int) p.getX(), (int) p.getY(), raio, raio);
                    } else if (gb6.isInside(p) == true) {
                        g.drawOval((int) p.getX(), (int) p.getY(), raio, raio);
                        g.drawString("Select", (int) p.getX(), (int) p.getY());
                        g.setColor(Color.GREEN);
                        g.fillOval((int) p.getX(), (int) p.getY(), raio, raio);
                    } else if (gb7.isInside(p) == true) {
                        g.drawOval((int) p.getX(), (int) p.getY(), raio, raio);
                        g.drawString("Select", (int) p.getX(), (int) p.getY());
                        g.setColor(Color.GREEN);
                        g.fillOval((int) p.getX(), (int) p.getY(), raio, raio);
                    } else if (gb8.isInside(p) == true) {
                        g.drawOval((int) p.getX(), (int) p.getY(), raio, raio);
                        g.drawString("Select", (int) p.getX(), (int) p.getY());
                        g.setColor(Color.GREEN);
                        g.fillOval((int) p.getX(), (int) p.getY(), raio, raio);
                    } else {
                        JOptionPane.showMessageDialog(null, "You're outside...", "Info", JOptionPane.INFORMATION_MESSAGE);
                        this.JtabuleiroActionPerformed(null);
                    }
                    return;
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }

}//GEN-LAST:event_DrawPanelformMouseClicked

    private void JtabuleiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtabuleiroActionPerformed
        DrawPanelComponentShown(null);
    }//GEN-LAST:event_JtabuleiroActionPerformed

    private void jMenuISHORTEST_PATHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuISHORTEST_PATHActionPerformed
        try {
            if (checkbox1.getState() == true) {
                this.JtabuleiroActionPerformed(evt);
                return;
                
            } else if (checkbox2.getState() == true) {
                graph.Shortest_Path(2);
                this.JtabuleiroActionPerformed(evt);

                return;
            } else if (checkbox3.getState() == true) {
                graph.Shortest_Path(1);
                this.JtabuleiroActionPerformed(evt);

                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar Distancia(SHORTEST PATH).", "Informação", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

    }//GEN-LAST:event_jMenuISHORTEST_PATHActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        Graphics g = getGraphics();
        this.DrawPanel.removeAll();
        this.paintComponent(g);
        this.jTextArea1.setText(null);
        this.checkbox1.setState(false);
        this.checkbox2.setState(false);
        this.checkbox3.setState(false);
        this.jLabel2.setText(null);

    }//GEN-LAST:event_btnLimparActionPerformed

    private void DrawPanelComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_DrawPanelComponentShown
        Graphics g = this.DrawPanel.getGraphics();

        if (checkbox1.getState() == true) {
            this.DrawPanel.removeAll();

            //Desenha NODOS
            g.drawOval(200 - raio, 250 - raio, 20, 20);
            g.setColor(Color.BLUE);
            g.drawString("p1", 200 - raio, 250 - raio);
            g.setColor(Color.BLUE);
            g.fillOval(200 - raio, 250 - raio, 20, 20);

            g.drawOval(250 - raio, 110 - raio, 20, 20);
            g.drawString("p2", 250 - raio, 110 - raio);
            g.setColor(Color.BLUE);
            g.fillOval(250 - raio, 110 - raio, 20, 20);

            g.drawOval(300 - raio, 300 - raio, 20, 20);
            g.drawString("p3", 300 - raio, 300 - raio);
            g.setColor(Color.BLUE);
            g.fillOval(300 - raio, 300 - raio, 20, 20);

            g.drawOval(450 - raio, 150 - raio, 20, 20);
            g.drawString("p4", 450 - raio, 150 - raio);
            g.setColor(Color.BLUE);
            g.fillOval(450 - raio, 150 - raio, 20, 20);

            g.drawOval(80 - raio, 300 - raio, 20, 20);
            g.drawString("p5", 80 - raio, 300 - raio);
            g.setColor(Color.BLUE);
            g.fillOval(80 - raio, 300 - raio, 20, 20);

            g.drawOval(70 - raio, 50 - raio, 20, 20);
            g.drawString("p6", 70 - raio, 50 - raio);
            g.setColor(Color.BLUE);
            g.fillOval(70 - raio, 50 - raio, 20, 20);

            g.setColor(Color.WHITE);
            g.drawLine(200, 250, 250, 110); // p1 to p2
            g.setColor(Color.RED);
            g.drawString("30", 210, 200);


            g.setColor(Color.WHITE);
            g.drawLine(200, 250, 300, 300); //p1 to p3
            g.setColor(Color.RED);
            g.drawString("40", 240, 280);
            graph.addArch(v1, v3, 40);

            g.setColor(Color.WHITE);
            g.drawLine(300, 300, 250, 110); //p3 to p2
            g.setColor(Color.RED);
            g.drawString("50", 270, 200);
            graph.addArch(v3, v2, 50);

            g.setColor(Color.WHITE);
            g.drawLine(250, 110, 80, 300); // p2 to p5
            g.setColor(Color.RED);
            g.drawString("20", 160, 200);
            graph.addArch(v2, v5, 20);

            g.setColor(Color.WHITE);
            g.drawLine(300, 300, 70, 50); //p3 to p6
            g.setColor(Color.RED);
            g.drawString("60", 160, 150);
            graph.addArch(v3, v6, 60);

            g.setColor(Color.WHITE);
            g.drawLine(70, 50, 80, 300); //p6 to p5
            g.setColor(Color.RED);
            g.drawString("45", 60, 180);
            graph.addArch(v6, v5, 45);

            g.setColor(Color.WHITE);
            g.drawLine(80, 300, 300, 300); // p5 to p3
            g.setColor(Color.RED);
            g.drawString("55", 180, 300);
            graph.addArch(v5, v3, 55);

            g.setColor(Color.WHITE);
            g.drawLine(450, 150, 70, 50); // p4 to p6
            g.setColor(Color.RED);
            g.drawString("10", 280, 100);
            graph.addArch(v4, v6, 10);

            g.setColor(Color.WHITE);
            g.drawLine(250, 110, 70, 50); // p2 to p6
            g.setColor(Color.RED);
            g.drawString("70", 180, 100);
            graph.addArch(v2, v6, 70);

            g.setColor(Color.WHITE);
            g.drawLine(300, 300, 450, 150); // p3 to p4
            g.setColor(Color.RED);
            g.drawString("65", 370, 220);
            graph.addArch(v3, v4, 65);

            // total vertices
            jLabel2.setText(String.valueOf(graph.Vertices() - 2));  
            g.dispose();
            return;

        } else if (checkbox2.getState() == true) {
            this.DrawPanel.removeAll();

            //Desenha NODOS
            g.drawOval(200 - raio, 250 - raio, 20, 20);
            g.setColor(Color.BLUE);
            g.drawString("p1", 200 - raio, 250 - raio);
            g.setColor(Color.BLUE);
            g.fillOval(200 - raio, 250 - raio, 20, 20);

            g.drawOval(250 - raio, 110 - raio, 20, 20);
            g.drawString("p2", 250 - raio, 110 - raio);
            g.setColor(Color.BLUE);
            g.fillOval(250 - raio, 110 - raio, 20, 20);

            g.drawOval(300 - raio, 300 - raio, 20, 20);
            g.drawString("p3", 300 - raio, 300 - raio);
            g.setColor(Color.BLUE);
            g.fillOval(300 - raio, 300 - raio, 20, 20);


            g.drawOval(450 - raio, 150 - raio, 20, 20);
            g.drawString("p4", 450 - raio, 150 - raio);
            g.setColor(Color.BLUE);
            g.fillOval(450 - raio, 150 - raio, 20, 20);

            g.drawOval(80 - raio, 300 - raio, 20, 20);
            g.drawString("p5", 80 - raio, 300 - raio);
            g.setColor(Color.BLUE);
            g.fillOval(80 - raio, 300 - raio, 20, 20);

            g.drawOval(70 - raio, 50 - raio, 20, 20);
            g.drawString("p6", 70 - raio, 50 - raio);
            g.setColor(Color.BLUE);
            g.fillOval(70 - raio, 50 - raio, 20, 20);

            g.drawOval(460 - raio, 380 - raio, 20, 20);
            g.drawString("p7", 460 - raio, 380 - raio);
            g.setColor(Color.BLUE);
            g.fillOval(460 - raio, 380 - raio, 20, 20);

            g.setColor(Color.WHITE);
            g.drawLine(200, 250, 250, 110); // p1 to p2
            g.setColor(Color.DARK_GRAY);
            g.drawString("30", 210, 200);
            graph.addArch(v1, v2, 30);

            g.setColor(Color.WHITE);
            g.drawLine(200, 250, 300, 300); //p1 to p3
            g.setColor(Color.DARK_GRAY);
            g.drawString("40", 240, 280);
            graph.addArch(v1, v3, 40);

            g.setColor(Color.WHITE);
            g.drawLine(300, 300, 250, 110); //p3 to p2
            g.setColor(Color.DARK_GRAY);
            g.drawString("50", 270, 200);
            graph.addArch(v3, v2, 50);

            g.setColor(Color.WHITE);
            g.drawLine(250, 110, 80, 300); // p2 to p5
            g.setColor(Color.DARK_GRAY);
            g.drawString("20", 160, 200);
            graph.addArch(v2, v5, 20);

            g.setColor(Color.WHITE);
            g.drawLine(300, 300, 70, 50); //p3 to p6
            g.setColor(Color.DARK_GRAY);
            g.drawString("60", 160, 150);
            graph.addArch(v3, v6, 60);

            g.setColor(Color.WHITE);
            g.drawLine(70, 50, 80, 300); //p6 to p5
            g.setColor(Color.DARK_GRAY);
            g.drawString("45", 60, 180);
            graph.addArch(v6, v5, 45);

            g.setColor(Color.WHITE);
            g.drawLine(80, 300, 300, 300); // p5 to p3
            g.setColor(Color.DARK_GRAY);
            g.drawString("55", 180, 300);
            graph.addArch(v5, v3, 55);

            g.setColor(Color.WHITE);
            g.drawLine(450, 150, 70, 50); // p4 to p6
            g.setColor(Color.DARK_GRAY);
            g.drawString("10", 280, 100);
            graph.addArch(v4, v6, 10);

            g.setColor(Color.WHITE);
            g.drawLine(250, 110, 70, 50); // p2 to p6
            g.setColor(Color.DARK_GRAY);
            g.drawString("70", 180, 100);
            graph.addArch(v2, v6, 70);

            g.setColor(Color.WHITE);
            g.drawLine(300, 300, 450, 150); // p3 to p4
            g.setColor(Color.DARK_GRAY);
            g.drawString("65", 370, 220);
            graph.addArch(v3, v4, 65);

            g.setColor(Color.WHITE);
            g.drawLine(450, 150, 460, 380); // p4 to p7
            g.setColor(Color.DARK_GRAY);
            g.drawString("50", 455, 260);
            graph.addArch(v4, v7, 50);

            g.setColor(Color.WHITE);
            g.drawLine(460, 380, 300, 300); // p7 to p3
            g.setColor(Color.DARK_GRAY);
            g.drawString("80", 360, 339);
            graph.addArch(v7, v3, 80);

            jLabel2.setText(String.valueOf(graph.Vertices() - 1));  //mostra o total de Vertices
            g.dispose();
            return;

        } else if (checkbox3.getState() == true) {
            this.DrawPanel.removeAll();

            //Desenha NODOS
            g.drawOval(200 - raio, 250 - raio, 20, 20);
            g.setColor(Color.BLUE);
            g.drawString("p1", 200 - raio, 250 - raio);
            g.setColor(Color.BLUE);
            g.fillOval(200 - raio, 250 - raio, 20, 20);

            g.drawOval(250 - raio, 110 - raio, 20, 20);
            g.drawString("p2", 250 - raio, 110 - raio);
            g.setColor(Color.BLUE);
            g.fillOval(250 - raio, 110 - raio, 20, 20);

            g.drawOval(300 - raio, 300 - raio, 20, 20);
            g.drawString("p3", 300 - raio, 300 - raio);
            g.setColor(Color.BLUE);
            g.fillOval(300 - raio, 300 - raio, 20, 20);


            g.drawOval(450 - raio, 150 - raio, 20, 20);
            g.drawString("p4", 450 - raio, 150 - raio);
            g.setColor(Color.BLUE);
            g.fillOval(450 - raio, 150 - raio, 20, 20);

            g.drawOval(80 - raio, 300 - raio, 20, 20);
            g.drawString("p5", 80 - raio, 300 - raio);
            g.setColor(Color.BLUE);
            g.fillOval(80 - raio, 300 - raio, 20, 20);

            g.drawOval(70 - raio, 50 - raio, 20, 20);
            g.drawString("p6", 70 - raio, 50 - raio);
            g.setColor(Color.BLUE);
            g.fillOval(70 - raio, 50 - raio, 20, 20);

            g.drawOval(460 - raio, 380 - raio, 20, 20);
            g.drawString("p7", 460 - raio, 380 - raio);
            g.setColor(Color.BLUE);
            g.fillOval(460 - raio, 380 - raio, 20, 20);

            g.drawOval(460 - raio, 80 - raio, 20, 20);
            g.drawString("p8", 460 - raio, 80 - raio);
            g.setColor(Color.BLUE);
            g.fillOval(460 - raio, 80 - raio, 20, 20);

            g.setColor(Color.WHITE);
            g.drawLine(200, 250, 250, 110); // p1 to p2
            g.setColor(Color.RED);
            g.drawString("30", 210, 200);
            graph.addArch(v1, v2, 30);

            g.setColor(Color.WHITE);
            g.drawLine(200, 250, 300, 300); //p1 to p3
            g.setColor(Color.RED);
            g.drawString("40", 240, 280);
            graph.addArch(v1, v3, 40);

            g.setColor(Color.WHITE);
            g.drawLine(300, 300, 250, 110); //p3 to p2
            g.setColor(Color.RED);
            g.drawString("50", 270, 200);
            graph.addArch(v3, v2, 50);

            g.setColor(Color.WHITE);
            g.drawLine(250, 110, 80, 300); // p2 to p5
            g.setColor(Color.RED);
            g.drawString("20", 160, 200);
            graph.addArch(v2, v5, 20);

            g.setColor(Color.WHITE);
            g.drawLine(300, 300, 70, 50); //p3 to p6
            g.setColor(Color.RED);
            g.drawString("60", 160, 150);
            graph.addArch(v3, v6, 60);

            g.setColor(Color.WHITE);
            g.drawLine(70, 50, 80, 300); //p6 to p5
            g.setColor(Color.RED);
            g.drawString("45", 60, 180);
            graph.addArch(v6, v5, 45);

            g.setColor(Color.WHITE);
            g.drawLine(80, 300, 300, 300); // p5 to p3
            g.setColor(Color.RED);
            g.drawString("55", 180, 300);
            graph.addArch(v5, v3, 55);

            g.setColor(Color.WHITE);
            g.drawLine(450, 150, 70, 50); // p4 to p6
            g.setColor(Color.RED);
            g.drawString("10", 280, 100);
            graph.addArch(v4, v6, 10);

            g.setColor(Color.WHITE);
            g.drawLine(250, 110, 70, 50); // p2 to p6
            g.setColor(Color.RED);
            g.drawString("70", 180, 100);
            graph.addArch(v2, v6, 70);

            g.setColor(Color.WHITE);
            g.drawLine(300, 300, 450, 150); // p3 to p4
            g.setColor(Color.RED);
            g.drawString("65", 370, 220);
            graph.addArch(v3, v4, 65);

            g.setColor(Color.WHITE);
            g.drawLine(450, 150, 460, 380); // p4 to p7
            g.setColor(Color.RED);
            g.drawString("50", 455, 260);
            graph.addArch(v4, v7, 50);

            g.setColor(Color.WHITE);
            g.drawLine(460, 380, 300, 300); // p7 to p3
            g.setColor(Color.RED);
            g.drawString("80", 360, 339);
            graph.addArch(v7, v3, 80);

            g.setColor(Color.WHITE);
            g.drawLine(460, 380, 250, 110); // p7 to p2
            g.setColor(Color.RED);
            g.drawString("50", 340, 240);
            graph.addArch(v7, v2, 50);

            g.setColor(Color.WHITE);
            g.drawLine(460, 380, 460, 80); // p7 to p8
            g.setColor(Color.RED);
            g.drawString("25", 460, 200);
            graph.addArch(v7, v8, 25);

            g.setColor(Color.WHITE);
            g.drawLine(460, 80, 450, 150); // p8 to p4
            g.setColor(Color.RED);
            g.drawString("80", 450, 120);
            graph.addArch(v8, v4, 80);

            g.setColor(Color.WHITE);
            g.drawLine(460, 80, 80, 300); // p8 to p5
            g.setColor(Color.RED);
            g.drawString("30", 250, 200);
            graph.addArch(v8, v5, 30);

            g.setColor(Color.WHITE);
            g.drawLine(460, 80, 460, 380); // p8 to p7
            g.setColor(Color.RED);
            g.drawString("20", 460, 200);
            graph.addArch(v8, v7, 20);

            jLabel2.setText(String.valueOf(graph.Vertices()));  //mostra o total de Vertices
            g.dispose();
            return;

        }
    }//GEN-LAST:event_DrawPanelComponentShown

    private void jMenuDijkstraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuDijkstraActionPerformed

        if (checkbox1.getState() == true) {
            return;
        } else if (checkbox2.getState() == true) {
            return;
        } else if (checkbox3.getState() == true) {
            return;
        } else if (checkbox3.getState() == true) {
            graph.dijkstra(1);
            return;
        }

    }//GEN-LAST:event_jMenuDijkstraActionPerformed

    private void JMenuSaveTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMenuSaveTextoActionPerformed
        fc = new JFileChooser();
        int option = fc.showSaveDialog(this);

        if (option == JFileChooser.APPROVE_OPTION) {
            try {
                f = fc.getSelectedFile();
                fwr = new FileWriter(f);
                PrintWriter prt = new PrintWriter(fwr);
                prt.print(this.jTextArea1.getText());
                prt.close();
                this.jTextArea1.setText(null);
            } catch (IOException ex) {
                Logger.getLogger(FrameGraph.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_JMenuSaveTextoActionPerformed

    private void JMenuSaveBinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMenuSaveBinActionPerformed
        fc = new JFileChooser();
        int option = fc.showSaveDialog(this);

        if (option == JFileChooser.APPROVE_OPTION) {
            try {
                f = fc.getSelectedFile();
                fwr = new FileWriter(f);
                PrintWriter prt = new PrintWriter(fwr);
                graph.save2bin(fc.getSelectedFile());
                prt.print(this.jTextArea1.getText());
                prt.close();
                this.jTextArea1.setText(null);
            } catch (IOException ex) {
                Logger.getLogger(FrameGraph.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_JMenuSaveBinActionPerformed

    private void JtabuleiroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtabuleiroMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_JtabuleiroMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FrameGraph().setLocationRelativeTo(null);

            }
        });


    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DrawPanel;
    private javax.swing.JMenuItem JMenuExit;
    private javax.swing.JMenu JMenuFicheiro;
    private javax.swing.JMenu JMenuGrafo;
    private javax.swing.JMenu JMenuSave;
    private javax.swing.JMenuItem JMenuSaveBin;
    private javax.swing.JMenuItem JMenuSaveTexto;
    private javax.swing.JButton Jtabuleiro;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnVoltar;
    private java.awt.Checkbox checkbox1;
    private java.awt.Checkbox checkbox2;
    private java.awt.Checkbox checkbox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuDijkstra;
    private javax.swing.JMenuItem jMenuHops;
    private javax.swing.JMenuItem jMenuISHORTEST_PATH;
    private javax.swing.JMenuItem jMenuOpenFile;
    private javax.swing.JMenuItem jMenuVerificarGrafo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        int width = this.DrawPanel.getWidth();
        int height = this.DrawPanel.getHeight();

        //Cria a imagem novamente
        if (this.ScreenImg == null) {
            this.ScreenImg = this.createImage(width, height);
            System.out.println("img = " + this.ScreenImg.getWidth(this) + ", " + this.ScreenImg.getHeight(this));
        }
        Graphics ScreenImgGraphics = DrawPanel.getGraphics();
        ScreenImgGraphics.setColor(this.DrawPanel.getBackground());
        this.DrawPanel.setBorder(BorderFactory.createLineBorder(Color.black));
//        //ScreenImgGraphics.fillRect(0, 0, width, height);
//        //dc.drawCirculos(ScreenImgGraphics);
//        g.drawImage(ScreenImg, 0, 0, null);
    }

    void addTxtArea(String element) {
        this.jTextArea1.setText(this.jTextArea1.getText() + " " + element);
    }

}
