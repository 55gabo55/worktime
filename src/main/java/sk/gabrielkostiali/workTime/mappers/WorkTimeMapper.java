package sk.gabrielkostiali.workTime.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import sk.gabrielkostiali.workTime.model.WorkTime;
import sk.gabrielkostiali.workTime.model.dto.WorkTimeDto;

@Mapper
public interface WorkTimeMapper {
    WorkTimeMapper INSTANCE = Mappers.getMapper(WorkTimeMapper.class);

    WorkTimeDto workTimeToDTO(WorkTime workTime);
    WorkTime workTimeDtoToWorkTime(WorkTimeDto workTimeDto);

}
