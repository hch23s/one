import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class TestButtons {
	JFrame frame = new JFrame("提醒");
	JButton jButton = new JButton("开始运行"); // 按钮
	JCheckBox checkBox = new JCheckBox("早上提醒"); // 复选按钮
	JCheckBox checkBox1 = new JCheckBox("晚上提醒"); // 复选按钮
	JLabel label = new JLabel("Ready to run."); // 静态文本
	// 构造函数

	public TestButtons() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new java.awt.FlowLayout());
		// 为按钮添加动作监听器
		jButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				// 按钮事件处理程序
				label.setText("Thread keep running.");
				int i = Timetorun() * 1000;
				try {
					Thread.sleep(i);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				JFrame parent = new JFrame();
				JOptionPane.showMessageDialog(parent, "该干啥了。");
			}
		});
		// 早上提醒 复选框处理程序
		checkBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				JCheckBox cb = (JCheckBox) e.getSource();
				label.setText("Selected Check Box is " + cb.isSelected());
			}
		});
		// 晚上提醒 复选框处理程序
		checkBox1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				JCheckBox cb = (JCheckBox) e.getSource();
				label.setText("Selected Check Box is " + cb.isSelected());
			}
		});
		// 添加组件到容器
		frame.getContentPane().add(jButton);
		frame.getContentPane().add(checkBox);
		frame.getContentPane().add(checkBox1);
		frame.getContentPane().add(label);
		frame.setSize(200, 250);
	}

	public void show() {
		frame.show();
	}

	// 主处理函数
	public static void main(String[] args) {
		TestButtons tb = new TestButtons();
		tb.show();
	}

	// 时间处理函数
	public static int Timetorun() {
		// 获取系统当前时间
		Calendar cal = Calendar.getInstance();
		int nowhour = cal.get(Calendar.HOUR_OF_DAY);
		int nowminite = cal.get(Calendar.MINUTE);
		int nowweek = cal.get(Calendar.DAY_OF_WEEK);
		System.out.println(nowhour + "");
		System.out.println(nowminite + "");
		System.out.println(nowweek + "");
		int dehour = 0;
		int deminite = 0;
		// 获取延迟时间
		if (nowweek == 2 || nowweek == 3 || nowweek == 5) {
			if (nowminite <= 30 && nowhour <= 20) {
				deminite = 30 - nowminite;
				dehour = 20 - nowhour;
			} else if (nowminite > 30 && nowhour <= 20) {
				deminite = 90 - nowminite;
				dehour = 19 - nowhour;
			} else if (nowminite <= 30 && nowhour > 20) {
				deminite = 30 - nowminite;
				dehour = 44 - nowhour;
			} else {
				deminite = 90 - nowminite;
				dehour = 43 - nowhour;
			}
		} else if (nowweek == 4 || nowweek == 6 || nowweek == 7 || nowweek == 1) {
			if (nowminite <= 30 && nowhour <= 17) {
				deminite = 30 - nowminite;
				dehour = 17 - nowhour;
			} else if (nowminite > 30 && nowhour <= 17) {
				deminite = 90 - nowminite;
				dehour = 16 - nowhour;
			} else if (nowminite <= 30 && nowhour > 17) {
				deminite = 30 - nowminite;
				dehour = 41 - nowhour;
			} else {
				deminite = 90 - nowminite;
				dehour = 40 - nowhour;
			}
		}
		// 延迟时间为K分钟
		int k = dehour * 60 + deminite;
		return k;
	}
}