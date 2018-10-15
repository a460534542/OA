package com.bwf.service;

import com.bwf.entity.AffairModule;

public interface IAffairModuleService {

	void add(AffairModule affairModule, String[] optionName, Integer[] optionId, String[] optionData,
			Integer[] approverId);

}
