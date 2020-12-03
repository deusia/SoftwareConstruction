package sc.ch7;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.sun.org.apache.xml.internal.security.Init;

import sc.ch3.Exercise;
import sc.ch4.Answer;

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
	private JButton preButton,nextButton;//翻页按钮
	private JLabel pageIndex;//显示第几页
	
	private int equationCount;//算式数量
	private int pages,currentPage;//页数及当前页数
	
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
	private void init(){
		JMenuBar menuBar=new JMenuBar();//初始化菜单栏
		setJMenuBar(menuBar);//设置当前JFrame的菜单栏为menuBar
		/*****************以下是在线习题的菜单构造******************/
		JMenu menuOnline=new JMenu("在线练习");//初始化“在线练习”的菜单
		menuBar.add(menuOnline);

		//下面是加法菜单项
		JMenuItem onlineAdd = new JMenuItem("加法");
		menuOnline.add(onlineAdd);
		onlineAdd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				online(arg0);//自定义响应方法
			}
		});
		//下面是减法菜单项
		JMenuItem onlineSub = new JMenuItem("减法");
		menuOnline.add(onlineSub);
		onlineSub.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				online(arg0);//自定义响应方法
			}
		});
		//下面是混合菜单项
		JMenuItem onlineMix = new JMenuItem("混合");
		menuOnline.add(onlineMix);
		onlineMix.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				online(arg0);//自定义响应方法
			}
		});
		/*****************以下是批量习题的菜单构造******************/
		JMenu menuOutline=new JMenu("批量习题");//初始化“批量习题”的菜单
		menuBar.add(menuOutline);
		//下面是加法菜单项
		JMenuItem outlineAdd = new JMenuItem("加法");
		menuOutline.add(outlineAdd);
		outlineAdd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				outline(arg0);//自定义响应方法
			}
		});
		//下面是减法菜单项
		JMenuItem outlineSub = new JMenuItem("减法");
		menuOutline.add(outlineSub);
		outlineSub.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				outline(arg0);//自定义响应方法
			}
		});
		//下面是混合菜单项
		JMenuItem outlineMix = new JMenuItem("混合");
		menuOutline.add(outlineMix);
		outlineMix.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				outline(arg0);//自定义响应方法
			}
		});
		
		/*****************以下是批改习题的菜单构造******************/
		JMenu menuCheck=new JMenu("批改习题");//初始化“批改习题”的菜单
		menuBar.add(menuCheck);
		JMenuItem judge =new JMenuItem("批改习题");
		menuCheck.add(judge);
		outlineMix.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				checkEx(arg0);
			}
		});
		/*****************以下是退出的菜单构造******************/
		JMenu menuExit=new JMenu("退出");//初始化“退出”的菜单
		menuBar.add(menuExit);
		JMenuItem exit =new JMenuItem("退出");
		menuExit.add(exit);
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				System.exit(0);
			}
		});
		
		
		/**********以下是答题区面板的构造*****************/
		panelCenter =new JPanel();//答题面板
		panelSouth =new JPanel();//批改面板
		
		FlowLayout flowLayout=(FlowLayout)panelSouth.getLayout();//批改面板的南区的布局管理器
		flowLayout.setAlignment(FlowLayout.LEFT);//设置居左对齐
		
		contentPane.add(BorderLayout.CENTER,panelCenter);
		contentPane.add(BorderLayout.SOUTH,panelSouth);//把两个面板加入到框架中
	}
	
	
	
	
	
	
	
	
	
	
	
}
