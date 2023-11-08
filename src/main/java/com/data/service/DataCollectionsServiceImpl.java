package com.data.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.binding.ChildRequest;
import com.data.binding.Children;
import com.data.binding.DcSummary;
import com.data.binding.Education;
import com.data.binding.Income;
import com.data.binding.PlanSelection;
import com.data.entity.DcCasesEntity;
import com.data.entity.DcChidren;
import com.data.entity.DcCitizenAppEntity;
import com.data.entity.DcEducation;
import com.data.entity.DcIncomeEntity;
import com.data.entity.PlanEntity;
import com.data.repository.DcCasesEntityRepository;
import com.data.repository.DcChildrenRepository;
import com.data.repository.DcCitizenAppEntityRepository;
import com.data.repository.DcEducationRepository;
import com.data.repository.DcIncomeEntityRepository;
import com.data.repository.DcPlanEntityRepository;

@Service
public class DataCollectionsServiceImpl implements DataCollectionsService {

	@Autowired
	private DcCasesEntityRepository dcCasesEntityRepository;

	@Autowired
	private DcChildrenRepository dcChildrenRepository;

	@Autowired
	private DcCitizenAppEntityRepository dcCitizenAppEntityRepository;

	@Autowired
	private DcEducationRepository dcEducationRepository;

	@Autowired
	private DcIncomeEntityRepository dcIncomeEntityRepository;

	@Autowired
	private DcPlanEntityRepository dcPlanEntityRepository;

	@Override
	public Long loadCaseNum(Integer appId) {

		 Optional<DcCitizenAppEntity> app = dcCitizenAppEntityRepository.findById(appId);

		if (app.isPresent()) {
			DcCasesEntity dce = new DcCasesEntity();
			dce.setAppId(appId);

			dce = dcCasesEntityRepository.save(dce);

			return dce.getCaseNum();
		}
		return 0l;
	}

	@Override
	public Map<Integer, String> getPlanNames() {
		List<PlanEntity> findall = dcPlanEntityRepository.findAll();
		Map<Integer, String> planmap = new HashMap<>();
		for (PlanEntity entity : findall) {
			planmap.put(entity.getPlanId(), entity.getPlanName());
		}
		return planmap;
	}

	@Override
	public Long savePlanSelection(PlanSelection planSelection) {
		Optional<DcCasesEntity> byId = dcCasesEntityRepository.findById(planSelection.getCaseNum());

		if (byId.isPresent()) {
			DcCasesEntity casesEntity = byId.get();
			casesEntity.setPlanId(planSelection.getPlanId());

			dcCasesEntityRepository.save(casesEntity);

		}
		return planSelection.getCaseNum();
	}

	@Override
	public Long saveIncomeData(Income income) {
		DcIncomeEntity die = new DcIncomeEntity();
		BeanUtils.copyProperties(income, die);
		dcIncomeEntityRepository.save(die);
		return income.getCaseNum();
	}

	@Override
	public Long saveEducation(Education education) {
		DcEducation de = new DcEducation();
		BeanUtils.copyProperties(education, de);
		dcEducationRepository.save(de);
		return de.getCaseNum();
	}

	@Override
	public Long saveChildrenDetails(ChildRequest request) {
		List<Children> childs = request.getChilds();

		for (Children child : childs) {
			DcChidren dcc = new DcChidren();
			BeanUtils.copyProperties(request, childs);
			dcChildrenRepository.save(dcc);
		}
		return request.getCaseNum();
	}

	@Override
	public DcSummary getSummary(Long caseNumber) {

		String planname = "";
		DcIncomeEntity incomeEntity = dcIncomeEntityRepository.findByCaseNum(caseNumber);
		DcEducation educationEntity = dcEducationRepository.findByCaseNum(caseNumber);
		List<DcChidren> childEntities = dcChildrenRepository.findByCaseNum(caseNumber);
		
		 Optional<DcCasesEntity> dcCase = dcCasesEntityRepository.findById(caseNumber);
		 if (dcCase.isPresent()) {
			Integer planId = dcCase.get().getPlanId();
			Optional<PlanEntity> plan = dcPlanEntityRepository.findById(planId);
			
			if(plan.isPresent()) {
				planname=plan.get().getPlanName();
			}
		
		 }

		DcSummary dcs = new DcSummary();
		dcs.setPlanName(planname);

		Education edu = new Education();
		BeanUtils.copyProperties(educationEntity, edu);
		dcs.setEducation(edu);

		Income inc = new Income();
		BeanUtils.copyProperties(incomeEntity, inc);
		dcs.setIncome(inc);

		List<Children> childs = new ArrayList<>();
		for (DcChidren entity : childEntities) {
			Children child = new Children();
			BeanUtils.copyProperties(entity, child);
		}
		dcs.setChildrens(childs);

		return dcs;
	}

}
