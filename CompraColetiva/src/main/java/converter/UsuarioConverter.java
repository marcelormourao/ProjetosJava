package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import model.Usuario;
import dao.UsuarioDao;

@FacesConverter(forClass=Usuario.class)
public class UsuarioConverter implements Converter{
	
	@Inject
	private UsuarioDao usuarioDao;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		if(value == null || value.isEmpty())
			return "";
		
		return usuarioDao.porNome(value);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		return value.toString();
	}

}
