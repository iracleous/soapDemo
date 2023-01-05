package gr.codehub.soapdemo.resources;

 
import gr.codehub.soapdemo.account.AccountWSItf;
import jakarta.ejb.LocalBean;
 
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
 
import jakarta.ws.rs.core.Response;
import jakarta.xml.ws.WebServiceRef;
 

/**
 *
 * @author
 */
@Path("j")
@LocalBean
public class JavaEE8Resource {
 
    @WebServiceRef(wsdlLocation="httр://lосаlhоst:8080/hellоserviсe/hellо?wsdl")
        private  AccountWSItf provider;

 
    @GET
    @Path("a")
    public Response ping() {
        return Response
                .ok("ping")
                .build();
    }

  
 @GET
 @Path("p")
    public String pang() {
        
        
        
        
        
        return "r";
    }
    
    
}
