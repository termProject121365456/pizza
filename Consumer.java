package termProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Consumer {

	public Consumer() {
		// store information

		// GUI
		// TODO �θ� ������ ���� �� �⺻ ��Ÿ�� ���� �ǽ�
		JFrame frm = new JFrame("Order Pizza");
		setJFrameStyle(frm);

		// TODO �ڽ� ���̾ƿ� [���� �ֹ� ����] ���� �ǽ�
		JLabel food_txt = new JLabel("Pizza");
		food_txt.setBounds(0, 0, 100, 50); // TODO setBounds(������ġ, ������ġ, ���α���, ���α���);
		setJLabelStyle(food_txt);

		String food_arr[] = { "Pepperoni pizza", "Cheese pizza", "Bulgogi pizza", "Shrimp pizza" };
		String food_price[] = { "3000", "2000", "5000", "4000" };
		JComboBox<String> food_combo = new JComboBox<String>(food_arr);
		food_combo.setBounds(100, 0, 300, 50); // TODO setBounds(������ġ, ������ġ, ���α���, ���α���);
		setJComboBoxStyle(food_combo);

		JButton food_add_btn = new JButton("�����߰�");
		food_add_btn.setBounds(400, 0, 100, 50); // TODO setBounds(������ġ, ������ġ, ���α���, ���α���);
		setJButtonStyle(food_add_btn); // �⺻ ��ư ��Ÿ�� ���� �޼ҵ� ȣ��

		// TODO �ڽ� ���̾ƿ� [���� �ֹ� ����] ���� �ǽ�
		JLabel drink_txt = new JLabel("Drink");
		drink_txt.setBounds(0, 55, 100, 50); // TODO setBounds(������ġ, ������ġ, ���α���, ���α���);
		setJLabelStyle(drink_txt);

		String drink_arr[] = { "Cider", "Coke", "Fanta", "Beer" };
		String drink_price[] = { "800", "800", "800", "1000" };
		JComboBox<String> drink_combo = new JComboBox<String>(drink_arr);
		drink_combo.setBounds(100, 55, 300, 50); // TODO setBounds(������ġ, ������ġ, ���α���, ���α���);
		setJComboBoxStyle(drink_combo);

		JButton drink_add_btn = new JButton("�����߰�");
		drink_add_btn.setBounds(400, 55, 100, 50); // TODO setBounds(������ġ, ������ġ, ���α���, ���α���);
		setJButtonStyle(drink_add_btn); // �⺻ ��ư ��Ÿ�� ���� �޼ҵ� ȣ��

		// TODO �ڽ� ���̾ƿ� [���̺�] ����
		String tittleArray[] = { "Order list", "Price" };
		DefaultTableModel model = new DefaultTableModel(tittleArray, 0);
		JTable table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.getViewport().setBackground(Color.LIGHT_GRAY); // JScrollPane�� ���� ����
		scrollPane.setBounds(0, 110, 500, 285); // TODO setBounds(������ġ, ������ġ, ���α���, ���α���);
		ArrayList<String> pay_list = new ArrayList<String>(); // ���� �ݾ� ���� ����Ʈ ����

		// TODO �ڽ� ���̾ƿ� [���� �� ���� ��ư] ����
		JButton pay_btn = new JButton("����");
		setJButtonStyle(pay_btn); // �⺻ ��ư ��Ÿ�� ���� �޼ҵ� ȣ��

		JButton del_btn = new JButton("����");
		setJButtonStyle(del_btn); // �⺻ ��ư ��Ÿ�� ���� �޼ҵ� ȣ��

		JPanel btn_flow_panel = new JPanel();
		btn_flow_panel.setLayout(new FlowLayout()); // ��� �߽� ��ġ ���̾ƿ� (������â ũ�⸦ ����� �ڵ� �ٹٲ� �ǽ�)
		btn_flow_panel.add(pay_btn);
		btn_flow_panel.add(del_btn);
		btn_flow_panel.setBackground(Color.LIGHT_GRAY);
		btn_flow_panel.setBounds(0, 400, 500, 100); // setBounds(������ġ, ������ġ, ���α���, ���α���);

		// TODO �ڽ� ���̾ƿ� [��ư] Ŭ�� �̺�Ʈ ���� �ǽ�
		ActionListener action = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getActionCommand().equals("�����߰�")) { // ���� �߰� ��ư Ŭ���̺�Ʈ ó��
					// TODO �Էµ� �� ���̺��� �߰��ϱ�
					String info[] = new String[2]; // ���� (row) �� ������ ������ ����
					info[0] = food_combo.getSelectedItem().toString(); // �޺��ڽ� ���� �����´�
					int index = food_combo.getSelectedIndex();
					info[1] = food_price[index];
					model.addRow(info); // ���̺� �𵨿� ������ ���� �ǽ�
					pay_list.add(food_combo.getSelectedItem().toString()); // ���� �ݾ� ����Ʈ�� �߰�
				} else if (e.getActionCommand().equals("�����߰�")) { // ���� �߰� ��ư Ŭ���̺�Ʈ ó��
					// TODO �Էµ� �� ���̺��� �߰��ϱ�
					String info[] = new String[2]; // ���� (row) �� ������ ������ ����
					info[0] = drink_combo.getSelectedItem().toString(); // �޺��ڽ� ���� �����´�
					int index = drink_combo.getSelectedIndex();
					info[1] = drink_price[index];
					model.addRow(info); // ���̺� �𵨿� ������ ���� �ǽ�
					pay_list.add(drink_combo.getSelectedItem().toString()); // ���� �ݾ� ����Ʈ�� �߰�
				} else if (e.getActionCommand().equals("����")) { // ���� ��ư Ŭ���̺�Ʈ ó��
					/** TODO [���� �˸�â] */
					int qut_data = JOptionPane.showConfirmDialog(frm, "�ֹ��� �����Ͻðڽ��ϱ�??", "�ֹ�����",
							JOptionPane.YES_NO_CANCEL_OPTION);
					if (qut_data == 0) { // [��] ��ư

						JOptionPane.showMessageDialog(frm, "�����Ǿ����ϴ�." + "\n" + "[�ֹ�����]\n" + pay_list.toString());

						Order pizzaOrder = new Order(pay_list);
						Calculation sales = new Calculation(pay_list);

						// System.out.println(pay_list);
						pizzaOrder.orderMenu();

						sales.calculateSales();

						frm.setVisible(false);

					} else if (qut_data == 1) { // [�ƴϿ�] ��ư

					} else if (qut_data == 2) { // [���] ��ư

					}

				} else if (e.getActionCommand().equals("����")) { // ���� ��ư Ŭ���̺�Ʈ ó��
					// ������ ��(row)�� ��ȣ �˾Ƴ���
					int rowIndex = table.getSelectedRow();

					// ���� ���ϰ� ���� ��� ���ϰ� -1
					if (rowIndex == -1) {
						return;
					}
					model.removeRow(rowIndex); // �ش� ���̺� �� ����
					pay_list.remove(rowIndex); // ���� �ݾ� ����Ʈ������ ���� �ǽ�
				}
			}
		};
		food_add_btn.addActionListener(action);
		drink_add_btn.addActionListener(action);
		pay_btn.addActionListener(action);
		del_btn.addActionListener(action);

		// TODO �θ� �����ӿ��ٰ� �ڽ� ������Ʈ �߰�
		frm.getContentPane().add(food_txt);
		frm.getContentPane().add(food_combo);
		frm.getContentPane().add(food_add_btn);

		frm.getContentPane().add(drink_txt);
		frm.getContentPane().add(drink_combo);
		frm.getContentPane().add(drink_add_btn);

		frm.getContentPane().add(scrollPane, BorderLayout.CENTER);
		frm.getContentPane().add(btn_flow_panel);

		// TODO �θ� �������� ���̵��� ����
		frm.setVisible(true);

	}

	public static void setJFrameStyle(JFrame frame) {
		// TODO �θ� ������ ũ�� ���� (����, ����) �� ���� ����
		frame.setSize(500, 500);
		frame.setBackground(Color.BLACK);
		// TODO �θ� �������� ȭ�� ����� ��ġ
		frame.setLocationRelativeTo(null);
		// TODO �θ� �������� �ݾ��� �� �޸𸮿��� ���ŵǵ��� ����
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// TODO �θ� ������ â ũ�� ���� �ǽ�
		frame.setResizable(false);
		// TODO �θ� ���̾ƿ� ����
		frame.getContentPane().setLayout(null);
	}

	// TODO JLabel �⺻ ��Ÿ�� ���� �޼ҵ�
	public static void setJLabelStyle(JLabel txt) {
		txt.setOpaque(true); // TODO setBackground �����ϱ� ���� ���� ����
		txt.setBackground(Color.GRAY); // TODO ��׶��� ���� ����
		txt.setForeground(Color.WHITE); // TODO �ؽ�Ʈ ���� ����
		txt.setFont(new Font("���� ����", 0, 15)); // TODO ��Ʈ ����
		txt.setHorizontalAlignment(JLabel.CENTER); // TODO �ؽ�Ʈ ���� ǥ�� ����
	}

	// TODO JComboBox �⺻ ��Ÿ�� ���� �޼ҵ�
	public static void setJComboBoxStyle(JComboBox combo) {
		combo.setBackground(Color.LIGHT_GRAY); // TODO ��׶��� ���� ����
		combo.setForeground(Color.WHITE); // TODO �ؽ�Ʈ ���� ����
		combo.setFont(new Font("���� ����", 0, 15)); // TODO ��Ʈ ����
	}

	// TODO JButton �⺻ ��Ÿ�� ���� �޼ҵ�
	public static void setJButtonStyle(JButton btn) {
		btn.setBackground(Color.DARK_GRAY); // TODO ��׶��� ���� ����
		btn.setForeground(Color.WHITE); // TODO �ؽ�Ʈ ���� ����
		btn.setFont(new Font("���� ����", 0, 15)); // TODO ��Ʈ ����
		btn.setHorizontalAlignment(JLabel.CENTER); // TODO �ؽ�Ʈ ���� ǥ�� ����
	}
}