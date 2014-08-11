package com.veterinaria.planner;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.dhtmlx.planner.DHXEv;
import com.dhtmlx.planner.DHXEvent;
import com.dhtmlx.planner.DHXEventsManager;
import com.dhtmlx.planner.DHXStatus;
import com.veterinaria.beans.Cita;
import com.veterinaria.service.CitaService;

public class CitaEvento extends DHXEventsManager {

	private static final Log log = LogFactory.getLog(CitaEvento.class);
	
	CitaService citaService = new CitaService();
	
	private HttpServletRequest request;
	public CitaEvento(HttpServletRequest request) {
		super(request);
		this.request = request;
	}

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");

	//Carga las citas iniciales	
	public Iterable<DHXEv> getEvents() {
		System.out.println("===== getEvents =====");

		//El planner acepta solo tipos DHXEv
		List<DHXEv> evs = new ArrayList<DHXEv>();
		
		try {
			List<Cita> citas = citaService.listarCita();
			for (Cita bean : citas) {
				DHXEvent cita1 = new DHXEvent();
				cita1.setText( bean.getIdCita() );
//				cita1.setId( bean.getIdCita() );
				cita1.setStart_date( bean.getFecIniProg() );
				cita1.setEnd_date( bean.getFecFinProg() );
				evs.add(cita1);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		return evs;
	}


	@Override
	public DHXStatus saveEvent(DHXEv event, DHXStatus status) {
		System.out.println("===== saveEvent =====");
		
		try {
			System.out.println("-->" + event.getText());
			System.out.println("-->" + event.getEnd_date());
			System.out.println("-->" + event.getId());
			System.out.println("-->" + event.getStart_date());
		
			if (status == DHXStatus.UPDATE) {
				System.out.println("---> UPATE");
				
			} else if (status == DHXStatus.DELETE) {
				System.out.println("---> DELETE");
				
			} else if (status == DHXStatus.INSERT) {
				System.out.println("---> INSERT");
				
				Cita bean = new Cita();
//				bean.setDescripcion(event.getText());
				bean.setFecIniProg( event.getStart_date() );
				bean.setFecFinProg( event.getEnd_date() );
				
				int salida = Integer.parseInt( citaService.GrabarCita(bean) );
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	@Override
	public DHXEv createEvent(String id, DHXStatus status) {
		System.out.println("===== saveEvent =====");

		return new DHXEvent();
	}
}
