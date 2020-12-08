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
		// В данной модели два столбца
		return 3;
	}

	public int getRowCount() {
		// Вычислить количество точек между началом и концом отрезка
		// исходя из шага табулирования
		return new Double(Math.ceil((to - from) / step)).intValue() + 1;
	}

	public Object getValueAt(int row, int col) {
		// Вычислить значение X как НАЧАЛО_ОТРЕЗКА + ШАГ*НОМЕР_СТРОКИ
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
			// Название 1-го столбца
			return "Значение X";
		case 1:
			// Название 2-го столбца
			return "Значение многочлена";
		default:
			// Название 3-го столбца
			return "Малое число?";
		}
	}

	public Class<?> getColumnClass(int col) {
		// И в 1-ом и во 2-ом столбце находятся значения типа Double
		switch (col) {
		case 0:
			// тип 1-го столбца
			return Double.class;
		case 1:
			// тип 2-го столбца
			return Double.class;
		default:
			// тип 3-го столбца
			return Boolean.class;
		}
	}
}
