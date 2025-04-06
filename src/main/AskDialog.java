package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class AskDialog extends JFrame implements MouseListener {
	public interface AskDialogInterface {
		public void clickedOnSong(String song, String folder, AskDialog dialog);
	}

	private JPanel contentPane;
	private JTable table;
	private AskDialogInterface mCallback;
	String lastValue = "";
	String cName1Folder, cName2Folder, cName3Folder;

	public AskDialog(String cName1, String cName2, String cName3,
			String cName1Folder, String cName2Folder, String cName3Folder,
			String[] col1, String[] col2, String[] col3,
			AskDialogInterface mCallback) {
		this.cName1Folder = cName1Folder;
		this.cName2Folder = cName2Folder;
		this.cName3Folder = cName3Folder;
		this.mCallback = mCallback;
		loadComponents();
		if (col1 != null)
			table.setModel(new MyAdapter(cName1, cName2, cName3, col1, col2,
					col3));
		setBounds(100, 100, 600, 400);
		setMinimumSize(new Dimension(600, 400));
	}

	public void loadComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setMinimumSize(new Dimension(600, 400));
		contentPane.setBounds(0, 0, 600, 400);

		table = new JTable();
		table.setCellSelectionEnabled(true);
		table.getTableHeader().setReorderingAllowed(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.addMouseListener(this);
		JScrollPane scrollPane = new JScrollPane(table);
		contentPane.add(scrollPane, BorderLayout.CENTER);

		pack();
		setVisible(true);
	}

	class MyAdapter extends AbstractTableModel {
		ArrayList<String[]> values = new ArrayList<String[]>();
		String cName1, cName2, cName3;

		public MyAdapter(String cName1, String cName2, String cName3,
				String[] col1, String[] col2, String[] col3) {
			this.cName1 = cName1;
			this.cName2 = cName2;
			this.cName3 = cName3;
			values.add(col1);
			values.add(col2);
			values.add(col3);
		}

		@Override
		public int getColumnCount() {
			return 3;
		}

		@Override
		public int getRowCount() {
			int length = values.get(0).length;
			if (values.get(1) != null && values.get(1).length > length)
				length = values.get(1).length;
			if (values.get(2) != null && values.get(2).length > length)
				length = values.get(2).length;
			return length;
		}

		@Override
		public String getColumnName(int col) {
			switch (col) {
			case 0:
				return cName1;
			case 1:
				return cName2;
			case 2:
				return cName3;
			default:
				return "null";
			}
		}

		@Override
		public Object getValueAt(int rowIndex, int colIndex) {
			if (values.get(colIndex) != null
					&& values.get(colIndex).length > rowIndex)
				return values.get(colIndex)[rowIndex];
			return "";
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.rowAtPoint(e.getPoint());
		int col = table.columnAtPoint(e.getPoint());
		String folderName = "";
		switch (col) {
		case 0:
			folderName = cName1Folder;
			break;
		case 1:
			folderName = cName2Folder;
			break;
		case 2:
			folderName = cName3Folder;
			break;
		}
		MyAdapter adapter = (MyAdapter) table.getModel();
		String v = (String) adapter.getValueAt(row, col);
		if (!v.equals(lastValue)) {
			if (v.length() != 0) {
				lastValue = v;
				mCallback.clickedOnSong(v, folderName, this);
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}
}