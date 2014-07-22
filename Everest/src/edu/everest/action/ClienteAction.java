package edu.everest.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import edu.everest.entity.Cliente;
import edu.everest.entity.Rol;
import edu.everest.entity.Usuario;
import edu.everest.service.ApplicationBusinessDelegate;
import edu.everest.service.ClienteService;
import edu.everest.service.UsuarioService;
import edu.everest.util.Constants;

@ParentPackage(value = "dawii")
public class ClienteAction extends ActionSupport{
	
	private static final long serialVersionUID = 2312605187941863156L;
	
	private static ApplicationBusinessDelegate abd = new ApplicationBusinessDelegate();
	private static ClienteService clienteService = abd.getClienteService();
	private static UsuarioService usuarioService = abd.getUsuarioService();
	
	private Cliente cliente;
	private List<Cliente> clienteLista;
	
	private Cliente familiar;
	private List<Cliente> familiarLista;
	
	private Usuario usuario;
	
	private String oper;
	private int id, idCliente, idTipoDocumento, idUsuario, idDIstrito, telefono, celular;
	private String dni, nombres, apePat, apeMat, sexo, fecNac, email, direccion, estado;
	
	DateFormat dateFormat = new SimpleDateFormat ("dd/MM/yyyy");
		
	@Action(value="/showClienteRegistroAction",
			results={ @Result(name="success", location="clienteRegistrarTile",type="tiles") })
	public String showClienteRegistrar() throws Exception{
		clienteLista = clienteService.obtenerTodosCliente();
		return SUCCESS;
	}
	
	@Action(value="/showClienteFormAction",
		results={ @Result(name="success", location="/mantenimiento/cliente/clienteForm.jsp") })
	public String showClienteForm() throws Exception{
		System.out.println("===== showClienteFormAction =====");
		System.out.println("oper: "+oper);
		
		if(oper != null)
			if(oper.equals("add")){
				cliente = new Cliente();
			}else if(oper.equals("edit")){
				System.out.println("idCliente: "+cliente.getIdCliente());
				cliente = clienteService.obtenerCliente(cliente);
			}
		
		return SUCCESS;
	}
	
	@Action(value="/showFamiliaresAction",
			results={ @Result(name="success", location="/mantenimiento/cliente/familiarMantenimiento.jsp") })
	public String showFamiliares() throws Exception{
		return SUCCESS;
	}
	
	@Action(value="obtenerClienteJSON",
			results={ @Result(name="success",type="json") })
	public String obtenerClienteJSON() throws Exception{
		try{
			clienteLista = clienteService.obtenerTodosCliente();
		}catch(Exception ex){
			syso("obtenerClienteJSON: "+ex);
		}
		return SUCCESS;
	}
	
	@Action(value="mantenimientoClienteJSON",
			results={ @Result(name="success",type="json"),
					  @Result(name="input", location="clienteRegistrarTile", type="tiles") })
	public String MantenimientoJSON() throws Exception{
		try{
			
			syso("oper: "+oper);
			syso("[idCliente]["+idCliente+"]");
			syso("[id]["+id+"]");
			syso("[idUsuario]["+idUsuario+"]");
			syso("[idTipoDocumento]["+idTipoDocumento+"]");
			
			cliente = new Cliente();
			Usuario objUsuario;
			Rol objRol;
			
			if(oper.equals("del")){
				if(idCliente ==0)
					idCliente = id;
				
				cliente.setIdCliente( idCliente );
				cliente = clienteService.obtenerCliente(cliente);
				
			}else{
				cliente.setIdCliente( idCliente );
//				cliente.setIdDIstrito(idDIstrito);
				cliente.setDni(dni);
				cliente.setNombres(nombres);
				cliente.setApePat(apePat);
				cliente.setApeMat(apeMat);
				cliente.setSexo(sexo);
								
				if(!fecNac.equals(""))
					cliente.setFecNac( dateFormat.parse(fecNac) );
				
				cliente.setEmail(email);
				cliente.setTelefono(telefono);
				cliente.setCelular(celular);
				cliente.setDireccion(direccion);
			}
			
			if(oper.equals("add")){
				
				if(cliente.getEmail() != null){
					syso("Registrando Usuario...");
					objUsuario = new Usuario();
					objUsuario.setUser( cliente.getEmail() );
					objUsuario.setPass( cliente.getDni() );
					
					objRol = new Rol();
					objRol.setIdRol( Constants.KV_ROL_CLIENTE );
					
					objUsuario.setRol( objRol );
					objUsuario = usuarioService.insertarUsuario(objUsuario);
					
					cliente.setUsuario(objUsuario);					
				}
				
				clienteService.insertarCliente(cliente);
			}else if(oper.equals("edit")){
				cliente.setUsuario(usuario);
				clienteService.actualizarCliente(cliente);
			}else if(oper.equals("del")){
				clienteService.eliminarCliente(cliente);
			}
		}catch(Exception ex){
			syso("MantenimientoJSON: "+ex);
		}
		
		return SUCCESS;
	}
	
	@Action(value="obtenerFamliaresJSON",
			results={ @Result(name="success",type="json") })
	public String obtenerFamliaresJSON() throws Exception{
		try{
			syso("idCliente: "+cliente.getIdCliente());
			
			familiarLista = clienteService.obtenerFamiliares(cliente);
		}catch(Exception ex){
			syso("obtenerFamliaresJSON: "+ex);
		}
		return SUCCESS;
	}
	
	public void syso(String str){
		System.out.println("[ClienteAction."+str+"]");
	}

	public static ClienteService getClienteService() {
		return clienteService;
	}

	public static void setClienteService(ClienteService clienteService) {
		ClienteAction.clienteService = clienteService;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClienteLista() {
		return clienteLista;
	}

	public void setClienteLista(List<Cliente> clienteLista) {
		this.clienteLista = clienteLista;
	}

	public String getOper() {
		return oper;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdTipoDocumento() {
		return idTipoDocumento;
	}

	public void setIdTipoDocumento(int idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdDIstrito() {
		return idDIstrito;
	}

	public void setIdDIstrito(int idDIstrito) {
		this.idDIstrito = idDIstrito;
	}
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApePat() {
		return apePat;
	}

	public void setApePat(String apePat) {
		this.apePat = apePat;
	}

	public String getApeMat() {
		return apeMat;
	}

	public void setApeMat(String apeMat) {
		this.apeMat = apeMat;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getFecNac() {
		return fecNac;
	}

	public void setFecNac(String fecNac) {
		this.fecNac = fecNac;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public int getCelular() {
		return celular;
	}

	public void setCelular(int celular) {
		this.celular = celular;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Cliente getFamiliar() {
		return familiar;
	}

	public void setFamiliar(Cliente familiar) {
		this.familiar = familiar;
	}

	public List<Cliente> getFamiliarLista() {
		return familiarLista;
	}

	public void setFamiliarLista(List<Cliente> familiarLista) {
		this.familiarLista = familiarLista;
	}
	
}

