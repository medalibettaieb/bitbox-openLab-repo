package tn.esprit.infob1.openlab.presentation.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import tn.esprit.infob1.openlab.persistence.Teacher;
import tn.esprit.infob1.openlab.presentation.mbeans.TrainerBean;

@FacesConverter("tc")
public class TrainerConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null) {
			return null;
		}
		TrainerBean trainerBean = context.getApplication().evaluateExpressionGet(context, "#{trainerBean}",
				TrainerBean.class);
		Teacher teacher = trainerBean.doFindTeacherByName(value);

		return teacher;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		String string = null;
		if (value instanceof Teacher) {
			string=((Teacher) value).getName();
		}
		
		return string;
	}

}
