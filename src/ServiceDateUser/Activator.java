package ServiceDateUser;

import java.util.Date;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceReference;
import org.knopflerfish.tutorial.ds.DS;



public class Activator implements BundleActivator {
  public static BundleContext bc = null;
  
	  public void start(BundleContext bc) throws Exception {
	    System.out.println(bc.getBundle().getHeaders().get(Constants.BUNDLE_NAME) +	" starting...");
	    Activator.bc = bc;
	
	  // log("starting");

	    ServiceReference reference = bc.getServiceReference (DS.class.getName());
			if (reference != null) {
			DS service = (DS)bc.getService(reference); System.out.println("Using DateService: formatting date: " +
			                      service.getFormattedDate(new Date()));
			  bc.ungetService(reference);
			} 
			else {
			System.out.println("No Service available!");
			}
			
	  }
	    
	public void stop(BundleContext bc) throws Exception {
		System.out.println(bc.getBundle().getHeaders()
                       .get(Constants.BUNDLE_NAME) +
                       " stopping...");
		Activator.bc = null;

	}
	
}