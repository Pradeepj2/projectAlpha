package com.Alpha.Alpha.Service;

import java.util.List;

import com.Alpha.Alpha.Dto.BhaktDto;
import com.Alpha.Alpha.Model.Bhakt;

public interface BhaktService {
   public boolean createBhakt(Bhakt bhakt);

public Bhakt findByMobileNo(String mobileNo);

public List<Bhakt> getAllPendingRequest();

public void approve(String id); 
}
