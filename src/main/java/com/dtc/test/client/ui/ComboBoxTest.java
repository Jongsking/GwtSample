package com.dtc.test.client.ui;


import java.util.Arrays;

import com.dtc.test.shared.vo.ComboBoxBean;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.Composite;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
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
	
	@UiHandler("save")
	void saveAction(SelectEvent e){
		save();
	}
	public void edit(){
		ComboBoxBean editor = new ComboBoxBean();
		comboBox.add(Arrays.asList("Label","Panel","ComboBox"));
		driver.edit(editor);
	}
	
	public void save(){
		ComboBoxBean edited = driver.flush();
		if (driver.hasErrors()) {
		}
		GWT.log(edited.getComboBox());
	}
	
}
