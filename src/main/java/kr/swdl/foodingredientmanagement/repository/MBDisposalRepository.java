package kr.swdl.foodingredientmanagement.repository;

import kr.swdl.foodingredientmanagement.dto.DisposalListDTO;
import kr.swdl.foodingredientmanagement.dto.DisposalSerachFilterDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MBDisposalRepository {
    public List<DisposalListDTO> getDisposals(DisposalSerachFilterDTO disposalSerachFilterDTO);

    public int countByTodayDisposed();

    public int sumByTodayDisposedPrice();

    public int countNeedToConfirmByStoreId(int storeId);
}
