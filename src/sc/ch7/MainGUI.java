package sc.ch7;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import sc.ch3.Exercise;
import sc.ch4.Answer;
import sc.ch4.Check;


public class MainGUI extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 692918854249358286L;
    private JPanel contentPane;
    private JPanel panelCenter;
    private JPanel panelSouth;
    private JTextField tEquation[];//显示算式
    private JTextField tAnswer[];//输入算式答案
    private JButton preButton, nextButton;//翻页按钮
    private JLabel pageIndex;//显示第几页

    private int equationCount;//算式数量
    private int pages, currentPage;//页数及当前页数

    private Exercise exercise;
    private Answer answer;
    private JButton check;//批改按钮
    private JLabel labelResult;//显示批改结果

    private final int PASE_SIZE = 20;//每页显示20到算数

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainGUI frame = new MainGUI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public MainGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 580, 280);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        setResizable(false);//设置窗口大小不能改变
        init();//自定义的初始化方法
    }

    private void init() {
        JMenuBar menuBar = new JMenuBar();//初始化菜单栏
        setJMenuBar(menuBar);//设置当前JFrame的菜单栏为menuBar
        /*****************以下是在线习题的菜单构造******************/
        JMenu menuOnline = new JMenu("在线练习");//初始化“在线练习”的菜单
        menuBar.add(menuOnline);

        //下面是加法菜单项
        JMenuItem onlineAdd = new JMenuItem("加法");
        onlineAdd.setActionCommand("onlineAdd");
        menuOnline.add(onlineAdd);
        onlineAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                online(arg0);//自定义响应方法
            }
        });
        //下面是减法菜单项
        JMenuItem onlineSub = new JMenuItem("减法");
        onlineSub.setActionCommand("onlineSub");
        menuOnline.add(onlineSub);
        onlineSub.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                online(arg0);//自定义响应方法
            }
        });
        //下面是混合菜单项
        JMenuItem onlineMix = new JMenuItem("混合");
        onlineMix.setActionCommand("onlineMix");
        menuOnline.add(onlineMix);
        onlineMix.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                online(arg0);//自定义响应方法
            }
        });
        /*****************以下是批量习题的菜单构造******************/
        JMenu menuOutline = new JMenu("批量习题");//初始化“批量习题”的菜单
        menuBar.add(menuOutline);
        //下面是加法菜单项
        JMenuItem outlineAdd = new JMenuItem("加法");
        outlineAdd.setActionCommand("outlineAdd");
        menuOutline.add(outlineAdd);
        outlineAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                outline(arg0);//自定义响应方法
            }
        });
        //下面是减法菜单项
        JMenuItem outlineSub = new JMenuItem("减法");
        outlineSub.setActionCommand("outlineSub");
        menuOutline.add(outlineSub);
        outlineSub.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                outline(arg0);//自定义响应方法
            }
        });
        //下面是混合菜单项
        JMenuItem outlineMix = new JMenuItem("混合");
        outlineMix.setActionCommand("outlineMix");
        menuOutline.add(outlineMix);
        outlineMix.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                outline(arg0);//自定义响应方法
            }
        });

        /*****************以下是批改习题的菜单构造******************/
        JMenu menuCheck = new JMenu("批改习题");//初始化“批改习题”的菜单
        menuBar.add(menuCheck);
        JMenuItem judge = new JMenuItem("批改习题");
        menuCheck.add(judge);
        outlineMix.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                checkEx(arg0);
            }
        });
        /*****************以下是退出的菜单构造******************/
        JMenu menuExit = new JMenu("退出");//初始化“退出”的菜单
        menuBar.add(menuExit);
        JMenuItem exit = new JMenuItem("退出");
        menuExit.add(exit);
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }
        });


        /**********以下是答题区面板的构造*****************/
        panelCenter = new JPanel();//答题面板
        panelSouth = new JPanel();//批改面板
        int PAGE_SIZE = 20;

        FlowLayout flowLayout = (FlowLayout) panelSouth.getLayout();//批改面板的南区的布局管理器
        flowLayout.setAlignment(FlowLayout.LEFT);//设置居左对齐

        contentPane.add(BorderLayout.CENTER, panelCenter);
        contentPane.add(BorderLayout.SOUTH, panelSouth);//把两个面板加入到框架中

        //初始化答题区
        tEquation = new JTextField[PAGE_SIZE];
        tAnswer = new JTextField[PAGE_SIZE];

        for (int i = 0; i < PASE_SIZE; i++) {
            tEquation[i] = new JTextField(5);//算式的文本框宽度为5
            tEquation[i].setHorizontalAlignment(JTextField.RIGHT);//算式居右对齐
            tEquation[i].setBackground(panelCenter.getBackground());
            tEquation[i].setBorder(null);
            tEquation[i].setEditable(false);

            tAnswer[i] = new JTextField(2);//答案的宽度设置为2
            panelCenter.add(tEquation[i]);
            panelCenter.add(tAnswer[i]);

            tEquation[i].setVisible(false);
            tAnswer[i].setVisible(false);
        }

        //实现翻页按钮"前一页"功能的构造
        preButton = new JButton("前一页");
        preButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prePage();//自定义的翻页方法

            }
        });
        //实现翻页按钮"后一页"功能的构造
        nextButton = new JButton("后一页");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextPage();//自定义的翻页方法

            }
        });

        panelCenter.add(preButton);
        pageIndex = new JLabel();
        panelCenter.add(pageIndex);
        panelCenter.add(nextButton);
        preButton.setVisible(false);
        nextButton.setVisible(false);

        //批改区
        check = new JButton("批改");
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                check();//自定义批改方法
            }
        });

        labelResult = new JLabel();//显示批改结果
        panelSouth.add(check);
        panelSouth.add(labelResult);
        check.setVisible(false);
        labelResult.setVisible(false);

    }

    public void online(ActionEvent arg0) {
        if (arg0.getActionCommand() == "onlineAdd") {
            equationCount = Integer.parseInt(JOptionPane.showInputDialog("请输入加法算式的数量"));
            exercise = new Exercise(equationCount);
            exercise.generateAddExercise();
        } else if (arg0.getActionCommand() == "onlineSub") {
            equationCount = Integer.parseInt(JOptionPane.showInputDialog("请输入减法算式的数量"));
            exercise = new Exercise(equationCount);
            exercise.generateSubExercise();
        } else if (arg0.getActionCommand() == "onlineMix") {
            equationCount = Integer.parseInt(JOptionPane.showInputDialog("请输入混合算式的数量"));
            exercise = new Exercise(equationCount);
            exercise.generateExercise();
        }

        answer = new Answer();
        for (int i = 0; i < equationCount; i++) {
            answer.add(-1);//答案初始化
        }

        pages = (int) Math.ceil(equationCount * 1.0 / PASE_SIZE);///12/5=2，12*1.0/5=2.4
        currentPage = 1;//初始化当前页码
        labelResult.setText("");//初始化的批改结果为空

        update();//自定义刷新图形界面的方法
    }

    public void outline(ActionEvent arg0) {

    }

    public void update() {
        //i表示算式在总共习题数量里面的序号；j表示当前页里面算式的编号；也表示JTextField图形组件
        for (int i = (currentPage - 1) * PASE_SIZE, j = 0; i < currentPage * PASE_SIZE; i++, j++) {
            if (i < equationCount) {
                tEquation[j].setText(exercise.get(i).toString2());
                tEquation[j].setBackground(panelCenter.getBackground());
                tEquation[j].setVisible(true);

                if (answer.get(i) != -1) {
                    tAnswer[j].setText(Integer.toString((answer.get(i))));
                } else {
                    tAnswer[j].setText("");
                }
                tAnswer[j].setVisible(true);
            } else {
                tEquation[j].setVisible(false);
                tAnswer[j].setVisible(false);
            }
        }
        //如果椰大于1，显示翻页按钮
        preButton.setVisible(pages > 1);
        nextButton.setVisible(pages > 1);
        preButton.setEnabled(currentPage > 1);//当前页码大于1的时候可以点击按钮前一页
        nextButton.setEnabled(currentPage < pages);//当前页码小雨总页数的时候可以点击后一页f
        pageIndex.setText(currentPage + "/" + pages);
        check.setVisible(true);
        labelResult.setVisible(true);
        if (currentPage == pages) {
            check.setEnabled(true);
        } else {
            check.setEnabled(false);
        }
    }

    public void prePage() {
        for (int i = (currentPage - 1) * PASE_SIZE, j = 0; i < currentPage * PASE_SIZE; i++, j++) {
            if (i < equationCount && tAnswer[j].getText() != null && tAnswer[j].getText().length() > 0) {
                if (tAnswer[j].getText().matches("^[0-9]*$")) {
                    answer.set(i, Integer.parseInt(tAnswer[j].getText()));
                }
            }
        }
        currentPage--;
        update();
    }

    public void nextPage() {
        for (int i = (currentPage - 1) * PASE_SIZE, j = 0; i < currentPage * PASE_SIZE; i++, j++) {
            if (i < equationCount && tAnswer[j].getText() != null && tAnswer[j].getText().length() > 0) {
                if (tAnswer[j].getText().matches("^[0-9]*$")) {
                    answer.set(i, Integer.parseInt(tAnswer[j].getText()));
                }
            }
        }
        currentPage++;
        update();
    }

    public void check() {
        for (int i = (currentPage - 1) * PASE_SIZE, j = 0; i < currentPage * PASE_SIZE && j < equationCount % PASE_SIZE; i++, j++) {
            if (i < equationCount && tAnswer[j].getText() != null && tAnswer[j].getText().length() > 0) {
                if (tAnswer[j].getText().matches("^[0-9]*$")) {
                    answer.set(i, Integer.parseInt(tAnswer[j].getText()));
                }
            }
        }
        Check ch = new Check();
        ch.check(exercise, answer);
        labelResult.setText("正确:" + ch.getRight() + ";错误:" + ch.getWrong());
        drawPieChart(ch);//自定义的饼图绘制方法
    }

    public void drawPieChart(Check check) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("正确:" + check.getRight(), check.getRight());
        dataset.setValue("错误:" + check.getWrong(), check.getWrong());
        JFreeChart chart = ChartFactory.createPieChart("批改统计", (PieDataset) dataset, false, false, false);
        PiePlot plot = (PiePlot) chart.getPlot();//饼图的每个片区数据
        chart.setBackgroundPaint(Color.white);//设置片区的背景色
        plot.setForegroundAlpha(1.0f);//设置片区的透明度
        plot.setCircular(true);
        plot.setLabelFont(new Font("宋体", Font.BOLD, 20));
        Font font = new Font("黑体", Font.CENTER_BASELINE, 20);
        TextTitle title = chart.getTitle();
        title.setFont(font);
        chart.setTitle(title);
        ChartPanel cPanel = new ChartPanel(chart);
        JFrame f = new JFrame();
        f.setBounds(300, 300, 300, 300);
        f.add(cPanel);
        f.setVisible(true);
    }

    public void checkEx(ActionEvent arg0) {

    }


}














