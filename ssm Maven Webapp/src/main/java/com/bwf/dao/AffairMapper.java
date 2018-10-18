package com.bwf.dao;

import java.util.List;

import com.bwf.entity.Affair;
import com.bwf.entity.User;

public interface AffairMapper {

	void add(Affair affair);

	List<Affair> getAffairByMe(User currentUser);

	Affair getAffairDetailByAffairId(Integer id);

}
