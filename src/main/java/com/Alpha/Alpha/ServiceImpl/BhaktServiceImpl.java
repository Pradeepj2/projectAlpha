package com.Alpha.Alpha.ServiceImpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Alpha.Alpha.Dto.BhaktDto;
import com.Alpha.Alpha.Model.Bhakt;
import com.Alpha.Alpha.Repo.BhaktRepo;
import com.Alpha.Alpha.Service.BhaktService;
@Service
public class BhaktServiceImpl implements BhaktService{
	
	@Autowired
    private ModelMapper modelMapper;
    
	@Autowired
	private BhaktRepo bhaktRepo;
	
	
	@Override
    public boolean createBhakt(Bhakt bhakt) {
        //Bhakt bhakt = this.modelMapper.map(bhaktDto, Bhakt.class);
           this.bhaktRepo.save(bhakt);
           return true;
    }
//
//    private BhaktDto bhaktToDto(Bhakt bhakt) {
//           BhaktDto bhaktDto = this.modelMapper.map(bhakt, BhaktDto.class);
//           return bhaktDto;
//
//    }


	@Override
	public Bhakt findByMobileNo(String mobileNo) {
		return bhaktRepo.findByMobNo(mobileNo);
	}


	@Override
	public List<Bhakt> getAllPendingRequest() {
		return bhaktRepo.getAllPendingRequest();
	}


	@Override
	public void approve(String id) {
		bhaktRepo.approve(id);
		
	}
		
	}


