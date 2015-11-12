package util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MessagesUtil {
	
	private static FacesContext context = FacesContext.getCurrentInstance();
	
	public static void addInformationMessage(String mensagem){
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, mensagem);
		context.addMessage("Info", facesMessage);
	}
	
	public static void addErrorMessage(String mensagem){
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, mensagem);
		context.addMessage("Erro", facesMessage);
	}
}
