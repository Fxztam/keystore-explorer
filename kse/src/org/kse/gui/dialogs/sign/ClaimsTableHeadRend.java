package org.kse.gui.dialogs.sign;

import java.awt.Component;
import java.util.ResourceBundle;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
 * 
 * Custom cell renderer for the headers of list custom claims.
 */

public class ClaimsTableHeadRend extends DefaultTableCellRenderer {
	private static final long serialVersionUID = 1L;

	private static ResourceBundle res = ResourceBundle.getBundle("org/kse/gui/dialogs/sign/resources");

	private TableCellRenderer delegate;

	/**
	 * Construct a new RevokedCertsTableHeadRend.
	 * 
	 * @param delegate
	 */
	public ClaimsTableHeadRend(TableCellRenderer delegate) {
		this.delegate = delegate;
	}

	/**
	 * Returns the rendered header cell for the supplied value and column.
	 *
	 * @param jTable     The JTable
	 * @param value      The value to assign to the cell
	 * @param isSelected True if cell is selected
	 * @param hasFocus   If true, render cell appropriately
	 * @param row        The row of the cell to render
	 * @param col        The column of the cell to render
	 * @return The renderered cell
	 */
	@Override
	public Component getTableCellRendererComponent(JTable jTable, Object value, boolean isSelected, boolean hasFocus,
			int row, int col) {

		Component c = delegate.getTableCellRendererComponent(jTable, value, isSelected, hasFocus, row, col);

		if (c instanceof JLabel) {
			JLabel header = (JLabel) c;

			if (col == 0) {
				header.setToolTipText(res.getString("ClaimsTableHeadRend.NameColumn.tooltip"));
			} else {
				header.setToolTipText(res.getString("ClaimsTableHeadRend.ValueColumn.tooltip"));
			}
		}

		return c;
	}
}
