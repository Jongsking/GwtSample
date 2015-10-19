package com.dtc.test.client.ui;


import com.dtc.test.shared.vo.ComboBoxBean;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.Composite;
import com.sencha.gxt.widget.core.client.form.StringComboBox;

public class ComboBoxTest extends Composite implements Editor<ComboBoxBean>{

	interface Driver extends SimpleBeanEditorDriver<ComboBoxBean,ComboBoxTest> {}
	Driver driver = GWT.<Driver> create(Driver.class);
	
	private static ComboBoxTestUiBinder uiBinder = GWT.create(ComboBoxTestUiBinder.class);

	interface ComboBoxTestUiBinder extends UiBinder<Widget, ComboBoxTest> {
	}
	public ComboBoxTest() {
		initWidget(uiBinder.createAndBindUi(this));
		driver.initialize(this);
	}
	@UiField StringComboBox comboBox;
	
	public void edit(){
		ComboBoxBean edited = new ComboBoxBean();
		edited.setComboBox("ComboBox");
		driver.edit(edited);
	}
	
	public void save(){
		driver.flush();
		if (driver.hasErrors()) {
		}
	}
	
}
