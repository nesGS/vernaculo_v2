package com.nesGS.vernaculo_v2.mapper;

import com.nesGS.vernaculo_v2.dto.CreateClubDTO;
import com.nesGS.vernaculo_v2.persistence.model.Club;
import org.springframework.stereotype.Component;

@Component
public class CreateClubDTOToClub implements IMapper<CreateClubDTO, Club> {

    @Override
    public Club map(CreateClubDTO in) {
        Club club = new Club();
        club.setName(in.getName());
        club.setLocation(in.getLocation());
        club.setWebsite(in.getWebsite());
        return null;
    }
}
