package bsu.rfe.java.group9.lab3.Lipskiy.var14;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class GornerTableModel extends AbstractTableModel {

	private Double[] coefficients;
	private Double from;
	private Double to;
	private Double step;
	private double result[] = new double[3];

	public GornerTableModel(Double from, Double to, Double step, Double[] coefficients) {
		this.from = from; 
		this.to = to;
		this.step = step;
		this.coefficients = coefficients;
	}

	public Double getFrom() {
		return from;
	}

	public Double getTo() { 
		return to;
	}

	public Double getStep() {
		return step;
	}

	public int getColumnCount() {
		// � ������ ������ ��� �������
		return 3;
	}

	public int getRowCount() {
		// ��������� ���������� ����� ����� ������� � ������ �������
		// ������ �� ���� �������������
		return new Double(Math.ceil((to - from) / step)).intValue() + 1;
	}

	public Object getValueAt(int row, int col) {
		// ��������� �������� X ��� ������_������� + ���*�����_������
		double x = from + step * row;
		switch (col){
		case 0:
			return x;
		case 1:
		{
			result[0] = 0.0;
			for(int i = 0; i < coefficients.length; i++){
				result[0] += Math.pow(x, coefficients.length-1-i)*coefficients[i];
				}
			return result[0];
			}
		default:
			if((int)result[0]==0)
				return true;
			else return false;
			}
	}

	public String getColumnName(int col) {
		switch (col) {
		case 0:
			// �������� 1-�� �������
			return "�������� X";
		case 1:
			// �������� 2-�� �������
			return "�������� ����������";
		default:
			// �������� 3-�� �������
			return "����� �����?";
		}
	}

	public Class<?> getColumnClass(int col) {
		// � � 1-�� � �� 2-�� ������� ��������� �������� ���� Double
		switch (col) {
		case 0:
			// ��� 1-�� �������
			return Double.class;
		case 1:
			// ��� 2-�� �������
			return Double.class;
		default:
			// ��� 3-�� �������
			return Boolean.class;
		}
	}
}
