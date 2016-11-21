import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class frame extends JFrame{
	
	private final JButton _selectionButton;
	private final JButton _mergeButton;
	private JLabel _selectionSortLabel;
	private JLabel _mergeSortLabel;
	
	public frame(){
		super("Sort");
		setLayout(new GridLayout(2,2));
		_selectionSortLabel = new JLabel("");
		_selectionButton = new JButton("Selection Sort");
		_selectionButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				long startTime = System.nanoTime();
				ArrayList<Person> s = sort.selectionSort(sort.getFile());
				long endTime = System.nanoTime();
				long total = endTime - startTime;
				String sel = String.valueOf(total /1000000.0);
				boolean checkSort = sort.checkSorted(s);
				System.out.println(checkSort);
				if (checkSort == false){
					_selectionSortLabel.setText("Error");
				} else {
					_selectionSortLabel.setText(sel);
				}
			}
		});
		add(_selectionButton);
		add(_selectionSortLabel);
		_mergeSortLabel = new JLabel("");
		_mergeButton = new JButton("Merge Sort");
		_mergeButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				long startTime = System.nanoTime();
				ArrayList<Person> m = sort.mergeSort(sort.getFile());
				long endTime = System.nanoTime();
				long total = endTime - startTime;
				String merg = String.valueOf(total / 1000000.0);
				boolean checkMerge = sort.checkSorted(m);
				System.out.println(checkMerge);
				if (checkMerge == false){
					_mergeSortLabel.setText("Error");
				} else {
					_mergeSortLabel.setText(merg);
				}
			}
		});
		add(_mergeButton);
		add(_mergeSortLabel);
	}
}
