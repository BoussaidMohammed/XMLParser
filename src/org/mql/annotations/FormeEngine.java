package org.mql.annotations;

import java.lang.reflect.Field;

import org.mql.components.Form;

public class FormeEngine {
	private Form form;
	
	public FormeEngine(Class<?> cls) {
		FormAnn fa = cls.getDeclaredAnnotation(FormAnn.class);
		
		if(fa != null) {
			System.out.println("ok");
			String title = fa.title();
			if(title.equals("")) title = cls.getSimpleName();
			form = new Form(title, fa.labelWidth(),fa.labelHeight());
			Field[] fields = cls.getDeclaredFields();
			for (Field field : fields) {
				TextField tf = field.getDeclaredAnnotation(TextField.class);
				if(tf != null) {
					String label = tf.label();
					if(label.equals("")) label = field.getName();
					form.addLabeledTextField(label, tf.size());
				}else {
					ChoiceField cf = field.getDeclaredAnnotation(ChoiceField.class);
					if(cf != null) {
						String label = cf.label();
						if(label.equals("")) label = field.getName();
						form.addChoicePanel(label,cf.type(),cf.items());
					}
				}
			}
		}
	}

	public Form getForme() {
		return form;
	}
}	
