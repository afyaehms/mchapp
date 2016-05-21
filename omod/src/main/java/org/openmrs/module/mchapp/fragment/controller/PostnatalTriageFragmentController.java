package org.openmrs.module.mchapp.fragment.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.openmrs.Concept;
import org.openmrs.ConceptAnswer;
import org.openmrs.ConceptClass;
import org.openmrs.ConceptDatatype;
import org.openmrs.ConceptSearchResult;
import org.openmrs.Obs;
import org.openmrs.Patient;
import org.openmrs.api.context.Context;
import org.openmrs.module.mchapp.MchMetadata;
import org.openmrs.module.mchapp.ObsRequestParser;
import org.openmrs.module.mchapp.api.MchService;
import org.openmrs.ui.framework.SimpleObject;
import org.openmrs.ui.framework.page.PageRequest;
import org.springframework.web.bind.annotation.RequestParam;

public class PostnatalTriageFragmentController {
	public void controller() {
	}
	
	@SuppressWarnings("unchecked")
	public SimpleObject savePostnatalTriageInformation(@RequestParam("patientId") Patient patient, PageRequest request) {
		List<Obs> observations = new ArrayList<Obs>();
		for (Map.Entry<String, String[]> postedParams : 
			((Map<String, String[]>) request.getRequest().getParameterMap()).entrySet()) {
			try {
				observations = ObsRequestParser.parseRequestParameter(
						observations, patient, postedParams.getKey(),
						postedParams.getValue());
			} catch (Exception e) {
				return SimpleObject.create("status", "error", "message", e.getMessage());
			}
		}
		
		Context.getService(MchService.class).saveMchEncounter(patient, observations, Collections.EMPTY_LIST, MchMetadata._MchProgram.PNC_PROGRAM);
		
		return SimpleObject.create("status", "success", "message", "Triage information has been saved.");
	}
}
