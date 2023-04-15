package javaSwing;

/**
 *
 * @author Leo
 */
public class LoginTeste {
    private String hostname;
    private String nomeUsuario;
    private String emailUsuario;
    private String senhaUsuario;

    public LoginTeste(String hostname, String nomeUsuario, String emailUsuario, String senhaUsuario) {
        this.hostname = hostname;
        this.nomeUsuario = nomeUsuario;
        this.emailUsuario = emailUsuario;
        this.senhaUsuario = senhaUsuario;
    }
    
    public LoginTeste() {
        
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    @Override
    public String toString() {
        return "LoginTeste{" + "hostname=" + hostname + ", nomeUsuario=" + nomeUsuario + ", emailUsuario=" + emailUsuario + ", senhaUsuario=" + senhaUsuario + '}';
    }
    
    
    
}
