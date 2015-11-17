package util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MessagesUtil {
	
	public static void addInformationMessage(String mensagem){
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, mensagem);
		FacesContext.getCurrentInstance().addMessage("Info", facesMessage);
	}
	
	public static void addErrorMessage(String mensagem){
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, mensagem);
		FacesContext.getCurrentInstance().addMessage("Erro", facesMessage);
	}
}
